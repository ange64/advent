package org.example.template.primitive.collections;

import org.example.template.primitive.functional.Comparator;

public abstract class PrimitiveList {

    int pointer;

    public int size() {
        return pointer + 1;
    }

    public void softClear() {
        pointer = -1;
    }

    public abstract PrimitiveList sort();

    protected void throwOOB(int index) {
        throw new IndexOutOfBoundsException("Out of boud for size " + size() + " at index " + index);
    }
}
