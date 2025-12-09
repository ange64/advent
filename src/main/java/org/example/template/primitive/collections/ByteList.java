package org.example.template.primitive.collections;

import java.util.Arrays;

public class ByteList extends PrimitiveList{

    private byte[] array;
    int pointer = -1;

    public ByteList() {
        array = new byte[64];
    }

    public ByteList(int initial) {
        array = new byte[initial];
    }

    public ByteList initializeTo(byte value) {
        Arrays.fill(array, value);
        return this;
    }

    public void add(byte i) {
        if (pointer == array.length - 1) {
            byte[] temp = new byte[array.length << 2];
            System.arraycopy(array, 0, temp, 0, array.length);
            array = temp;
        }
        array[++pointer] = i;
    }

    public void force(byte i) {
        array[++pointer] = i;
    }

    public byte get(int i) {
        if (i > pointer)  super.throwOOB(i);
        return array[i];
    }

    public byte pop() {
        if (pointer == -1) super.throwOOB(pointer);
        return array[pointer--];
    }

    public int last() {
        return array[pointer];
    }

    public int size() {
        return pointer + 1;
    }

    public int capacity() {
        return array.length;
    }

    public void set(byte v, int idx) {
        if (idx > pointer)  super.throwOOB(idx);
        array[idx] = v;
    }

    public void softClear() {
        pointer = -1;
    }

    public void hardClear(byte defaultValue) {
        Arrays.fill(array, defaultValue);
    }

    @Override
    public void sort() {
        Arrays.sort(array, 0, pointer + 1);
    }
    public byte[] toArray() {
        byte[] result = new byte[pointer + 1];
        System.arraycopy(array, 0, result, 0, pointer + 1);
        return result;
    }

}
