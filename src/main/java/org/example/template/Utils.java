package org.example.template;

import java.util.Arrays;

public class Utils {

    public static final String LINE_SEP = "---------------------------------------------------------------------------";
    public static void print2dArray(int[][] array, String separator){
        System.out.println(LINE_SEP);
        for (var row : array) {
            String str = Arrays.toString(row).replaceAll(", ", separator);
            System.out.println(str.replaceAll("[\\[\\]]", ""));
        }
    }

    public static void print2dArray(char[][] array, String separator){
        System.out.println(LINE_SEP);
        for (var row : array) {
            String str = Arrays.toString(row).replaceAll(", ", separator);
            System.out.println(str.replaceAll("[\\[\\]]", ""));
        }
    }

    public static char[][] charGrid(int height, int width, char value){
        var r = new char[height][width];
        for (char[] chars : r) {
            Arrays.fill(chars, value);
        }
        return r;
    }
}
