package org.example.problems.year2025;

import org.example.template.Template;

import java.util.Arrays;

public class Pb2025_3 extends Template<char[][]> {

    public Pb2025_3() {
        super(2025, 3, "--- Day 3: Lobby ---");
    }

    @Override
    protected void exec_part_1(char[][] data) throws Exception {
        int sum = 0;
        for (var row : data) {
            char m1 = 0;
            char m2 = 0;
            int firstIdx = 0;
            for (int i = 0; i < row.length - 1; i++) {
                if (row[i] > m1) {
                    m1 = row[i];
                    firstIdx = i;
                }
                if (m1 == '9') break;
            }
            for (int j = row.length - 1; j > firstIdx; j--) {
                if (row[j] > m2) m2 = row[j];
            }
        }
        System.out.println(sum);
    }

    @Override
    protected void exec_part_2(char[][] data) throws Exception {
        long sum = 0;
        for (var row : data) {
            char[] digits = new char[12];
            int start = 0;
            int stop = row.length - digits.length;
            for (int i = 0; i < digits.length; i++) {
                char m = '0';
                stop++;
                for (int j = start; j < stop; j++) {
                    if (row[j] > m) {
                        m = row[j];
                        start = j + 1;
                    }
                }
                digits[i] = m;
            }
            sum += Long.parseLong(new String(digits));
        }
        System.out.println(sum);
    }

    @Override
    protected char[][] parseInput(String[] lines) {
        return Arrays.stream(lines).map(String::toCharArray).toArray(char[][]::new);
    }
}
