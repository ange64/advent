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

    public static int nbDigits(long number) {
        if (number < 100000) {
            if (number < 100) {
                if (number < 10) {
                    return 1;
                } else {
                    return 2;
                }
            } else {
                if (number < 1000) {
                    return 3;
                } else {
                    if (number < 10000) {
                        return 4;
                    } else {
                        return 5;
                    }
                }
            }
        } else {
            if (number < 10000000) {
                if (number < 1000000) {
                    return 6;
                } else {
                    return 7;
                }
            } else {
                if (number < 100000000) {
                    return 8;
                } else {
                    if (number < 1000000000) {
                        return 9;
                    } else {
                        return 10;
                    }
                }
            }
        }
    }


    public static void print2dArray(byte[][] array, String separator){
        System.out.println(LINE_SEP);
        for (var row : array) {
            String str = Arrays.toString(row).replaceAll(", ", separator);
            System.out.println(str.replaceAll("[\\[\\]]", ""));
        }
    }


}
