package org.example.template.primitive.arrays;

import  org.example.template.primitive.functional.*;

public abstract class ArrUtils {

    public static int indexOf(long[] array, long target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    public static int indexOf(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    public static int indexOf(short[] array, short target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    public static int indexOf(char[] array, char target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    public static int indexOf(byte[] array, byte target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    public static int indexOf(boolean[] array, boolean target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }


    public static int indexOf(double[] array, double target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    public static long sum(byte[] array) {
        long sum = 0;
        for (byte v : array) sum += v;
        return sum;
    }

    public static long sum(short[] array) {
        long sum = 0;
        for (short v : array) sum += v;
        return sum;
    }

    public static long sum(char[] array) {
        long sum = 0;
        for (char v : array) sum += v;
        return sum;
    }

    public static long sum(int[] array) {
        long sum = 0;
        for (int v : array) sum += v;
        return sum;
    }

    public static long sum(long[] array) {
        long sum = 0;
        for (long v : array) sum += v;
        return sum;
    }

    public static double sum(float[] array) {
        double sum = 0;
        for (float v : array) sum += v;
        return sum;
    }

    public static double sum(double[] array) {
        double sum = 0;
        for (double v : array) sum += v;
        return sum;
    }

    public static int sum(boolean[] array) {
        int sum = 0;
        for (boolean b : array) if (b) sum++;
        return sum;
    }

    public static void forEach(long[] array, Consumer.Long c, int start, int end, int step) {
        for (int i = start; i < end; i += step) {
            c.accept(array[i]);
        }
    }

    public static void forEach(int[] array, Consumer.Int c, int start, int end, int step) {
        for (int i = start; i < end; i += step) {
            c.accept(array[i]);
        }
    }

    public static void forEach(short[] array, Consumer.Short c, int start, int end, int step) {
        for (int i = start; i < end; i += step) {
            c.accept(array[i]);
        }
    }

    public static void forEach(byte[] array, Consumer.Byte c, int start, int end, int step) {
        for (int i = start; i < end; i += step) {
            c.accept(array[i]);
        }
    }

    public static void forEach(char[] array, Consumer.Char c, int start, int end, int step) {
        for (int i = start; i < end; i += step) {
            c.accept(array[i]);
        }
    }

    public static void forEach(boolean[] array, Consumer.Bool c, int start, int end, int step) {
        for (int i = start; i < end; i += step) {
            c.accept(array[i]);
        }
    }

    public static void forEach(float[] array, Consumer.Float c, int start, int end, int step) {
        for (int i = start; i < end; i += step) {
            c.accept(array[i]);
        }
    }

    public static void forEach(double[] array, Consumer.Double c, int start, int end, int step) {
        for (int i = start; i < end; i += step) {
            c.accept(array[i]);
        }
    }

    public static void forEach(long[] array, Consumer.Long c) {
        for (int i = 0; i < array.length; i++) {
            c.accept(array[i]);
        }
    }

    public static void forEach(int[] array, Consumer.Int c) {
        for (int i = 0; i < array.length; i++) {
            c.accept(array[i]);
        }
    }

    public static void forEach(short[] array, Consumer.Short c) {
        for (int i = 0; i < array.length; i++) {
            c.accept(array[i]);
        }
    }

    public static void forEach(byte[] array, Consumer.Byte c) {
        for (int i = 0; i < array.length; i++) {
            c.accept(array[i]);
        }
    }

    public static void forEach(char[] array, Consumer.Char c) {
        for (int i = 0; i < array.length; i++) {
            c.accept(array[i]);
        }
    }

    public static void forEach(boolean[] array, Consumer.Bool c) {
        for (int i = 0; i < array.length; i++) {
            c.accept(array[i]);
        }
    }

    public static void forEach(float[] array, Consumer.Float c) {
        for (int i = 0; i < array.length; i++) {
            c.accept(array[i]);
        }
    }

    public static void forEach(double[] array, Consumer.Double c) {
        for (int i = 0; i < array.length; i++) {
            c.accept(array[i]);
        }
    }


    public static void forEachIndexed(long[] array, Consumer.LongIndexed c) {
        for (int i = 0; i < array.length; i++) {
            c.accept(array[i], i);
        }
    }

    public static void forEachIndexed(int[] array, Consumer.IntIndexed c) {
        for (int i = 0; i < array.length; i++) {
            c.accept(array[i], i);
        }
    }

    public static void forEachIndexed(short[] array, Consumer.ShortIndexed c) {
        for (int i = 0; i < array.length; i++) {
            c.accept(array[i], i);
        }
    }

    public static void forEachIndexed(byte[] array, Consumer.ByteIndexed c) {
        for (int i = 0; i < array.length; i++) {
            c.accept(array[i], i);
        }
    }

    public static void forEachIndexed(char[] array, Consumer.CharIndexed c) {
        for (int i = 0; i < array.length; i++) {
            c.accept(array[i], i);
        }
    }

    public static void forEachIndexed(boolean[] array, Consumer.BoolIndexed c) {
        for (int i = 0; i < array.length; i++) {
            c.accept(array[i], i);
        }
    }

    public static void forEachIndexed(float[] array, Consumer.FloatIndexed c) {
        for (int i = 0; i < array.length; i++) {
            c.accept(array[i], i);
        }
    }

    public static void forEachIndexed(double[] array, Consumer.DoubleIndexed c) {
        for (int i = 0; i < array.length; i++) {
            c.accept(array[i], i);
        }
    }

    /**
     * Maps an element to another value in place in the array.
     */
    public static void mapInPlace(long[] array, Mapper.Long m) {
        for (int i = 0; i < array.length; i++) {
            array[i] = m.map(array[i]);
        }
    }

    /**
     * Maps an element to another value in place in the array.
     */
    public static void mapInPlace(int[] array, Mapper.Int m) {
        for (int i = 0; i < array.length; i++) {
            array[i] = m.map(array[i]);
        }
    }

    /**
     * Maps an element to another value in place in the array.
     */
    public static void mapInPlace(short[] array, Mapper.Short m) {
        for (int i = 0; i < array.length; i++) {
            array[i] = m.map(array[i]);
        }
    }

    /**
     * Maps an element to another value in place in the array.
     */
    public static void mapInPlace(byte[] array, Mapper.Byte m) {
        for (int i = 0; i < array.length; i++) {
            array[i] = m.map(array[i]);
        }
    }

    /**
     * Maps an element to another value in place in the array.
     */
    public static void mapInPlace(char[] array, Mapper.Char m) {
        for (int i = 0; i < array.length; i++) {
            array[i] = m.map(array[i]);
        }
    }

    /**
     * Maps an element to another value in place in the array.
     */
    public static void mapInPlace(boolean[] array, Mapper.Bool m) {
        for (int i = 0; i < array.length; i++) {
            array[i] = m.map(array[i]);
        }
    }

    /**
     * Maps an element to another value in place in the array.
     */
    public static void mapInPlace(float[] array, Mapper.Float m) {
        for (int i = 0; i < array.length; i++) {
            array[i] = m.map(array[i]);
        }
    }

    /**
     * Maps an element to another value in place in the array.
     */
    public static void mapInPlace(double[] array, Mapper.Double m) {
        for (int i = 0; i < array.length; i++) {
            array[i] = m.map(array[i]);
        }
    }

    /**
     * @return the first index of array matching the predicate, -1 otherwise
     */
    public static int first(long[] array, Predicate.Long p) {
        for (int i = 0; i < array.length; i++) {
            if (p.test(array[i])) return i;
        }
        return  -1;
    }

    /**
     * @return the first index of array matching the predicate, -1 otherwise
     */
    public static int first(int[] array, Predicate.Int p) {
        for (int i = 0; i < array.length; i++) {
            if (p.test(array[i])) return i;
        }
        return  -1;
    }


    /**
     * @return the first index of array matching the predicate, -1 otherwise
     */
    public static int first(short[] array, Predicate.Short p) {
        for (int i = 0; i < array.length; i++) {
            if (p.test(array[i])) return i;
        }
        return  -1;
    }

    /**
     * @return the first index of array matching the predicate, -1 otherwise
     */
    public static int first(char[] array, Predicate.Char p) {
        for (int i = 0; i < array.length; i++) {
            if (p.test(array[i])) return i;
        }
        return  -1;
    }


    /**
     * @return the first index of array matching the predicate, -1 otherwise
     */
    public static int first(byte[] array, Predicate.Byte p) {
        for (int i = 0; i < array.length; i++) {
            if (p.test(array[i])) return i;
        }
        return  -1;
    }

    /**
     * @return the first index of array matching the predicate, -1 otherwise
     */
    public static int first(boolean[] array, Predicate.Boolean p) {
        for (int i = 0; i < array.length; i++) {
            if (p.test(array[i])) return i;
        }
        return  -1;
    }


}
