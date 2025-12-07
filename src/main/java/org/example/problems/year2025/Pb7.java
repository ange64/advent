package org.example.problems.year2025;

import org.example.template.Template;
import org.example.template.Utils;
import org.example.template.primitive.arrays.ArrUtils;
import org.example.template.primitive.collections.IntList;
import org.example.template.primitive.functional.Predicate;

import java.util.Arrays;
import java.util.HashMap;

public class Pb7 extends Template<char[][]> {

    HashMap<Integer, Long> map;

    public Pb7() {
        super(2025, 7, "Laboratories ");
    }

    @Override
    protected void exec_part_1(char[][] data) throws Exception {
        int start = ArrUtils.indexOf(data[0], 'S');
        //System.out.println(beam(data, 1, start, 0));
    }

    private int beam(char[][] data,  int level, int column, int value) {
        if (level == data.length || column < 0 || column > data[0].length || data[level][column] == '|') return 0;
        int newLevel = level;
        while (level < data.length && data[level][column] != '^') {
            data[level++][column] = '|';
        }
        return value + beam(data, newLevel, column - 1, 0) +  beam(data, newLevel, column + 1, 1);
    }

    @Override
    protected void exec_part_2(char[][] data) throws Exception {
        map = new HashMap<>();
        int start = ArrUtils.indexOf(data[0], 'S');
        timeline(data, 0, start);
        System.out.println(map.get((1 << 16) | start));
    }


    private long timeline(char[][] data,  int level, int column) {
        if (column < 0 || column >= data[0].length) return 0;
        while (level < data.length && data[level][column] != '^') {
            data[level++][column] = '|';
        }
        int idx = ((level - 1) << 16  | column);
        if (level == data.length) map.put(idx, 1L);
        if (map.containsKey(idx)) return map.get(idx);
        long left  = timeline(data, level, column - 1);
        long right = timeline(data, level, column + 1);
        map.put(idx, left + right);
        return  left + right;
    }

    @Override
    protected char[][] parseInput(String[] lines) {
        return Arrays.stream(lines).map(String::toCharArray).toArray(char[][]::new);
    }
}
