package org.example.template.primitive.functional;

public interface Comparator {
    @FunctionalInterface
    interface Boolean {
        int compare(boolean a, boolean b);
    }

    @FunctionalInterface
    interface Byte {
        int compare(byte a, byte b);
    }

    @FunctionalInterface
    interface Short {
        int compare(short a, short b);
    }

    @FunctionalInterface
    interface Char {
        int compare(char a, char b);
    }

    @FunctionalInterface
    interface Int {
        int compare(int a, int b);
    }

    @FunctionalInterface
    interface Long {
        int compare(long a, long b);
    }

    @FunctionalInterface
    interface Float {
        int compare(float a, float b);
    }

    @FunctionalInterface
    interface Double {
        int compare(double a, double b);
    }
}