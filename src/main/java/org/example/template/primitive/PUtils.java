package org.example.template.primitive;

public class PUtils {

    private static final char[][] HEX_PAIRS = new char[256][2];
    static {
        for (int i = 0; i < 256; i++) {
            HEX_PAIRS[i][0] = "0123456789ABCDEF".charAt(i >>> 4);
            HEX_PAIRS[i][1] = "0123456789ABCDEF".charAt(i & 0x0F);
        }
    }

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

    public static String toBits(byte value, int targetLen) {
        String str = Long.toBinaryString(value);
        if (str.length() > targetLen) {
            return str.substring(str.length() - targetLen);
        } else {
            return "0".repeat(targetLen - str.length()) + str;
        }
    }
    public static String toBits(byte value) {
        return toBits(value, 8);
    }

    public static String toBits(int value) {
        return toBits(value, 32);
    }

    public static String toBits(long value) {
        return toBits(value, 64);
    }

    public static String toHexString(byte b) {
        return new String(HEX_PAIRS[b & 0xFF]);
    }

    public static byte nibble(byte bits, boolean first) {
        return (byte) ((bits >>> (first ? 4 : 0)) & 0xF);
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
