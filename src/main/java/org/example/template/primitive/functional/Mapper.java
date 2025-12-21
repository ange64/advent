package org.example.template.primitive.functional;

public interface Mapper {


    interface ByteIndexed {
        byte map(byte i, int idx);
    }

    interface ShortIndexed {
        short map(short i, int idx);
    }

    interface IntIndexed {
        int map(int i, int idx);
    }

    interface LongIndexed {
        long map(long i, int idx);
    }

    interface CharIndexed {
        char map(char i, int idx);
    }

    interface BoolIndexed {
        boolean map(boolean i, int idx);
    }

    interface FloatIndexed {
        float map(float i, int idx);
    }

    interface DoubleIndexed {
        double map(double i, int idx);
    }


    interface Byte {
        byte map(byte i);
    }

    interface Short {
        short map(short i);
    }

    interface Int {
        int map(int i);
    }

    interface Long {
        long map(long i);
    }

    interface Char {
        char map(char i);
    }

    interface Bool {
        boolean map(boolean i);
    }

    interface Float {
        float map(float i);
    }

    interface Double {
        double map(double i);
    }

    interface ByteTo<T> {
        T map(byte i);
    }

    interface ShortTo<T> {
        T map(short i);
    }

    interface IntTo<T> {
        T map(int i);
    }

    interface LongTo<T> {
        T map(long i);
    }

    interface CharTo<T> {
        T map(char i);
    }

    interface BoolTo<T> {
        T map(boolean i);
    }

    interface FloatTo<T> {
        T map(float i);
    }

    interface DoubleTo<T> {
        T map(double i);
    }


}