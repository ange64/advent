package org.example.problems.year2025;

import org.example.template.Template;
import org.example.template.primitive.collections.longs.LongList;

import java.util.Arrays;
import java.util.Comparator;

public class Pb5 extends Template<Pb5.Data> {


    public Pb5() {
        super(2025, 5, "Cafeteria");
    }

    @Override
    protected void exec_part_1(Data data) throws Exception {
        Arrays.sort(data.ranges, Comparator.comparingLong(o -> o[0]));
        long[] merged = getMergedRanges(data);
        int fresh = 0;
        for (long product : data.toCheck) {
            int index = Arrays.binarySearch(merged, product);
            if (index > 0 || (-index % 2) == 0) fresh++;
        }
        System.out.println(fresh);
    }

    private static long[] getMergedRanges(Data data) {
        var mergedRanges = new LongList(data.ranges.length);
        var ranges = data.ranges;
        //range merge
        for (int i = 0; i < data.ranges.length; i++) {
            mergedRanges.add(ranges[i][0]);
            long maxEnd = ranges[i][1];
            while (i < ranges.length - 1 && maxEnd >= ranges[i + 1][0]) {
                maxEnd = Math.max(maxEnd, ranges[i + 1][1]);
                i++;
            }
            i = Math.min(ranges.length - 1, i);
            mergedRanges.add(Math.max(maxEnd, ranges[i][1]));
        }
        return mergedRanges.toArray();
    }

    @Override
    protected void exec_part_2(Data data) throws Exception {
        var merged = getMergedRanges(data);
        long sum = 0;
        for (int i = 0; i < merged.length; i += 2) {
            sum += merged[i + 1] - merged[i] + 1;
        }
        System.out.println(sum);
    }

    protected record Data(long[][] ranges, long[] toCheck) {
    }

    @Override
    protected Data parseInput(String[] lines) {
        int i = 0;
        var starts = new LongList();
        var ends = new LongList();
        while (!lines[i].isEmpty()) {
            String[] split = lines[i++].split("-");
            starts.add(Long.parseLong(split[0]));
            ends.add(Long.parseLong(split[1]));
        }
        var toCheck = new LongList();
        while (++i < lines.length) {
            toCheck.add(Long.parseLong(lines[i]));
        }
        long[][] ranges = new long[starts.size()][2];
        for (int j = 0; j < ranges.length; j++) {
            ranges[j][0] = starts.get(j);
            ranges[j][1] = ends.get(j);
        }
        return new Data(ranges, toCheck.toArray());
    }


}
