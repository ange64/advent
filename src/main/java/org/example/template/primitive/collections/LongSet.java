package org.example.template.primitive.collections;

import java.util.Arrays;

public class LongSet {

    public static final long EMPTY_SLOT = Long.MIN_VALUE + 1;
    public static final float MAX_LOAD_FACTOR = 0.7f;
    private long[] array;
    private int elemCount = 0;
    private int maxLoad;
    private int mask;

    LongSet() {
        this(128);
    }

    LongSet(int initial) {
        //ensure power of two size table
        initial = 1 << (31 - Integer.numberOfLeadingZeros(initial));
        array = new long[initial];
        Arrays.fill(array, EMPTY_SLOT);
        maxLoad = (int) (initial * MAX_LOAD_FACTOR);
        mask = array.length - 1;
    }

    boolean add(long value) {
        elemCount++;
        if (elemCount >= maxLoad) resize();
        int index = resolveIndex(value);
        if (array[index] == value) return true;
        else array[index] = value;
        return false;
    }

    private boolean contains(long value){
        int index = resolveIndex(value);
        return array[index] == value;
    }

    private boolean remove(long value) {

    }



    private void resize() {
        var newArray = new long[array.length << 1];
        var temp = array;
        maxLoad = (int) (newArray.length * MAX_LOAD_FACTOR);
        array = newArray;
        mask = newArray.length - 1;
        elemCount = 0;
        for (long l : temp) {
            if (l == 0) continue;
            add(l);
        }
    }

    private int resolveIndex(long value) {
        var hashed = hash64(value);
        int index = (int) (hashed & mask);
        if (array[index] == value) return index;
        if (array[index] == 0) return -index;
        return probe(hashed, value);
    }

    private int probe(long hash, long value){
        long stride = (hash64(hash) << 1) | 1;
        int f = 1;
        int index;
        do {
            index = (int) ((hash + f++ * stride) & (array.length - 1));
        } while (array[index] == 0 || array[index] == value);
        return index;
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
