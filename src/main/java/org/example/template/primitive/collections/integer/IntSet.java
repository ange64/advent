package org.example.template.primitive.collections.integer;

import org.example.template.primitive.arrays.ArrUtils;
import org.example.template.primitive.collections.PCollection;
import org.example.template.primitive.collections.PrimitiveCollections;
import org.example.template.primitive.functional.Consumer;
import org.example.template.primitive.functional.Mapper;
import org.example.template.primitive.functional.Predicate;

import java.util.Arrays;

public class IntSet implements IntCollection, PCollection {

    public static final int TOMBSTONE = Integer.MIN_VALUE + 1;
    public static final int EMPTY = Integer.MIN_VALUE;
    public static final float MAX_LOAD_FACTOR = 0.7f;
    private final int tomb;
    private final int empty;
    private int[] array;
    private int elemCount = 0;
    private int maxLoad;
    private int mask;

    public IntSet() {
        this(256);
    }

    public IntSet(int initial) {
        this(initial, EMPTY, TOMBSTONE);
    }

    public IntSet(int initial, int empty, int tombstone) {
        //ensure power of two size table
        initial = 1 << (32 - Integer.numberOfLeadingZeros(initial));
        array = new int[initial];
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
    public boolean add(int value) {
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
    public boolean remove(int value) {
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
    public boolean contains(int value) {
        checkSentinels(value);
        return probe(value, false) > 0;
    }

    @Override
    public void forEach(Consumer.Int c) {
        for (int i = 0; i < size(); i++) {
            if (array[i] == empty || array[i] == tomb) continue;
            c.accept(array[i]);
        }
    }

    @Override
    public void removeIf(Predicate.Int p) {
        for (int j : array) {
            if (j != tomb && j != empty && p.test(j)) {
                remove(j);
            }
        }
    }

    @Override
    public int size() {
        return elemCount;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[elemCount];
        int i = 0;
        for (int l : array) {
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

    public IntList toIntList() {
        var list = new IntList(elemCount);
        for (int l : array) {
            if (l == empty || l == tomb) continue;
            list.add(l);
        }
        return list;
    }

    private void checkSentinels(int value) {
        if (value == tomb || value == empty) throw new IllegalStateException("sentinel values used as parameter");
    }

    private void resize() {
        var newArray = new int[array.length << 1];
        if (empty != 0) Arrays.fill(newArray, empty);
        var temp = array;
        maxLoad = (int) (newArray.length * MAX_LOAD_FACTOR);
        array = newArray;
        mask = newArray.length - 1;
        elemCount = 0;
        for (int l : temp) {
            if (l == empty || l == tomb) continue;
            add(l);
        }
    }

    /**
     * probes using double hashing. returned index is negative if first available slot
     * is vacant, positive if already taken by the value itself.
     */
    private int probe(int value, boolean checkTomb) {
        var hashed = hash32(value);
        int noProbeIdx = (hashed & mask);
        if (array[noProbeIdx] == value) return noProbeIdx;
        if (array[noProbeIdx] == empty) return -noProbeIdx;
        int stride = (hash32(hashed) << 1) | 1;
        int f = 1;
        int index;
        int removed = -1;
        ;
        do {
            index = ((hashed + f++ * stride) & (array.length - 1));
            int curr = array[index];
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



    static int hash32(int x) {
        x ^= x >>> 16;
        x *= 0x85ebca6b;
        x ^= x >>> 13;
        x *= 0xc2b2ae35;
        x ^= x >>> 16;
        return x;
    }
}
