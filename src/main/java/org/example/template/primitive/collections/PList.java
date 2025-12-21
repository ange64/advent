package org.example.template.primitive.collections;

public abstract class PList implements PCollection {

    int pointer;

    @Override
    public int size() {
        return pointer + 1;
    }

    @Override
    public void clear() {
        pointer = -1;
    }

    public abstract PList sort();

    @Override
    public boolean isEmpty() {
        return pointer == -1;
    }

    @Override
    public boolean isNotEmpty() {
        return pointer > -1;
    }

    protected void throwOOB(int index) {
        throw new IndexOutOfBoundsException("Out of boud for size " + size() + " at index " + index);
    }
}
