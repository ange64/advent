package org.example.template.primitive.functional;

public interface Predicate {
    @FunctionalInterface
    interface Boolean {
        boolean test(boolean b);
    }

    @FunctionalInterface
    interface Byte {
        boolean test(byte b);
    }

    @FunctionalInterface
    interface Short {
        boolean test(short s);
    }

    @FunctionalInterface
    interface Char {
        boolean test(char c);
    }

    @FunctionalInterface
    interface Int {
        boolean test(int i);
    }

    @FunctionalInterface
    interface Long {
        boolean test(long l);
    }

    @FunctionalInterface
    interface Float {
        boolean test(float f);
    }

    @FunctionalInterface
    interface Double {
        boolean test(double d);
    }

    @FunctionalInterface
    interface BooleanIndexed {
        boolean test(boolean b, int idx);
    }

    @FunctionalInterface
    interface ByteIndexed {
        boolean test(byte b, int idx);
    }

    @FunctionalInterface
    interface ShortIndexed {
        boolean test(short s, int idx);
    }

    @FunctionalInterface
    interface CharIndexed {
        boolean test(char c, int idx);
    }

    @FunctionalInterface
    interface IntIndexed {
        boolean test(int i, int idx);
    }

    @FunctionalInterface
    interface LongIndexed {
        boolean test(long l, int idx);
    }

    @FunctionalInterface
    interface FloatIndexed {
        boolean test(float f, int idx);
    }

    @FunctionalInterface
    interface DoubleIndexed {
        boolean test(double d, int idx);
    }
}