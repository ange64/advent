package org.example.template.primitive.collections;

import java.lang.reflect.Array;
import java.util.function.BiPredicate;
import java.util.function.Function;

public final class PrimitiveCollections {


    public static int computeExpendLength(int toAdd, int currentLen, int capacity) {
        if (toAdd + currentLen > capacity) {
            int newPow = Integer.numberOfLeadingZeros(toAdd + currentLen);
            int currPow = Integer.numberOfLeadingZeros(toAdd);
            return 1 + currPow - newPow;
        }
        return capacity;
    }

    public static String toString(Object array, int limit, String prefix) {
        var sb = new StringBuilder(prefix + "[");
        for (int i = 0; i < limit + 1; i++) {
            sb.append(Array.get(array, i)).append(",");
        }
        sb.deleteCharAt(sb.length() - 1).append("]");
        return sb.toString();
    }


    public static String toString(Object array, int limit, String prefix, Function<Object, String> mapper) {
        var sb = new StringBuilder(prefix + "[");
        for (int i = 0; i < limit + 1; i++) {
            sb.append(mapper.apply(Array.get(array, i))).append(",");
        }
        sb.deleteCharAt(sb.length() - 1).append("]");
        return sb.toString();
    }

    public static String toString(Object array, BiPredicate<Object, Integer> filter, String prefix, Function<Object, String> mapper) {
        var sb = new StringBuilder(prefix + "[");
        for (int i = 0; i < Array.getLength(array) + 1; i++) {
            if (filter.test(Array.get(array, i), i)) continue;
            sb.append(mapper.apply(Array.get(array, i))).append(",");
        }
        sb.deleteCharAt(sb.length() - 1).append("]");
        return sb.toString();
    }

}
