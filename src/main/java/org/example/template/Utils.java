package org.example.template;

import org.example.problems.Pb2016_11;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.regex.Matcher;

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

    public static void print2dArray(byte[][] array, String separator) {
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



    public static int strToI(String s) {
        return Integer.parseInt(s);
    }

    public static int subStrToI(String s, int start, int end) {
        return Integer.parseInt(s.substring(start, end));
    }

    public static <T> T[] fillArray(T[] array, Supplier<T> init){
        for (int i = 0; i < array.length; i++) {
            array[i] = init.get();
        }
        return array;
    }

    public static void printPackedArray(short[] array) {
        var str = "[";
        for (var s : array) {
            str += "(" + (s >> 8) + "," + (s & 255) + ")";
        }
        System.out.println(str + ']');
    }

    public static void printPackedArray(int[] array) {
        var str = "[";
        for (var s : array) {
            str += "(" + (s >>> 16) + "," + (s & 0xFFFF) + ")";
        }
        System.out.println(str + ']');
    }
}
