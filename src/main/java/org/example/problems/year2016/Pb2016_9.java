package org.example.problems.year2016;

import org.example.template.Template;

import java.util.Arrays;

public class Pb2016_9 extends Template<char[]> {

    public Pb2016_9() {
        super(2016, 9, "Explosives in Cyberspace");
    }

    @Override
    protected void exec_part_1(char[] data) throws Exception {
        int totalLen = 0;
        long currLEn = data.length;
        int start = 1;
        while (start < data.length) {
            if (Character.isDigit(data[start]) && data[start - 1] == '(') {
                RepeatInfo info = parseRepeat(start, data);
                currLEn -= info.size;
                currLEn += info.nbAffected * (info.factor - 1);
                start = (int) (info.endIdx + 1 + info.nbAffected);
            } else {
                start++;
            }
        }
        System.out.println("row len : " + currLEn);
    }


    @Override
    protected void exec_part_2(char[] data) throws Exception {
        long currLEn = data.length;
        int start = 1;
        long factor = 1;
        int[] factorEndsAt = new int[data.length + 1];
        Arrays.fill(factorEndsAt, 1);
        while (start < data.length) {
            if (Character.isDigit(data[start]) && data[start - 1] == '(') {
                RepeatInfo info = parseRepeat(start, data);
                currLEn -= info.size * factor;
                currLEn += info.nbAffected * (info.factor - 1) * factor;
                factor *= info.factor;
                factorEndsAt[(int) (info.endIdx + info.nbAffected)] *= (int) info.factor;
                while (start < info.endIdx + 1) {
                    factor /= factorEndsAt[++start];
                }
            } else {
                start++;
                factor /= factorEndsAt[start];
            }
        }
        System.out.println("row len : " + currLEn);
    }

    private RepeatInfo parseRepeat(int start, char[] row) {
        int end = start + 1;
        while (end < row.length && Character.isDigit(row[end])) end++;
        if (end == row.length || row[end] != 'x') return new RepeatInfo(-1, -1, end, -1);
        int xIdx = end++;
        while (end < row.length && Character.isDigit(row[end])) end++;
        if (end == row.length || row[end] != ')') return new RepeatInfo(-1, -1, end, -1);
        int a = Integer.parseInt(new String(row, start, xIdx - start));
        int b = Integer.parseInt(new String(row, xIdx + 1, end - xIdx - 1));
        return new RepeatInfo(a, b, end, end - start + 2);
    }

    private record RepeatInfo(long nbAffected, long factor, long endIdx, long size) {
    }


    @Override
    protected char[] parseInput(String[] lines) {
        return String.join("", lines).toCharArray();
    }
}
