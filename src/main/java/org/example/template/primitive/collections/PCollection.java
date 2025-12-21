package org.example.template.primitive.collections;

public interface PCollection {

    <T> T toArray();

    int size();

    void clear();

    boolean isEmpty();

    boolean isNotEmpty();
}
