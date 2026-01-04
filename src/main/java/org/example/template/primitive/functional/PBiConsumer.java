package org.example.template.primitive.functional;

public interface PBiConsumer {

    interface Byte {
        void accept(byte i, byte j);
    }

    interface Short {
        void accept(short i, short j);
    }

    interface Int{
        void accept(int i, int j);
    }

    interface Long {
        void accept(long i, long j);
    }

    interface Char {
        void accept(char i, char j);
    }

    interface Bool{
        void accept(boolean i, boolean j);
    }

    interface Float{
        void accept(float i, float j);
    }

    interface Double {
        void accept(double i, double j);
    }

    interface ByteIndexed {
        void accept(byte i, int index, byte j, int index2);
    }

    interface ShortIndexed {
        void accept(short i, int index, short j, int index2);
    }

    interface IntIndexed {
        void accept(int i, int index, int j, int index2);
    }

    interface LongIndexed {
        void accept(long i, int index, long j, int index2);
    }

    interface CharIndexed {
        void accept(char i, int index, char j, int index2);
    }

    interface BoolIndexed {
        void accept(boolean i, int index, boolean j, int index2);
    }

    interface FloatIndexed {
        void accept(float i, int index, float j, int index2);
    }

    interface DoubleIndexed {
        void accept(double i, int index, double j, int index2);
    }
}
