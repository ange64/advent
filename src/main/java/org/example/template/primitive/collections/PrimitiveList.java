package org.example.template.primitive.collections;

public abstract class PrimitiveList {

    int pointer;

    public int size() {
        return pointer + 1;
    }

    public void softClear() {
        pointer = -1;
    }


    protected void throwOOB(int index) {
        throw new IndexOutOfBoundsException("Out of boud for size " + size() + " at index " + index);
    }
}
