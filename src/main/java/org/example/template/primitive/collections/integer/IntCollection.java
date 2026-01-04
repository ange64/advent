package org.example.template.primitive.collections.integer;

import org.example.template.primitive.collections.PCollection;
import org.example.template.primitive.functional.Pconsumer;
import org.example.template.primitive.functional.Ppredicate;

public interface IntCollection extends PCollection {

    boolean add(int l);

    default IntCollection addAll(int[] other) {
        forEach(this::add);
        return this;
    }

    default IntCollection addAll(IntCollection other) {
        forEach(this::add);
        return this;
    }

    default boolean containsAll(int[] other) {
        for (int l : other) {
            if (!this.contains(l)) return false;
        }
        return true;
    }

    default boolean containsAll(IntCollection other) {
        boolean[] pointer = new boolean[]{true};
        other.forEach(i -> {
            if (pointer[0] && !this.contains(i)) pointer[0] = false;
        });
        return pointer[0];
    }

    boolean remove(int element);

    boolean contains(int value);

    void removeIf(Ppredicate.Int p);

    void forEach(Pconsumer.Int c);

}