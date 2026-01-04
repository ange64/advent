package org.example.template.primitive;



import org.example.template.primitive.functional.PBiConsumer;

import java.util.NoSuchElementException;

public class StringUtils {

    public static int indexOfEnd(String toSearch, String toFind, int start) {
        var idx = toSearch.indexOf(toFind, start);
        return idx == -1 ? -1 : idx + toFind.length();
    }

    public static int indexOfEnd(String toSearch, String toFind, int start, int end) {
        var idx = toSearch.indexOf(toFind, start, end);
        return idx == -1 ? -1 : idx + toFind.length();
    }

    public static String between(String toSearch, char start, char end, int startIndex, int endIndex) {
        int idx = toSearch.indexOf(start, startIndex, endIndex);
        if (idx == -1) throw new NoSuchElementException("start delimiter not found");
        int idx2 = toSearch.indexOf(end, idx + 1,endIndex);
        if (idx2 == -1) throw new NoSuchElementException("end delimiter not found");
        return toSearch.substring(idx  + 1, idx2);
    }

    public static String between(String toSearch, char start, char end, int startIndex) {
        return between(toSearch, start, end, startIndex, toSearch.length());
    }

    public static int rangeOf(String toSearch, char start, char end, int startIndex, int endIndex) {
        int idx = toSearch.indexOf(start, startIndex);
        if (idx == -1) throw new NoSuchElementException("start delimiter not found");
        int idx2 = toSearch.indexOf(end, idx + 1, endIndex);
        if (idx2 == -1) throw new NoSuchElementException("end delimiter not found");
        return ((idx + 1) << 16 | idx2);
    }

    public static int rangeOf(String toSearch, char start, char end, int startIndex) {
        return rangeOf(toSearch, start, end, startIndex, toSearch.length());
    }

    public static void splitRanges(String toSplit, char split, PBiConsumer.Int range) {
        int idx1 = toSplit.charAt(0) == split ? 1 : 0;
        int idx2 = toSplit.indexOf(split, idx1);
        while (idx2 != -1) {
            range.accept(idx1, idx2);
            idx1 = idx2 + 1;
            idx2 = toSplit.indexOf(split, idx1);
        }
        range.accept(idx1, toSplit.length());
    }

    public static void splitRanges(String toSplit, int start, int end, char split, PBiConsumer.Int range) {
        int idx1 = start + toSplit.charAt(start) == split ? 1 : 0;
        int idx2 = toSplit.indexOf(split, idx1);
        while (idx2 != -1 && idx2 < end) {
            range.accept(idx1, idx2);
            idx1 = idx2 + 1;
            idx2 = toSplit.indexOf(split, idx1);
        }
    }

    public static void splitRanges(String toSplit, String split, PBiConsumer.Int range) {
        int idx1 = toSplit.startsWith(split) ? split.length() : 0;
        int idx2 = toSplit.indexOf(split, idx1);
        while (idx2 != -1) {
            range.accept(idx1, idx2);
            idx1 = idx2 + split.length();
            idx2 = toSplit.indexOf(split, idx1);
        }
        range.accept(idx1, toSplit.length());
    }

}
