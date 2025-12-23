package org.example.template.primitive.collections.integer;

import org.example.template.primitive.arrays.ArrUtils;
import org.example.template.primitive.functional.Consumer;
import org.example.template.primitive.functional.Mapper;
import org.example.template.primitive.functional.Predicate;

import java.util.NoSuchElementException;

public class IntQueue implements IntCollection {

    private int start = 0;
    private int end = -1;
    private int[] array;

    public IntQueue(){
        array = new int[64];
    }

    public IntQueue(int initial){
        array = new int[initial];
    }

    @Override
    public boolean add(int i) {
        if (end + 1 == array.length) {
            if (start < (array.length >> 1)) array = ArrUtils.expand(array, 1);
            else shiftDown();
        }
        array[++end] = i;
        return true;
    }

    public int pop() {
        if (start > end) throw new NoSuchElementException("queue is empty");
        int temp = array[start++];
        if (start > end) {
            end = -1;
            start = 0;
        }
        return temp;
    }

    @Override
    public boolean remove(int element) {
        for (int i = start; i <= end; i++) {
            if (array[i] == element) {
                for (int j = i; j < end; j++) {
                    array[j] = array[j + 1];
                }
                end--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(int value) {
        for (int i = start; i <= end; i++) {
            if (array[i] == value) return true;
        }
        return false;
    }

    @Override
    public void removeIf(Predicate.Int p) {
        for (int i = start; i <= end; i++) {
            if (p.test(array[i])) {
                remove(array[i]);
            }
        }
    }

    public IntQueue mapInPlace(Mapper.Int m) {
        for (int i = start; i <= end; i++) {
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
    public int[] toArray() {
        int[] result = new int[end - start];
        System.arraycopy(array, start, result, 0, size());
        return result;
    }

    @Override
    public int size() {
        return end - start + 1;
    }

    @Override
    public void clear() {
        start = -1;
        end = -1;
    }

    @Override
    public boolean isEmpty() {
        return start == end;
    }

    @Override
    public boolean isNotEmpty() {
        return start < end;
    }

    public int first() {
        return array[start];
    }

    public int last() {
        return array[end];
    }

    private void shiftDown() {
        for (int i = start; i <= end; i++) {
            array[i - start] = array[i];
        }
        end -= start;
        start = 0;
    }
}
