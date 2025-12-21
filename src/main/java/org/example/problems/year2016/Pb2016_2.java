package org.example.problems.year2016;

import org.example.template.Template;

import java.util.ArrayList;
import java.util.List;

public class Pb2016_2 extends Template<String[]> {
    private static final char[][] keypad = new char[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    private static final char[][] keypad2 = new char[][]{
            {0, 0, '1', 0, 0},
            {0, '2', '3', '4', 0},
            {'5', '6', '7', '8', '9'},
            {0, 'A', 'B', 'C', 0},
            {0, 0, 'D', 0, 0}};

    private int x = 0;
    private int y = 2;

    public Pb2016_2() {
        super(2016, 2, "Day 2: Bathroom Security");

    }

    @Override
    public void exec_part_1(String[] data) {
        List<Character> result = new ArrayList<>();
        for (String row : data) {
            for (char c : row.toCharArray()) {
                switch (c) {
                    case 'U' -> move2(0, -1);
                    case 'D' -> move2(0, 1);
                    case 'L' -> move2(-1, 0);
                    case 'R' -> move2(1, 0);
                }
            }
            result.add(keypad2[y][x]);
        }
        System.out.println("result : " + result);
    }

    @Override
    protected void exec_part_2(String[] data) throws Exception {

    }


    @Override
    protected String[] parseInput(String[] lines) {
        return lines;
    }

    private void move(int dx, int dy) {
        if (x + dx >= 0 && x + dx <= 2) x += dx;
        if (y + dy >= 0 && y + dy <= 2) y += dy;
    }

    private void move2(int dx, int dy) {
        if (dx + x >= 0 && dx + x <= 4 && keypad2[dx + x][y] != 0) x += dx;
        if (y + dy >= 0 && y + dy <= 4 && keypad2[x][y + dy] != 0) y += dy;
    }

}
