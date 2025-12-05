package org.example.problems.year2016;

import org.example.template.Template;

import java.util.Arrays;

public class Pb2016_3 extends Template<int[][]> {

    public Pb2016_3() {
        super(2016, 3, "Day 3: Squares With Three Sides");
    }

    @Override
    protected void exec_part_1(int[][] data) {
        int valid = 0;
        for (int[] length : data) {
            Arrays.sort(length);
            if (length[0] + length[1] > length[2]) valid++;
        }
        System.out.println(valid);
    }

    @Override
    protected void exec_part_2(int[][] data) throws Exception {

    }

    @Override
    protected int[][] parseInput(String[] lines) {
        int[][] parsed = new int[lines.length][];
        int i = 0;
        for (String line : lines) {
            String[] elems = line.split(" +");
            parsed[i++] = new int[] {Integer.parseInt(elems[1]), Integer.parseInt(elems[2]), Integer.parseInt(elems[3])};
            System.out.println(Arrays.toString(parsed[i - 1]));
        }
        return parsed;
    }
}
