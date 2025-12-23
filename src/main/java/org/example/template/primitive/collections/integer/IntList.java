package org.example.template.primitive.collections.integer;

import org.example.template.primitive.arrays.ArrUtils;
import org.example.template.primitive.collections.PList;
import org.example.template.primitive.functional.Comparator;
import org.example.template.primitive.functional.Consumer;
import org.example.template.primitive.functional.Mapper;
import org.example.template.primitive.functional.Predicate;

import java.util.Arrays;

import static org.example.template.primitive.collections.PrimitiveCollections.computeExpendLength;

public class IntList extends PList implements IntCollection {

    private int[] array;
    private int pointer = -1;

    public IntList() {
        array = new int[64];
    }

    public IntList(int initial) {
        array = new int[initial];
    }

    public IntList initializeTo(int value) {
        Arrays.fill(array, value);
        return this;
    }

    public boolean add(int i) {
        if (pointer == size()) array = ArrUtils.expand(array, 1);
        array[++pointer] = i;
        return true;
    }

    public IntList addAll(IntList other) {
        int len = computeExpendLength(other.size(), size(), array.length);
        if (len > array.length) array = ArrUtils.expand(array, len);
        System.arraycopy(other.array, 0, array, pointer + 1, other.size());
        pointer += other.size();
        return this;
    }

    @Override
    public IntList addAll(int[] other) {
        int len = computeExpendLength(other.length, size(), array.length);
        if (len > array.length) array = ArrUtils.expand(array, len);
        System.arraycopy(other, 0, array, pointer + 1, other.length);
        pointer += other.length;
        return this;
    }

    @Override
    public boolean remove(int element) {
        return ArrUtils.remove(array, size(), element, 0);
    }

    public boolean removeAt(int element) {
        return ArrUtils.removeAt(array, size(), element, 0);
    }

    public long sum() {
        return ArrUtils.sum(array, size());
    }

    public long sumBy(Mapper.IntIndexed m ) {
        return ArrUtils.sumBy(array, size(), m);
    }

    public long count(Predicate.Int p) {
        return ArrUtils.count(array, size(), p);
    }

    public long max() {
        return ArrUtils.max(array, 0, size());
    }

    public long min() {
        return ArrUtils.min(array, 0, size());
    }

    public long maxBy(Comparator.Int m) {
        return ArrUtils.maxBy(array, 0, size(), m);
    }

    public long minBy(Comparator.Int m) {
        return ArrUtils.minBy(array, 0, size(), m);
    }

    public int indexOf(int value) {
        return ArrUtils.indexOf(array, size(), value);
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
    public boolean contains(int value) {
        for (int i = 0; i < size(); i++) {
            if (value == array[i]) return true;
        }
        return false;
    }

    @Override
    public void removeIf(Predicate.Int p) {
        for (int i = size() - 1; i >= 0; i--) {
            if (p.test(array[i])) {
                removeAt(i);
            }
        }
    }

    public IntCollection mapInPlace(Mapper.Int m) {
        for (int i = 0; i < size(); i++) {
            array[i] = m.map(array[i]);
        }
        return this;
    }

    @Override
    public void forEach(Consumer.Int c) {
        for (int i = 0; i < size(); i++) {
            c.accept(array[i]);
        }
    }

    @Override
    public IntList sort() {
        Arrays.sort(array, 0, size());
        return this;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[pointer + 1];
        System.arraycopy(array, 0, result, 0, pointer + 1);
        return result;
    }


    public void set(int v, int idx) {
        if (idx > pointer) super.throwOOB(pointer);
        array[idx] = v;
    }

    public int get(int i) {
        if (i > pointer) super.throwOOB(i);
        return array[i];
    }

    public long pop() {
        if (pointer == -1) super.throwOOB(pointer);
        return array[pointer--];
    }

    public int last() {
        return array[pointer];
    }

    public int first() {
        return array[0];
    }

    public int size() {
        return pointer + 1;
    }

    public void forEachIndexed(Consumer.IntIndexed c) {
        for (int i = 0; i < size(); i++) {
            c.accept(array[i], i);
        }
    }

}
