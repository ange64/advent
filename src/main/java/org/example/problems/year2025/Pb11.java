package org.example.problems.year2025;

import org.example.template.Template;
import org.example.template.Utils;
import org.example.template.primitive.arrays.ArrUtils;
import org.example.template.primitive.collections.IntList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Pb11 extends Template<int[][]> {

    HashMap<String, Integer> indexMap;
    int nbLoops = 0;
    public Pb11() {
        super(2025, 11, "Reactor");
    }

    @Override
    protected void exec_part_1(int[][] data) throws Exception {
       // System.out.println(countPath(data, 0, new int[data.length], data.length - 1));
        System.out.println(nbLoops);
    }

    long countPath(int[][] tree, int start, long[] visited) {
        if (start == tree.length - 1)
            return 1;
        if (visited[start] >= 1) return visited[start];
        for (int child : tree[start]) {
            visited[start] += countPath(tree, child, visited);
        }
        return visited[start];
    }

    @Override
    protected void exec_part_2(int[][] data) throws Exception {
        long[] visitedCount = new long[data.length];
        System.out.println(countPath(data, indexMap.get("svr"), visitedCount));
        System.out.println(visitedCount[indexMap.get("fft")] - visitedCount[indexMap.get("dac")]);
        System.out.println(nbLoops);
    }

    @Override
    protected int[][] parseInput(String[] lines) {
        indexMap = new HashMap<>();
        int k = 0;
        for (String line : lines) {
            String sub = line.substring(0,3);
            indexMap.put(sub, k++);
        }
        indexMap.put("out", k);
        int[][] result = new int[lines.length + 1][];
        for (int i = 0; i < lines.length; i++) {
            String[] split = lines[i].split(" ");
            result[i] = new int[split.length - 1];
            for (int j = 0; j < split.length - 1; j++) {
                result[i][j] = indexMap.get(split[j + 1]);
            }
        }
        result[lines.length] = new int[0];
        //Utils.print2dArray(result, ",",3);
        return result;
    }
}
