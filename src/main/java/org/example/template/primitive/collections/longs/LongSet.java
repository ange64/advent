package org.example.template.primitive.collections.longs;

import org.example.template.primitive.arrays.ArrUtils;
import org.example.template.primitive.collections.PCollection;
import org.example.template.primitive.collections.PrimitiveCollections;
import org.example.template.primitive.functional.Consumer;
import org.example.template.primitive.functional.Mapper;

import java.util.Arrays;

public class LongSet implements LongCollection, PCollection {

    public static final long TOMBSTONE = Long.MIN_VALUE + 1;
    public static final long EMPTY = Long.MIN_VALUE;
    public static final float MAX_LOAD_FACTOR = 0.7f;
    private final long tomb;
    private final long empty;
    private long[] array;
    private int elemCount = 0;
    private int maxLoad;
    private int mask;

    public LongSet() {
        this(256);
    }

    public LongSet(int initial) {
        this(initial, EMPTY, TOMBSTONE);
    }

    public LongSet(int initial, long empty, long tombstone) {
        //ensure power of two size table
        initial = 1 << (31 - Integer.numberOfLeadingZeros(initial));
        array = new long[initial];
        maxLoad = (int) (initial * MAX_LOAD_FACTOR);
        mask = array.length - 1;
        if (empty != 0) Arrays.fill(array, empty);
        this.tomb = tombstone;
        this.empty = empty;
    }

    /**
     * Adds to the set.
     * Throws an exception if a sentinel value is used.
     *
     * @return true if the value was inserted, false if already inside
     */
    public boolean add(long value) {
        checkSentinels(value);
        if (elemCount >= maxLoad) resize();
        int index = probe(value, true);
        if (index > 0) return false;
        elemCount++;
        array[-index] = value;
        return true;
    }

    /**
     * removes the value from the set.
     * throws an exception if a sentinel value is used.
     *
     * @return true if the value was removed, false if it didn't exist
     */
    public boolean remove(long value) {
        checkSentinels(value);
        int index = probe(value, false);
        if (index < 0) return false;
        elemCount--;
        array[index] = tomb;
        return true;
    }

    /**
     * Search for the value in the set.
     * throws an exception if a sentinel value is used.
     *
     * @return true if the elements exists in the set.
     */
    public boolean contains(long value) {
        checkSentinels(value);
        return probe(value, false) > 0;
    }

    @Override
    public LongSet mapInPlace(Mapper.Long m) {
        ArrUtils.mapInPlace(array, size(), m);
        return this;
    }

    @Override
    public void forEach(Consumer.Long c) {
        for (int i = 0; i < size(); i++) {
            if (array[i] == empty || array[i] == tomb) continue;
            c.accept(array[i]);
        }
    }

    @Override
    public int size() {
        return elemCount;
    }

    @Override
    public long[] toArray() {
        long[] result = new long[elemCount];
        int i = 0;
        for (long l : array) {
            if (l == empty || l == tomb) continue;
            result[i++] = l;
        }
        return result;
    }

    @Override
    public void clear() {
        Arrays.fill(array, empty);
    }

    @Override
    public boolean isEmpty() {
        return elemCount == 0;
    }

    @Override
    public boolean isNotEmpty() {
        return elemCount > 0;
    }

    public LongList toLongList() {
        var list = new LongList(elemCount);
        for (long l : array) {
            if (l == empty || l == tomb) continue;
            list.add(l);
        }
        return list;
    }

    private void checkSentinels(long value) {
        if (value == tomb || value == empty) throw new IllegalStateException("sentinel values used as parameter");
    }

    private void resize() {
        var newArray = new long[array.length << 1];
        if (empty != 0) Arrays.fill(newArray, empty);
        var temp = array;
        maxLoad = (int) (newArray.length * MAX_LOAD_FACTOR);
        array = newArray;
        mask = newArray.length - 1;
        elemCount = 0;
        for (long l : temp) {
            if (l == empty || l == tomb) continue;
            add(l);
        }
    }

    /**
     * probes using double hashing. returned index is negative if first available slot
     * is vacant, positive if already taken by the value itself.
     */
    private int probe(long value, boolean checkTomb) {
        var hashed = hash64(value);
        int noProbeIdx = (int) (hashed & mask);
        if (array[noProbeIdx] == value) return noProbeIdx;
        if (array[noProbeIdx] == empty) return -noProbeIdx;
        long stride = (hash64(hashed) << 1) | 1;
        int f = 1;
        int index;
        int removed = -1;
        ;
        do {
            index = (int) ((hashed + f++ * stride) & (array.length - 1));
            long curr = array[index];
            if (checkTomb && removed == -1 && curr == tomb) removed = index;
            if (curr == empty) return removed < 0 ? -index : -removed;
            if (curr == value) return index;
        } while (true);
    }

    @Override
    public String toString() {
        return PrimitiveCollections.toString(
                array, (o, i) -> array[i] == empty, this.getClass().getName(), Object::toString
        );
    }

    static long hash64(long x) {
        x ^= x >>> 33;
        x *= 0xff51afd7ed558ccdL;
        x ^= x >>> 33;
        x *= 0xc4ceb9fe1a85ec53L;
        x ^= x >>> 33;
        return x;
    }
}
