package org.example.template.primitive.functional;

public interface Consumer {
    interface Byte {
        void accept(byte i);
    }

    interface Short {
        void accept(short i);
    }

    interface Int {
        void accept(int i);
    }

    interface Long {
        void accept(long i);
    }

    interface Char {
        void accept(char i);
    }

    interface Bool {
        void accept(boolean i);
    }

    interface Float {
        void accept(float i);
    }

    interface Double {
        void accept(double i);
    }


    interface ByteIndexed {
        void accept(byte i, int index);
    }

    interface ShortIndexed {
        void accept(short i, int index);
    }

    interface IntIndexed {
        void accept(int i, int index);
    }

    interface LongIndexed {
        void accept(long i, int index);
    }

    interface CharIndexed {
        void accept(char i, int index);
    }

    interface BoolIndexed {
        void accept(boolean i, int index);
    }

    interface FloatIndexed {
        void accept(float i, int index);
    }

    interface DoubleIndexed {
        void accept(double i, int index);
    }


}