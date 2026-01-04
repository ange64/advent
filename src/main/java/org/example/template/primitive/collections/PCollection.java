package org.example.template.primitive.collections;

import java.lang.reflect.Array;
import java.util.function.BiPredicate;
import java.util.function.Function;

public interface PCollection {

    <T> T toArray();

    int size();

    void clear();

    boolean isEmpty();

    boolean isNotEmpty();

}
