package org.example.template.primitive.collections.longs;

import org.example.template.primitive.collections.PCollection;
import org.example.template.primitive.functional.Consumer;
import org.example.template.primitive.functional.Mapper;

public interface LongCollection extends PCollection {

    boolean add(long l);

    default LongCollection addAll(long[] other) {
        forEach(this::add);
        return this;
    }

    default LongCollection addAll(LongCollection other) {
        forEach(this::add);
        return this;
    }

    default boolean containsAll(long[] other) {
        for (long l : other) {
            if (!this.contains(l)) return false;
        }
        return true;
    }

    default boolean containsAll(LongCollection other) {
        boolean[] pointer = new boolean[]{true};
        other.forEach(i -> {
            if (pointer[0] && !this.contains(i)) pointer[0] = false;
        });
        return pointer[0];
    }

    boolean remove(long element);

    boolean contains(long value);

    LongCollection mapInPlace(Mapper.Long m);

    void forEach(Consumer.Long c);

}