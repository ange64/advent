package org.example.problems.year2025;

import org.example.template.Template;
import org.example.template.primitive.collections.integer.IntList;

import java.util.Arrays;

public class Pb6 extends Template<String[]> {


    public Pb6() {
        super(2025, 6, "Trash Compactor");
    }

    @Override
    protected void exec_part_1(String[] data) throws Exception {
        String[][] grid = Arrays.stream(data).map(it -> it.trim().split("\\s+")).toArray(String[][]::new);
        long sum = 0;
        for (int j = 0; j < grid[0].length; j++) {
            char operator = grid[grid.length - 1][j].charAt(0);
            long acc = Integer.parseInt(grid[0][j]);
            for (int i = 1; i < grid.length - 1; i++) {
                acc = accumulate(Integer.parseInt(grid[i][j]), operator, acc);
            }
            sum += acc;
        }
        System.out.println(sum);
    }

    @Override
    protected void exec_part_2(String[] data) throws Exception {
        String operators = data[data.length - 1];
        var list = new IntList(); //indices of operators are on least significant digit
        for (int i = 0; i < operators.length(); i++) {
            if (operators.charAt(i) == ' ') continue;
            list.add(i);
        }
        list.add(operators.length() + 2);
        long sum = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            char[][] operation = new char[data.length - 1][];
            for (int j = 0; j < data.length - 1; j++) {
                operation[j] = data[j].substring(list.get(i), list.get(i + 1) - 1).toCharArray();
            }
            char operator = operators.charAt(list.get(i));
            long acc = operator == '*' ? 1 : 0;
            for (int col = 0; col < operation[0].length; col++) {
                int pow = 1;
                int n = 0;
                for (int row = operation.length - 1; row >= 0; row--) {
                    char c = operation[row][col];
                    if (c == ' ') continue;
                    n += (c - '0') * pow;
                    pow *= 10;
                }
                acc = operator == '*' ? acc * n : acc + n;
            }
        }

        System.out.println(sum);
    }

    private long accumulate(int current, char operator, long acc) {
        return switch (operator) {
            case '+' -> acc + current;
            case '*' -> acc * current;
            case '-' -> acc - current;
            case '/' -> acc / current;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }

    @Override
    protected String[] parseInput(String[] lines) {
        return lines;
    }

}
