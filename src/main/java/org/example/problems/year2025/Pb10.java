package org.example.problems.year2025;

import org.example.template.Template;
import org.example.template.Utils;
import org.example.template.primitive.PUtils;
import org.example.template.primitive.arrays.ArrUtils;

import java.util.*;

public class Pb10 extends Template<Pb10.Command[]> {

    public Pb10() {
        super(2025, 10, "Factory");
    }

    @Override
    protected void exec_part_1(Command[] data) throws Exception {
        int sum = 0;
        for (Command c : data) {
            sum += minMoves(c);
        }
        List<Integer> max = new ArrayList<>();
        for (Command datum : data) {
            max.add(datum.buttons.length - datum.jolt.length);
            System.out.println(datum.buttons.length - datum.jolt.length);
        }
        System.out.println(max.stream().max(Comparator.comparingInt(o -> o)));
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
        int sum = 0;
        for (Command c : data) {
            int[] uppers = upperBounds(c);
            int[][] m = matricize(c.jolt, c.buttons);
            reduce(m);
            //Utils.print2dArray(m, "| ",3);
        }
        System.out.println("sum " + sum);
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


    int[][] matricize(int[] target, int[]buttons) {
        //vectorize butons into matrix
        int start = (int) Math.pow(10, buttons.length - 1);
        int[][] matrix = new int[target.length][buttons.length + 2];
        for (int i = 0; i < buttons.length; i++) {
            int b = buttons[i];
            for (int k = 0; k < matrix.length; k++) {
                matrix[k][i] = (b >> k) & 1;
                matrix[k][matrix[0].length - 1] += matrix[k][i] * start;
            }
            start /= 10;
        }
        for (int i = 0; i < target.length; i++) {
            matrix[i][buttons.length] = target[i];
        }
        Arrays.sort(matrix, Comparator.comparingInt(value -> 10000000 - value[value.length - 1]));
        return matrix;
    }


    private void reduce(int[][] matrix) {

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
