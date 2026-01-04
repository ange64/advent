package org.example.template;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;

public class Utils {

    public static final String LINE_SEP = "---------------------------------------------------------------------------";
    public static final MessageDigest MD5;
    public static final String RESET = "\u001B[0m";


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

    public static void print2dArray(char[][] array, String separator, int minSize, HashMap<Character, Integer> color) {
        System.out.println(LINE_SEP);
        for (var row : array) {
            StringBuilder sb = new StringBuilder();
            for (char b : row) {
                var c = color.getOrDefault(b, 0);
                sb.append(bg(c));
                sb.append(fg(c));
                sb.append(String.format("%-" + minSize + "s", b));
                sb.append(RESET);
                sb.append(separator);
            }
            if (!separator.isEmpty())
                sb.deleteCharAt(sb.length() - separator.length());
            System.out.println(sb);
        }
    }


    public static char[][] charGrid(int height, int width, char value) {
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
        MD5.digest(b, 0, 16);
    }

    public static String[] readFile(String... hierarchy) throws IOException {
        var file = inputAsFile(hierarchy);
        return Files.readAllLines(file.toPath()).toArray(new String[0]);
    }

    public static File inputAsFile(String... hierarchy) throws IOException {
        if (hierarchy.length == 0) throw new IllegalArgumentException("target path is empty");
        StringBuilder sb = new StringBuilder();
        for (String s : hierarchy) {
            sb.append(s).append("/");
        }
        sb.deleteCharAt(sb.length() - 1);
        Path path = Path.of(sb.toString());
        if (Files.isDirectory(path)) throw new IllegalArgumentException("target path is a directory");
        return path.toFile();
    }


    public static String bg(int rgb) {
        return String.format("\u001B[48;2;%d;%d;%dm", (rgb >>> 16), ((rgb >>> 8) & 255),( rgb & 255));
    }

    public static String fg(int rgb) {
        double brightness = 0.299*(rgb >>> 16) + 0.587*((rgb >>> 8) & 255) + 0.114*(rgb & 255);
        return (brightness > 128) ? "\u001B[30m" : "\u001B[37m";
    }
}
