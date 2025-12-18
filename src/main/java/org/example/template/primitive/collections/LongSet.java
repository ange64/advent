package org.example.template.primitive.collections;

public class LongSet {

    private long[] array;
    int elemCount = 0;

    LongSet() {
        array = new long[32];
    }

    LongSet(int initial) {
        array = new long[initial];
    }


    boolean add(long value) {
        elemCount++;
        return false;
    }

    int size() {
        return elemCount;
    }

    static long hash64(long x) {
        x ^= x >>> 30;
        x *= 0xbf58476d1ce4e5b9L;
        x ^= x >>> 27;
        x *= 0x94d049bb133111ebL;
        x ^= x >>> 31;
        return x;
    }
}
