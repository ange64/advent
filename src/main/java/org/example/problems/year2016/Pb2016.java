package org.example.problems.year2016;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Pb2016 implements Runnable {
    static String[] text = new String[]{
            "R2", "L1", "R2", "R1", "R1", "L3", "R3", "L5", "L5", "L2", "L1", "R4", "R1", "R3", "L5", "L5", "R3", "L4", "L4", "R5", "R4", "R3", "L1", "L2", "R5", "R4", "L2", "R1", "R4", "R4", "L2", "L1", "L1", "R190", "R3", "L4", "R52", "R5", "R3", "L5", "R3", "R2", "R1", "L5", "L5", "L4", "R2", "L3", "R3", "L1", "L3", "R5", "L3", "L4", "R3", "R77", "R3", "L2", "R189", "R4", "R2", "L2", "R2", "L1", "R5", "R4", "R4", "R2", "L2", "L2", "L5", "L1", "R1", "R2", "L3", "L4", "L5", "R1", "L1", "L2", "L2", "R2", "L3", "R3", "L4", "L1", "L5", "L4", "L4", "R3", "R5", "L2", "R4", "R5", "R3", "L2", "L2", "L4", "L2", "R2", "L5", "L4", "R3", "R1", "L2", "R2", "R4", "L1", "L4", "L4", "L2", "R2", "L4", "L1", "L1", "R4", "L1", "L3", "L2", "L2", "L5", "R5", "R2", "R5", "L1", "L5", "R2", "R4", "R4", "L2", "R5", "L5", "R5", "R5", "L4", "R2", "R1", "R1", "R3", "L3", "L3", "L4", "L3", "L2", "L2", "L2", "R2", "L1", "L3", "R2", "R5", "R5", "L4", "R3", "L3", "L4", "R2", "L5", "R5"
    };
    static String[] inputTest = new String[] {"R8", "R4", "R4", "R8"};
    static String[] inputTest2 = new String[] {"R5", "L5", "R5", "R3"};
    static final Map<String, Character> dirMap = new HashMap<>();

    static {
        dirMap.put("NL", 'W');
        dirMap.put("NR", 'E');
        dirMap.put("WL", 'S');
        dirMap.put("WR", 'N');
        dirMap.put("EL", 'N');
        dirMap.put("ER", 'S');
        dirMap.put("SL", 'E');
        dirMap.put("SR", 'W');
    }

    @Override
    public void run() {
        int x = 500;
        int y = 500;
        char dir = 'N';
        boolean[][] grid = new boolean[1000][1000];
        grid[500][500] = true;
        outer:
        for (String string : text) {
            char next = string.charAt(0);
            int value = Integer.parseInt(string.substring(1));
            dir = dirMap.get(dir + "" + next);
            int dx = 0;
            int dy = 0;
            switch (dir) {
                case 'N' -> dy = 1;
                case 'S' -> dy = -1;
                case 'E' -> dx = 1;
                case 'W' -> dx = -1;
            }
            for (int i = 0; i < value; i++) {
                if (grid[x += dx][y += dy]) {
                    break outer;
                }
                grid[x][y] = true;
            }
        }
        System.out.println("x : " + (x - 500) + " y : " + (y - 500));
        System.out.println(Math.abs(x  - 500) + Math.abs(y - 500));
    }


}
