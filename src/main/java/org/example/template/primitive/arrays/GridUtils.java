package org.example.template.primitive.arrays;

import java.util.Arrays;

public class GridUtils {

    public static char[][] clone(char[][] grid) {
        var res = new char[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            res[i] = grid[i].clone();
        }
        return res;
    }

    public static char[][] rotateCW(char[][] grid) {
        var r = new char[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                r[j][grid.length - i - 1] = grid[i][j];
            }
        }
        return r;
    }

    public static char[][] rotateCCW(char[][] grid) {
        var r = new char[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
               r[i][j] =  grid[j][grid.length - i - 1];
            }
        }
        return r;
    }

    public static char[][] rotate180(char[][] grid) {
        var r = new char[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                r[i][j] =  grid[grid.length - 1 - i][grid.length - 1 - j];
            }
        }
        return r;
    }


    public static char[][] flipH(char[][] grid) {
        var r = new char[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            r[i] = grid[grid.length - i - 1].clone();
        }
        return r;
    }



}
