package org.example.problems.year2025;

import org.example.template.Template;
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
        System.out.println("sum " + sum);
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
            sum += solveMinMove(uppers, c.jolt, c.buttons);
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

    private int solveMinMove(int[] upper, int[] target, int[] buttons) {
        var queue = new ArrayDeque<int[][]>();
        var visited = new HashSet<Integer>();
        var start = new int[2][target.length];
        start[1] = upper.clone();
        queue.add(start);
        int depth = 0;
        int nbLoops = 0;
        outer:
        while (!queue.isEmpty()) {
            int leftOnLevel = queue.size();
            while (leftOnLevel-- > 0) {
                int[] current = queue.getFirst()[0];
                int[] upperCurrent = queue.pop()[1];
                if (Arrays.equals(target, current)) break outer;
                if (visited.contains(Arrays.hashCode(current))) continue;
                visited.add(Arrays.hashCode(current));
                for (int i = 0; i < upperCurrent.length; i++) {
                    if (upperCurrent[i] == 0) continue;
                    int[] child = current.clone();
                    for (int k = 0; k < child.length; k++) {
                        child[k] += (buttons[i] >> k) & 1;
                    }
                    if (ArrUtils.any(child, (v, idx) -> v > target[idx])) continue;
                    int[] childUpper = upperCurrent.clone();
                    for (int j = 0; j < buttons.length; j++) {
                        childUpper[j] -= (buttons[j] >> i) & 1;
                    }
                    nbLoops++;
                    queue.add(new int[][]{child,childUpper});
                }
            }
            depth++;
        }
        System.out.println(nbLoops);
        System.out.println(depth);
        return depth;
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
            System.out.println(result[i]);
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
