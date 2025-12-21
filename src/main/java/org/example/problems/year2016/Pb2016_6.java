package org.example.problems.year2016;

import org.example.template.Template;

import java.util.Arrays;

public class Pb2016_6 extends Template<char[][]> {

    public Pb2016_6() {
        super(2016, 6, "Day 6: Signals and Noise");
    }

    @Override
    protected void exec_part_1(char[][] data) throws Exception {
        char[][] histogram = new char[data[0].length][26];
        char[] message = new char[data[0].length];
        for (int j = 0; j < data[0].length; j++) {
            int columnMax = 0;
            for (char[] row : data) {
                int freq = ++histogram[j][row[j] - 'a'];
                if (freq > columnMax) {
                    columnMax = freq;
                    message[j] = row[j];
                }
            }
        }
        System.out.println(new String(message));
    }

    @Override
    protected void exec_part_2(char[][] data) throws Exception {
        char[][] histogram = new char[data[0].length][26];
        char[] message = new char[data[0].length];
        for (int j = 0; j < data[0].length; j++) {
            for (char[] row : data) {
                histogram[j][row[j] - 'a']++;
            }
            int columnMin = 100000;
            for (int i = 0; i < 26; i++) {
                if (histogram[j][i] == 0) continue;
                if (histogram[j][i] < columnMin) {
                    columnMin = histogram[j][i];
                    message[j] = (char) (i + 'a');
                }
            }

        }
        System.out.println(new String(message));
    }

    @Override
    protected char[][] parseInput(String[] lines) {
        return Arrays.stream(lines).map(String::toCharArray).toArray(char[][]::new);
    }
}
