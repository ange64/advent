package org.example.problems.year2025;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.exception.ContradictionException;
import org.chocosolver.solver.search.strategy.Search;
import org.chocosolver.solver.variables.IntVar;
import org.example.template.Template;
import org.example.template.Utils;
import org.example.template.primitive.PUtils;
import org.example.template.primitive.arrays.ArrUtils;
import org.example.template.primitive.arrays.GridUtils;
import org.example.template.primitive.collections.integer.IntList;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class Pb10 extends Template<Pb10.Command[]> {

    public Pb10() {
        super(2025, 10, "Factory");
    }

    @Override
    protected void exec_part_1(Command[] data) throws Exception {
    }

    int minMoves(Command target) {
        int lights = 0;
        var visited = new HashSet<Integer>();
        var queue = new ArrayDeque<Integer>();
        queue.add(lights);
        int nbMoves = 0;
        outer:
        while (!queue.isEmpty()) {
            int onLevel = queue.size();
            while (onLevel-- > 0) {
                int currLights = queue.pop();
                if (currLights == target.lights) break outer;
                if (visited.contains(currLights)) continue;
                visited.add(currLights);
                for (int b : target.buttons) {
                    queue.add(currLights ^ b);
                }
            }
            nbMoves++;
        }
        return nbMoves;
    }


    @Override
    protected void exec_part_2(Command[] data) throws Exception {
        AtomicInteger total = new AtomicInteger();
        var all = Arrays.stream(data).parallel().map(c -> {
            Model m = new Model();
            IntVar[] presses = m.intVarArray("p", c.butt2.length, 0, ArrUtils.max(c.jolt));
            IntVar t = m.intVar("tot", 0, 300);
            m.sum(presses, "=", t).post();
            for (int i = 0; i < c.jolt.length; i++) {
                var list = new ArrayList<IntVar>();
                for (int j = 0; j < c.butt2.length; j++) {
                    int idx = ArrUtils.indexOf(c.butt2[j], i);
                    if (idx != -1) list.add(presses[j]);
                }
                m.sum(list.toArray(IntVar[]::new), "=", c.jolt[i]).post();
            }
            var s = m.getSolver();
            s.setSearch(Search.minDomLBSearch(presses));
            try {
                s.propagate();
            } catch (ContradictionException e) {
                throw new RuntimeException(e);
            }
            var sol = s.findOptimalSolution(t, Model.MINIMIZE);
            System.out.println(sol.getIntVal(t));
            return sol.getIntVal(t);
        }).toList();
        System.out.println(all.stream().reduce(0, Integer::sum));
    }

    private int[] upperBounds(Command c) {
        int[] upperBounds = ArrUtils.init(new int[c.buttons.length], () -> 1_000_000);
        for (int i = 0; i < c.buttons.length; i++) {
            int b = c.buttons[i];
            for (int j = 0; j < c.jolt.length; j++) {
                if (((b >> j) & 1) == 0) continue;
                if (c.jolt[j] < upperBounds[i]) {
                    upperBounds[i] = c.jolt[j];
                }
            }
        }
        return upperBounds;
    }


    int[][] matricize(int[] target, int[] buttons) {
        //vectorize butons into matrix
        int[][] matrix = new int[target.length][buttons.length + 1];
        for (int i = 0; i < buttons.length; i++) {
            int b = buttons[i];
            for (int k = 0; k < matrix.length; k++) {
                matrix[k][i] = (b >> k) & 1;
            }
        }
        for (int i = 0; i < target.length; i++) {
            matrix[i][buttons.length] = target[i];
        }
        Utils.print2dArray(matrix, " ", 2);
        return matrix;
    }


    private boolean rowEchelonForm(int[][] mat) {
        int H = mat.length;
        int L = mat[0].length;
        int maxRows = Math.min(H, L - 1);
        int d;
        for (d = 0; d < maxRows; d++) { // for each diagonal elements
            int d2 = GridUtils.firstRow(mat, d, d, cell -> cell != 0);
            if (d2 == -1) continue;
            GridUtils.swapRows(mat, d, d2);
            int pivotCol = ArrUtils.first(mat[d], i -> i != 0);
            if (pivotCol == -1) continue; // whole line is zero
            if (pivotCol == L - 1) return false; //unsolvable state, all coeff zeros but result nonzero
            for (int j = d + 1; j < H; j++) {
                mulAddRow(mat[j], mat[d], pivotCol);
            }
        }
        return true;
    }


    private int[] backSubstitution(int[][] mat) {
        int H = mat.length;
        int L = mat[0].length;
        int maxRows = Math.min(H, L - 1);
        int[] pivots = new int[L - 1];
        for (int i = maxRows - 1; i >= 0; i--) {
            int pivotCol = i;
            while (pivotCol < L && mat[i][pivotCol] == 0) pivotCol++;
            if (pivotCol >= L - 1) continue;
            pivots[pivotCol] = i + 1;
            int pivotValue = mat[i][pivotCol];
            if (Math.abs(pivotValue) != 1)// reduce factors
                for (int k = pivotCol; k < L; k++)
                    mat[i][k] /= pivotValue;
            for (int row = i - 1; row >= 0; row--) {
                mulAddRow(mat[row], mat[i], pivotCol);
            }
        }
        for (int i = 0; i < H; i++) {
            if (mat[i][L - 1] > 0) continue;
            for (int j = 0; j < L; j++) mat[i][j] = -mat[i][j];
        }
        return pivots;
    }

    private void mulAddRow(int[] target, int[] ref, int pivotCol) {
        if (target[pivotCol] == 0) return;
        int factor = target[pivotCol];
        int neg = target[target.length - 1] * ref[pivotCol] < ref[target.length - 1] * factor ? -1 : 1;
        for (int i = 0; i < target.length; i++) {
            target[i] *= ref[pivotCol];
            target[i] -= ref[i] * factor;
            target[i] *= neg;
        }
    }

    private int[][] parseSolutions(int[][] mat, int[] pivots) {
        IntList free = new IntList(mat[0].length - 1);
        for (int i = 0; i < pivots.length; i++) {
            if (pivots[i] == 0) free.add(i);
        }
        int[][] sol = new int[free.size() + 1][mat[0].length - 1];
        int freeIdx = 0;
        for (int i = 0; i < pivots.length; i++) {
            if (pivots[i] > 0) {
                sol[0][i] = mat[pivots[i] - 1][mat[0].length - 1];
                for (int j = 0; j < free.size(); j++) {
                    sol[j + 1][i] = -mat[pivots[i] - 1][free.get(j)];
                }
            } else {
                sol[freeIdx++ + 1][i] = 1;
            }
        }
        Utils.print2dArray(sol, "| ", 4);
        return sol;
    }

    private int findSystemSolutions(int[][] mat) {
        Utils.print2dArray(mat, ",", 3);
        if (!rowEchelonForm(mat)) return -1;
        visited.clear();
        int[] pivots = backSubstitution(mat);
        Utils.print2dArray(mat, ",", 3);
        int[][] sols = parseSolutions(mat, pivots);
        if (sols.length == 1) {
            System.out.println("no free variables : " + ArrUtils.sum(sols[0]));
            return (int) ArrUtils.sum(sols[0]);
        }
        int[] minsum = new int[]{100000};
        explore(sols, new int[sols.length - 1], minsum, 0);
        System.out.println("min sum found " + minsum[0]);

        return minsum[0];
    }

    HashSet<Long> visited = new HashSet<>();
    int[] buttons;
    int maxDepth = 200;

    void explore(int[][] sols, int[] factors, int[] minSum, int depth) {
        ;
        if (depth == maxDepth) return;
        int currSum = 0;
        boolean hasNeg = false;
        int[] current = sols[0].clone();
        for (int i = 0; i < sols[0].length; i++) {
            for (int j = 1; j < sols.length; j++) {
                current[i] += sols[j][i] * factors[j - 1];
            }
            currSum += current[i];
            if (current[i] < 0) hasNeg = true;
        }
        long hash = ((long) depth << 48 | (long) currSum << 32 | Arrays.hashCode(factors));
        if (visited.contains(hash)) return;
        visited.add(hash);
        if (!hasNeg && currSum < minSum[0]) {
            buttons = current;
            System.out.println("found better solution : " + currSum + " " + Arrays.toString(current) + " " + Arrays.toString(factors));
            minSum[0] = currSum;
            visited.remove(hash);
        }
        for (int i = 0; i < sols.length - 1; i++) { //for each free variable
            factors[i]++;
            explore(sols, factors, minSum, depth + 1);
            factors[i]--;
        }
    }

    @Override
    protected Command[] parseInput(String[] lines) {
        var result = new Command[lines.length];
        for (int i = 0; i < lines.length; i++) {
            String[] split = lines[i].split(" ");
            int lights = 0;
            for (int j = 1; j < split[0].length() - 1; j++) {
                if (split[0].charAt(j) == '.') continue;
                lights |= (1 << (j - 1));
            }
            int[] buttons = new int[split.length - 2];
            int[][] but2 = new int[split.length - 2][];
            for (int j = 1; j < split.length - 1; j++) {
                String[] buttonDigits = split[j].substring(1, split[j].length() - 1).split(",");
                but2[j - 1] = ArrUtils.strToI(buttonDigits);
                for (String bd : buttonDigits) {
                    buttons[j - 1] |= 1 << (bd.charAt(0) - '0');
                }
            }
            String last = split[split.length - 1];
            int[] jolts = ArrUtils.strToI(last.substring(1, last.length() - 1).split(","));
            result[i] = new Command(lights, buttons, but2, jolts);
            //System.out.println(result[i]);
        }
        return result;
    }

    record Command(int lights, int[] buttons, int[][] butt2, int[] jolt) {
        @Override
        public String toString() {
            return "L " + PUtils.toBits(lights, 10) +
                    "   B" + Arrays.toString(ArrUtils.map(buttons, i -> PUtils.toBits(i, 10))) +
                    "   J" + Arrays.toString(jolt);
        }
    }
}
