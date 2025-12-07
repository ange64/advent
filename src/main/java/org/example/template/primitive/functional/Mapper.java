package org.example.template.primitive.functional;

public interface Mapper {

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

    interface Char{
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

}