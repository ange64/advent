package org.example.problems.year2025;

import org.example.template.Template;
import org.example.template.primitive.arrays.ArrUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Pb11 extends Template<int[][]> {

    HashMap<String, Integer> idxs;
    int nbLoops = 0;
    public Pb11() {
        super(2025, 11, "Reactor");
    }

    @Override
    protected void exec_part_1(int[][] data) throws Exception {
       // System.out.println(countPath(data, 0, new int[data.length], data.length - 1));
        System.out.println(nbLoops);
    }

    long countPath(int[][] tree, int start,int end, long[] pathCount, boolean[] marked) {
        if (start == end) return 1;
        if (pathCount[start] != 0) return pathCount[start];
        if (marked[start]) return 0;
        marked[start] = true;
        for (int child : tree[start]) {
            pathCount[start] += countPath(tree, child, end, pathCount, marked);
        }
        return pathCount[start];
    }


    @Override
    protected void exec_part_2(int[][] data) throws Exception {
        long stof = countPath(data, idxs.get("svr"), idxs.get("fft"), new long[data.length], new boolean[data.length]);
        long ftod = countPath(data, idxs.get("fft"), idxs.get("dac"), new long[data.length], new boolean[data.length]);
        long dtoo = countPath(data, idxs.get("dac"), idxs.get("out"), new long[data.length], new boolean[data.length]);
        System.out.println(stof + " " + ftod  + " " + dtoo);
        System.out.println(stof * ftod  * dtoo);

        System.out.println(nbLoops);
    }

    @Override
    protected int[][] parseInput(String[] lines) {
        idxs = new HashMap<>();
        int k = 0;
        for (String line : lines) {
            String sub = line.substring(0,3);
            idxs.put(sub, k++);
        }
        idxs.put("out", k);
        int[][] result = new int[lines.length + 1][];
        for (int i = 0; i < lines.length; i++) {
            String[] split = lines[i].split(" ");
            result[i] = new int[split.length - 1];
            for (int j = 0; j < split.length - 1; j++) {
                result[i][j] = idxs.get(split[j + 1]);
            }
        }
        result[lines.length] = new int[0];
        //Utils.print2dArray(result, ",",3);
        return result;
    }
}
