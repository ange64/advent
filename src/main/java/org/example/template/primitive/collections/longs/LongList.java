package org.example.template.primitive.collections.longs;

import org.example.template.primitive.arrays.ArrUtils;
import org.example.template.primitive.collections.PList;
import org.example.template.primitive.functional.Consumer;
import org.example.template.primitive.functional.Mapper;

import java.util.Arrays;

import static org.example.template.primitive.collections.PrimitiveCollections.computeExpendLength;

public class LongList extends PList implements LongCollection {

    private long[] array;
    private int pointer = -1;

    public LongList() {
        array = new long[32];
    }

    public LongList(int initial) {
        array = new long[initial];
    }

    public LongList initializeTo(long value) {
        Arrays.fill(array, value);
        return this;
    }

    public boolean add(long i) {
        if (pointer == size()) array = ArrUtils.expand(array, 1);
        array[++pointer] = i;
        return true;
    }

    public LongList addAll(LongList other) {
        int len = computeExpendLength(other.size(), size(), array.length);
        if (len > array.length) array = ArrUtils.expand(array, len);
        System.arraycopy(other.array, 0, array, pointer + 1, other.size());
        pointer += other.size();
        return this;
    }

    @Override
    public LongList addAll(long[] other) {
        int len = computeExpendLength(other.length, size(), array.length);
        if (len > array.length) array = ArrUtils.expand(array, len);
        System.arraycopy(other, 0, array, pointer + 1, other.length);
        pointer += other.length;
        return this;
    }


    @Override
    public boolean remove(long element) {
        return ArrUtils.remove(array, size(), element, 0);
    }

    @Override
    public boolean isEmpty() {
        return pointer == -1;
    }

    @Override
    public boolean isNotEmpty() {
        return pointer > -1;
    }

    @Override
    public boolean contains(long value) {
        for (int i = 0; i < size(); i++) {
            if (value == array[i]) return true;
        }
        return false;
    }

    public LongCollection mapInPlace(Mapper.Long m) {
        for (int i = 0; i < size(); i++) {
            array[i] = m.map(array[i]);
        }
        return this;
    }

    @Override
    public void forEach(Consumer.Long c) {
        for (int i = 0; i < size(); i++) {
            c.accept(i);
        }
    }

    @Override
    public LongList sort() {
        Arrays.sort(array, 0, size());
        return this;
    }

    @Override
    public long[] toArray() {
        long[] result = new long[pointer + 1];
        System.arraycopy(array, 0, result, 0, pointer + 1);
        return result;
    }

    public void set(long v, int idx) {
        if (idx > pointer) super.throwOOB(pointer);
        array[idx] = v;
    }

    public long get(int i) {
        if (i > pointer) super.throwOOB(i);
        return array[i];
    }

    public long pop() {
        if (pointer == -1) super.throwOOB(pointer);
        return array[pointer--];
    }

    public long last() {
        return array[pointer];
    }

    public long first() {
        return array[0];
    }

    public int size() {
        return pointer + 1;
    }

    public void forEachIndexed(Consumer.LongIndexed c) {
        for (int i = 0; i < size(); i++) {
            c.accept(array[i], i);
        }
    }

}
