package org.example.template.primitive.collections;

public class LongSet {

    private static final float MAX_LOAD_FACTOR = 0.7f;
    private long[] array;
    private int elemCount = 0;
    private int maxLoad = 0;

    LongSet() {
        array = new long[32];
        maxLoad = (int) (32 * MAX_LOAD_FACTOR);
    }

    LongSet(int initial) {
        array = new long[initial];
        maxLoad = (int) (initial * MAX_LOAD_FACTOR);
    }


    boolean add(long value) {
        elemCount++;
        if (elemCount >= maxLoad) resize();

    }

    private void resize() {

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
