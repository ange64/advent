package org.example.template.primitive;

public class PUtils {

    public static int strToI(String s) {
        return Integer.parseInt(s);
    }

    public static int subStrToI(String s, int start, int end) {
        return Integer.parseInt(s.substring(start, end));
    }

    public static String toBits(int value, int targetLen) {
        String str = Integer.toBinaryString(value);
        if (str.length() > targetLen) {
            return str.substring(str.length() - targetLen);
        } else {
            return "0".repeat(targetLen - str.length()) + str;
        }
    }

    public static String toBits(long value, int targetLen) {
        String str = Long.toBinaryString(value);
        if (str.length() > targetLen) {
            return str.substring(str.length() - targetLen);
        } else {
            return "0".repeat(targetLen - str.length()) + str;
        }
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

}
