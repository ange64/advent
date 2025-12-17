package org.example.template;

import org.example.template.primitive.functional.Predicate;

import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.function.Supplier;

public class Utils {

    public static final String LINE_SEP = "---------------------------------------------------------------------------";
    public static final MessageDigest MD5;

    static {
        try {
            MD5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void print2dArray(byte[][] array, String separator, int minSize) {
        System.out.println(LINE_SEP);
        for (var row : array) {
            StringBuilder sb = new StringBuilder();
            for (byte b : row) {
                sb.append(String.format("%-" + minSize + "s", b));
                sb.append(separator);
            }
            sb.deleteCharAt(sb.length() - separator.length());
            System.out.println(sb);
        }
    }

    public static void print2dArray(int[][] array, String separator, int minSize) {
        System.out.println(LINE_SEP);
        for (var row : array) {
            StringBuilder sb = new StringBuilder();
            for (int b : row) {
                sb.append(String.format("%-" + minSize + "s", b));
                sb.append(separator);
            }
            if (separator.length() <= sb.length())
                sb.deleteCharAt(sb.length() - separator.length());
            System.out.println(sb);
        }
    }

    public static void print2dArray(long[][] array, String separator, int minSize) {
        System.out.println(LINE_SEP);
        for (var row : array) {
            StringBuilder sb = new StringBuilder();
            for (long b : row) {
                sb.append(String.format("%-" + minSize + "s", b));
                sb.append(separator);
            }
            if (!separator.isEmpty())
                sb.deleteCharAt(sb.length() - separator.length());
            System.out.println(sb);
        }
    }

    public static void print2dArray(char[][] array, String separator, int minSize) {
        System.out.println(LINE_SEP);
        for (var row : array) {
            StringBuilder sb = new StringBuilder();
            for (char b : row) {
                sb.append(String.format("%-" + minSize + "s", b));
                sb.append(separator);
            }
            if (!separator.isEmpty())
                sb.deleteCharAt(sb.length() - separator.length());
            System.out.println(sb);
        }
    }



    public static char[][] charGrid(int height, int width, char value){
        var r = new char[height][width];
        for (char[] chars : r) {
            Arrays.fill(chars, value);
        }
        return r;
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

    public static void md5Hash(byte[] b, byte[] out) throws DigestException {
        MD5.update(out);
        MD5.digest(b, 0,16);
    }
}
