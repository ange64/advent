package org.example.problems.year2025;

import org.example.template.Template;
import org.example.template.primitive.collections.integer.IntList;

public class Pb2025_4 extends Template<byte[][]> {

    public Pb2025_4() {
        super(2025, 4, "--- Day 4: Printing Department ---");
    }

    @Override
    protected void exec_part_1(byte[][] data) throws Exception {
        int movable = 0;
        for (int i = 1; i < data.length - 1; i++) {
            for (int j = 1; j < data[0].length - 1; j++) {
                if (data[i][j] == 0) continue;
                int neighborUp = data[i - 1][j - 1] + data[i - 1][j] + data[i - 1][j + 1];
                int sides = data[i][j - 1] + data[i][j + 1];
                int neighborDown = data[i + 1][j - 1] + data[i + 1][j] + data[i + 1][j + 1];
                if (neighborDown + neighborUp + sides < 4) movable++;
            }
        }
        System.out.println(movable);
    }

    @Override
    protected void exec_part_2(byte[][] data) throws Exception {
        IntList list = new IntList();
        int moves = 0;
        int n = 0;
        do {
            n = execMove(data, list);
            moves += n;
        } while (n > 0);
        System.out.println("final moves : " + moves);
    }

    private int execMove(byte[][] data, IntList out) {
        int movable = 0;
        for (int i = 1; i < data.length - 1; i++) {
            for (int j = 1; j < data[0].length - 1; j++) {
                if (data[i][j] == 0) continue;
                int neighborUp = data[i - 1][j - 1] + data[i - 1][j] + data[i - 1][j + 1];
                int sides = data[i][j - 1] + data[i][j + 1];
                int neighborDown = data[i + 1][j - 1] + data[i + 1][j] + data[i + 1][j + 1];
                if (neighborDown + neighborUp + sides < 4) {
                    movable++;
                    out.add((i << 16) | j);
                }
            }
        }
        for (int i = 0; i < out.size(); i++) {
            int idx = out.get(i);
            data[idx >>> 16][idx & 0xFFFF] = 0;
        }
        out.clear();
        return movable;
    }

    @Override
    protected byte[][] parseInput(String[] lines) {
        if (lines.length == 0) return null;
        byte[][] data = new byte[lines.length + 2][lines[0].length() + 2];
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[0].length(); j++) {
                char c = lines[i].charAt(j);
                data[i + 1][j + 1] = (byte) (c == '.' ? 0 : 1);
            }
        }
        return data;
    }
}
