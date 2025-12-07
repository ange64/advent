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
}