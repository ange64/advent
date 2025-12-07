package org.example.problems.year2016;

import org.example.template.Template;
import org.example.template.Utils;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;

public class Pb13 extends Template<Integer> {
    private static final int MAX_SIZE = 32;

    public Pb13() {
        super(2016, 13, "A Maze of Twisty Little Cubicles");
    }

    @Override
    protected void exec_part_1(Integer data) throws Exception {
        char[][] display = new char[MAX_SIZE][MAX_SIZE];
        for (var row : display) {
            Arrays.fill(row, '.');
        }
        var visited = new HashSet<Integer>();
        var candidates = new ArrayDeque<Integer>();
        candidates.add(pack(1, 1));
        int depth = 0;
        int locations = 0;
        outer:
        while (!candidates.isEmpty() && depth <= 50) {
            int leftOnLevel = candidates.size();
            while (leftOnLevel-- > 0) {
                int first = candidates.pop();
                if (visited.contains(first)) continue;
                visited.add(first);
                int y = first >> 8;
                int x = first & 255;
                display[y][x] = '@';
                if (isWall(y, x, data)) continue;
                locations++;
                display[y][x] = '+';
                candidates.add(pack(y + 1, x));
                candidates.add(pack(y, x + 1));
                if (y - 1 >= 0) candidates.add(pack(y - 1, x));
                if (x - 1 >= 0) candidates.add(pack(y, x - 1));
            }
            depth++;
        }
        Utils.print2dArray(display, "", 0);
        System.out.println(depth + " " + locations);
        int verif = 0;
        for (char[] chars : display) {
            for (char aChar : chars) {
                if (aChar == '+') verif++;
            }
        }
        System.out.println(verif);
    }

    boolean isWall(int y, int x, int seed) {
        int temp = (x * x) + (3 * x) + (2 * x * y) + y + (y * y);
        return (Integer.bitCount(temp + seed) & 1) == 1;
    }

    private int pack(int a, int b) {
        return (a << 8) | b;
    }

    @Override
    protected void exec_part_2(Integer data) throws Exception {

    }

    @Override
    protected Integer parseInput(String[] lines) {
        return Integer.parseInt(lines[0]);
    }
}
