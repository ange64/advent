package org.example.problems;

import org.example.template.Template;
import org.example.template.Utils;

import java.util.Arrays;

public class Pb2025_2 extends Template<long[]> {

    private static final long[] minBounds = new long[]{
            10, 1_000, 100_000, 10_000_000, 1_000_000_000, 100_000_000_000L, 10_000_000_000_000L
    };
    private static final long[] maxBounds = new long[]{0, 99, 9_999, 999_999, 99_999_999, 9_999_999_999L, 999_999_999_999L};

    private static final int[][] multiples = new int[][]{{},{},{1},{1},{2},{1},{3,2},{1},{4},{3},{5,2}};

    private static final long[] maxAtDigit = new long[]
            {0, 9, 99, 999, 9999, 99999, 999999, 9_999_999,99_999_999, 999_999_999, 9_999_999_999L};
    private static final long[] minAtDigit = new long[]
            {0, 1, 10, 100, 1_000, 10_000, 100_000, 1_000_000,10_000_000, 100_000_000, 1_000_000_000};
    public Pb2025_2() {
        super(2025, 2, "Day 2: Gift Shop");
    }


    @Override
    protected void exec_part_1(long[] data) throws Exception {
        long sum = 0;
        for (int i = 0; i < data.length; i += 2) {
            long a = getValidBound(data[i], minBounds);
            long b = getValidBound(data[i + 1], maxBounds);
            String clampInfo = data[i] + "," + data[i + 1] + " | " + a + " " + b + " |";
            if (b < a) {
                System.out.println(clampInfo + "invalid range, skipping");
                continue;
            }
            int[] aSplit = splitInTwo(String.valueOf(a));
            int[] bSplit = splitInTwo(String.valueOf(b));
            int intStart = aSplit[0];
            int intEnd = bSplit[0];
            if (aSplit[0] < aSplit[1]) intStart++;
            if (bSplit[0] > bSplit[1]) intEnd--;
            System.out.println(clampInfo + " start : " + intStart + " | " + "end : " + intEnd);
            for (int k = intStart; k <= intEnd; k++) {
                sum += Long.parseLong(k + "" + k);
            }
        }
        System.out.println(sum);
    }

    @Override
    protected void exec_part_2(long[] data) throws Exception {
        long sum = 0;
        for (int i = 0; i < data.length; i += 2) {
            long a = data[i];
            long b = data[i + 1];
            for (long n = a; n <= b; n++) {
                String parsed = String.valueOf(n);
                for (int split : multiples[parsed.length()]) {
                    String ref = parsed.substring(0,split);
                    int k = split;
                    while (k < parsed.length() && parsed.substring(k, k + split).equals(ref)) {
                        k += split;
                    }
                    if (k == parsed.length()) {
                        sum += n;
                        break;
                    }
                }
            }
        }
        System.out.println(sum);
    }

    long getValidBound(long a, long[] boundMap) {
        if (a > 1 && a < 9) return boundMap[0];
        if (a > 100 && a < 999) return boundMap[1];
        if (a > 10_000 && a < 99_999) return boundMap[2];
        if (a > 1_000_000 && a < 9_999_999) return boundMap[3];
        if (a > 100_000_000 && a < 999_999_999) return boundMap[4];
        if (a > 10_000_000_000L && a < 99_999_999_999L) return boundMap[5];
        if (a > 1_000_000_000_000L && a < 9_999_999_999_999L) return boundMap[6];
        return a;
    }


    int[] splitInTwo(String s) {
        int a1 = Integer.parseInt(s.substring(0, s.length() / 2));
        int a2 = Integer.parseInt(s.substring(s.length() / 2));
        return new int[]{a1, a2};
    }


    @Override
    protected long[] parseInput(String[] lines) {
        String[] split = lines[0].split(",");
        long[] result = new long[split.length * 2];
        for (int i = 0; i < split.length; i++) {
            String[] numbers = split[i].split("-");
            result[i * 2] = Long.parseLong(numbers[0]);
            result[i * 2 + 1] = Long.parseLong(numbers[1]);
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
}
