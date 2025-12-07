package org.example.template.primitive.collections;

import java.util.Arrays;

public class LongList extends PrimitiveList{

    private long[] array;
    int pointer = -1;

    public LongList() {
        array = new long[16];
    }

    public LongList(int initial) {
        array = new long[initial];
    }

    public LongList initializeTo(long value) {
        Arrays.fill(array, value);
        return this;
    }

    public void add(long i) {
        if (pointer == array.length - 1) {
            long[] temp = new long[array.length << 2];
            System.arraycopy(array, 0, temp, 0, array.length);
            array = temp;
        }
        array[++pointer] = i;
    }

    public void force(long i) {
        array[++pointer] = i;
    }

    public long get(int i) {
        if (i > pointer)  super.throwOOB(i);
        return array[i];
    }

    public long pop() {
        if (pointer == -1) super.throwOOB(pointer);
        return array[pointer--];
    }

    public long last() {
        return array[pointer];
    }

    public int size() {
        return pointer + 1;
    }

    public long capacity() {
        return array.length;
    }

    public void set(long v, int idx) {
        if (idx > pointer) super.throwOOB(pointer);
        array[idx] = v;
    }

    public void softClear() {
        pointer = -1;
    }

    public void hardClear(long defaultValue) {
        Arrays.fill(array, defaultValue);
    }

    public long[] toArray() {
        long[] result = new long[pointer + 1];
        System.arraycopy(array, 0, result, 0, pointer + 1);
        return result;
    }
}
