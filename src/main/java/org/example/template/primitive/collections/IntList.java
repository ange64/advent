package org.example.template.primitive.collections;

import java.util.Arrays;

public class IntList extends PrimitiveList{

    private int[] array;
    int pointer = -1;

    public IntList() {
        array = new int[16];
    }

    public IntList(int initial) {
        array = new int[initial];
    }

    public IntList initializeTo(int value) {
        Arrays.fill(array, value);
        return this;
    }

    public void add(int i) {
        if (pointer == array.length - 1) {
            int[] temp = new int[array.length << 2];
            System.arraycopy(array, 0, temp, 0, array.length);
            array = temp;
        }
        array[++pointer] = i;
    }

    public void force(int i) {
        array[++pointer] = i;
    }

    public int get(int i) {
        if (i > pointer) super.throwOOB(i);
        return array[i];
    }

    public int pop() {
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

    public void set(int v, int idx) {
        if (idx > pointer)  super.throwOOB(idx);
        array[idx] = v;
    }

    public void softClear() {
        pointer = -1;
    }

    public void hardClear(int defaultValue) {
        Arrays.fill(array, defaultValue);
    }

    public int[] toArray() {
        int[] result = new int[pointer + 1];
        System.arraycopy(array, 0, result, 0, pointer + 1);
        return result;
    }

}
