package org.example.template.primitive.arrays;

import org.example.template.primitive.functional.*;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

@SuppressWarnings("unused")
public abstract class ArrUtils {

    public static int indexOf(long[] array, long target) {
        return ArrUtils.indexOf(array, array.length, target);
    }

    public static int indexOf(int[] array, int target) {
        return ArrUtils.indexOf(array, array.length, target);
    }

    public static int indexOf(byte[] array, byte target) {
        return ArrUtils.indexOf(array, array.length, target);
    }

    public static int indexOf(short[] array, short target) {
        return ArrUtils.indexOf(array, array.length, target);
    }

    public static int indexOf(boolean[] array, boolean target) {
        return ArrUtils.indexOf(array, array.length, target);
    }

    public static int indexOf(char[] array, char target) {
        return ArrUtils.indexOf(array, array.length, target);
    }

    public static int indexOf(float[] array, float target) {
        return ArrUtils.indexOf(array, array.length, target);
    }

    public static int indexOf(double[] array, double target) {
        return ArrUtils.indexOf(array, array.length, target);
    }

    public static <T> int indexOf(T[] array, T target) {
        return ArrUtils.indexOf(array, array.length, target);
    }

    public static int indexOf(long[] array, int end, long target) {
        for (int i = 0; i < end; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    public static int indexOf(int[] array, int end, int target) {
        for (int i = 0; i < end; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    public static int indexOf(short[] array, int end, short target) {
        for (int i = 0; i < end; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    public static int indexOf(char[] array, int end, char target) {
        for (int i = 0; i < end; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    public static int indexOf(byte[] array, int end, byte target) {
        for (int i = 0; i < end; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    public static int indexOf(boolean[] array, int end, boolean target) {
        for (int i = 0; i < end; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    public static int indexOf(float[] array, int end, float target) {
        for (int i = 0; i < end; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    public static int indexOf(double[] array, int end, double target) {
        for (int i = 0; i < end; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    public static <T> int indexOf(T[] array, int end, T target) {
        for (int i = 0; i < end; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    public static <T> double sumBy(T[] array, Mapper.ObjToDoubleIndexed<T> mapper) {
        return ArrUtils.sumBy(array, array.length, mapper);
    }

    public static <T> long sumBy(T[] array, Mapper.ObjToLongIndexed<T> mapper) {
        return ArrUtils.sumBy(array, array.length, mapper);
    }

    public static long sumBy(long[] array, Mapper.LongIndexed mapper) {
        return ArrUtils.sumBy(array, array.length, mapper);
    }

    public static long sumBy(int[] array, Mapper.IntIndexed mapper) {
        return ArrUtils.sumBy(array, array.length, mapper);
    }

    public static long sumBy(char[] array, Mapper.CharToIntIndexed mapper) {
        return ArrUtils.sumBy(array, array.length, mapper);
    }

    public static long sumBy(short[] array, Mapper.ShortIndexed mapper) {
        return ArrUtils.sumBy(array, array.length, mapper);
    }

    public static long sumBy(byte[] array, Mapper.ByteIndexed mapper) {
        return ArrUtils.sumBy(array, array.length, mapper);
    }

    public static double sumBy(float[] array, Mapper.FloatIndexed mapper) {
        return ArrUtils.sumBy(array, array.length, mapper);
    }

    public static double sumBy(double[] array, Mapper.DoubleIndexed mapper) {
        return ArrUtils.sumBy(array, array.length, mapper);
    }

    private static <T> long sumBy(T[] array, int end, Mapper.ObjToLongIndexed<T> mapper) {
        long sum = 0;
        for (var i = 0; i < end; i++) {
            sum += mapper.map(array[i], i);
        }
        return sum;
    }

    private static <T> double sumBy(T[] array, int end, Mapper.ObjToDoubleIndexed<T> mapper) {
        double sum = 0;
        for (var i = 0; i < end; i++) {
            sum += mapper.map(array[i], i);
        }
        return sum;
    }

    public static long sumBy(long[] array, int end, Mapper.LongIndexed mapper) {
        long sum = 0;
        for (var i = 0; i < end; i++) {
            sum += mapper.map(array[i], i);
        }
        return sum;
    }

    public static long sumBy(int[] array, int end, Mapper.IntIndexed mapper) {
        long sum = 0;
        for (var i = 0; i < end; i++) {
            sum += mapper.map(array[i], i);
        }
        return sum;
    }

    public static long sumBy(short[] array, int end, Mapper.ShortIndexed mapper) {
        long sum = 0;
        for (var i = 0; i < end; i++) {
            sum += mapper.map(array[i], i);
        }
        return sum;
    }

    public static long sumBy(byte[] array, int end, Mapper.ByteIndexed mapper) {
        long sum = 0;
        for (var i = 0; i < end; i++) {
            sum += mapper.map(array[i], i);
        }
        return sum;
    }

    public static long sumBy(boolean[] array, int end, Mapper.BoolToIntIndexed mapper) {
        long sum = 0;
        for (var i = 0; i < end; i++) {
            sum += mapper.map(array[i], i);
        }
        return sum;
    }

    public static long sumBy(char[] array, int end, Mapper.CharToIntIndexed mapper) {
        long sum = 0;
        for (var i = 0; i < array.length; i++) {
            sum += mapper.map(array[i], i);
        }
        return sum;
    }

    public static double sumBy(float[] array, int end, Mapper.FloatIndexed mapper) {
        double sum = 0;
        for (var i = 0; i < array.length; i++) {
            sum += mapper.map(array[i], i);
        }
        return sum;
    }

    public static double sumBy(double[] array, int end, Mapper.DoubleIndexed mapper) {
        double sum = 0;
        for (var i = 0; i < array.length; i++) {
            sum += mapper.map(array[i], i);
        }
        return sum;
    }

    public static long sum(long[] array, int end) {
        long sum = 0;
        for (int i = 0; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static long sum(int[] array, int end) {
        long sum = 0;
        for (int i = 0; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static long sum(short[] array, int end) {
        long sum = 0;
        for (int i = 0; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static long sum(char[] array, int end) {
        long sum = 0;
        for (int i = 0; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static double sum(float[] array, int end) {
        double sum = 0;
        for (int i = 0; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static double sum(double[] array, int end) {
        double sum = 0;
        for (int i = 0; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static long sum(byte[] array, int end) {
        long sum = 0;
        for (int i = 0; i < end; i++) {
            sum += array[i];
        }
        return sum;
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
        for (long l : array) {
            c.accept(l);
        }
    }

    public static void forEach(int[] array, Consumer.Int c) {
        for (int j : array) {
            c.accept(j);
        }
    }

    public static void forEach(short[] array, Consumer.Short c) {
        for (short value : array) {
            c.accept(value);
        }
    }

    public static void forEach(byte[] array, Consumer.Byte c) {
        for (byte b : array) {
            c.accept(b);
        }
    }

    public static void forEach(char[] array, Consumer.Char c) {
        for (char value : array) {
            c.accept(value);
        }
    }

    public static void forEach(boolean[] array, Consumer.Bool c) {
        for (boolean b : array) {
            c.accept(b);
        }
    }

    public static void forEach(float[] array, Consumer.Float c) {
        for (float v : array) {
            c.accept(v);
        }
    }

    public static void forEach(double[] array, Consumer.Double c) {
        for (double v : array) {
            c.accept(v);
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
    public static void mapInPlace(long[] array, int limit, Mapper.Long m) {
        for (int i = 0; i < limit; i++) {
            array[i] = m.map(array[i]);
        }
    }

    /**
     * Maps an element to another value in place in the array.
     */
    public static void mapInPlace(int[] array, int limit, Mapper.Int m) {
        for (int i = 0; i < limit; i++) {
            array[i] = m.map(array[i]);
        }
    }

    /**
     * Maps an element to another value in place in the array.
     */
    public static void mapInPlace(short[] array, int limit, Mapper.Short m) {
        for (int i = 0; i < limit; i++) {
            array[i] = m.map(array[i]);
        }
    }

    /**
     * Maps an element to another value in place in the array.
     */
    public static void mapInPlace(byte[] array, int limit, Mapper.Byte m) {
        for (int i = 0; i < limit; i++) {
            array[i] = m.map(array[i]);
        }
    }

    /**
     * Maps an element to another value in place in the array.
     */
    public static void mapInPlace(char[] array, int limit, Mapper.Char m) {
        for (int i = 0; i < limit; i++) {
            array[i] = m.map(array[i]);
        }
    }

    /**
     * Maps an element to another value in place in the array.
     */
    public static void mapInPlace(boolean[] array, int limit, Mapper.Bool m) {
        for (int i = 0; i < limit; i++) {
            array[i] = m.map(array[i]);
        }
    }

    /**
     * Maps an element to another value in place in the array.
     */
    public static void mapInPlace(float[] array, int limit, Mapper.Float m) {
        for (int i = 0; i < limit; i++) {
            array[i] = m.map(array[i]);
        }
    }

    /**
     * Maps an element to another value in place in the array.
     */
    public static void mapInPlace(double[] array, int limit, Mapper.Double m) {
        for (int i = 0; i < limit; i++) {
            array[i] = m.map(array[i]);
        }
    }

    /**
     * Maps an element to another value in place in the array.
     */
    public static <T> void mapInPlace(T[] array, int limit, UnaryOperator<T> m) {
        for (int i = 0; i < limit; i++) {
            array[i] = m.apply(array[i]);
        }
    }

    /**
     * @return the first index of array matching the predicate, -1 otherwise
     */
    public static int first(long[] array, Predicate.Long p) {
        for (int i = 0; i < array.length; i++) {
            if (p.test(array[i])) return i;
        }
        return -1;
    }

    /**
     * @return the first index of array matching the predicate, -1 otherwise
     */
    public static int first(int[] array, Predicate.Int p) {
        for (int i = 0; i < array.length; i++) {
            if (p.test(array[i])) return i;
        }
        return -1;
    }


    /**
     * @return the first index of array matching the predicate, -1 otherwise
     */
    public static int first(short[] array, Predicate.Short p) {
        for (int i = 0; i < array.length; i++) {
            if (p.test(array[i])) return i;
        }
        return -1;
    }

    /**
     * @return the first index of array matching the predicate, -1 otherwise
     */
    public static int first(char[] array, Predicate.Char p) {
        for (int i = 0; i < array.length; i++) {
            if (p.test(array[i])) return i;
        }
        return -1;
    }

    /**
     * @return the first index of array matching the predicate, -1 otherwise
     */
    public static int first(byte[] array, Predicate.Byte p) {
        for (int i = 0; i < array.length; i++) {
            if (p.test(array[i])) return i;
        }
        return -1;
    }

    /**
     * @return the first index of array matching the predicate, -1 otherwise
     */
    public static int first(boolean[] array, Predicate.Boolean p) {
        for (int i = 0; i < array.length; i++) {
            if (p.test(array[i])) return i;
        }
        return -1;
    }

    public static long max(long[] array) {
        long m = 0;
        for (long i : array) {
            if (i > m) m = i;
        }
        return m;
    }

    public static int max(int[] array) {
        int m = 0;
        for (int i : array) {
            if (i > m) m = i;
        }
        return m;
    }

    public static short max(short[] array) {
        short m = 0;
        for (short i : array) {
            if (i > m) m = i;
        }
        return m;
    }

    public static char max(char[] array) {
        char m = 0;
        for (char i : array) {
            if (i > m) m = i;
        }
        return m;
    }

    public static byte max(byte[] array) {
        byte m = 0;
        for (byte i : array) {
            if (i > m) m = i;
        }
        return m;
    }

    public static float max(float[] array) {
        float m = 0;
        for (float i : array) {
            if (i > m) m = i;
        }
        return m;
    }

    public static double max(double[] array) {
        double m = 0;
        for (double i : array) {
            if (i > m) m = i;
        }
        return m;
    }

    public static long min(long[] array) {
        long m = Long.MAX_VALUE;
        for (long i : array) {
            if (i < m) m = i;
        }
        return m;
    }

    public static int min(int[] array) {
        int m = Integer.MAX_VALUE;
        for (int i : array) {
            if (i < m) m = i;
        }
        return m;
    }

    public static short min(short[] array) {
        short m = Short.MAX_VALUE;
        for (short i : array) {
            if (i < m) m = i;
        }
        return m;
    }

    public static char min(char[] array) {
        char m = Character.MAX_VALUE;
        for (char i : array) {
            if (i < m) m = i;
        }
        return m;
    }

    public static byte min(byte[] array) {
        byte m = Byte.MAX_VALUE;
        for (byte i : array) {
            if (i < m) m = i;
        }
        return m;
    }

    public static float min(float[] array) {
        float m = Float.MAX_VALUE;
        for (float i : array) {
            if (i < m) m = i;
        }
        return m;
    }

    public static double min(double[] array) {
        double m = Double.MAX_VALUE;
        for (double i : array) {
            if (i < m) m = i;
        }
        return m;
    }

    /// bounded
    public static long max(long[] array, int start, int end) {
        long m = 0;
        for (int i = start; i < end; i++) {
            if (i > m) m = array[i];
        }
        return m;
    }

    public static int max(int[] array, int start, int end) {
        int m = 0;
        for (int i = start; i < end; i++) {
            if (i > m) m = array[i];
        }
        return m;
    }

    public static short max(short[] array, int start, int end) {
        short m = 0;
        for (int i = start; i < end; i++) {
            if (i > m) m = array[i];
        }
        return m;
    }

    public static char max(char[] array, int start, int end) {
        char m = 0;
        for (int i = start; i < end; i++) {
            if (i > m) m = array[i];
        }
        return m;
    }

    public static byte max(byte[] array, int start, int end) {
        byte m = 0;
        for (int i = start; i < end; i++) {
            if (i > m) m = array[i];
        }
        return m;
    }

    public static float max(float[] array, int start, int end) {
        float m = 0;
        for (int i = start; i < end; i++) {
            if (i > m) m = array[i];
        }
        return m;
    }

    public static double max(double[] array, int start, int end) {
        double m = 0;
        for (int i = start; i < end; i++) {
            if (i > m) m = array[i];
        }
        return m;
    }

    public static long min(long[] array, int start, int end) {
        long m = Long.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (i < m) m = array[i];
        }
        return m;
    }

    public static int min(int[] array, int start, int end) {
        int m = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (i < m) m = array[i];
        }
        return m;
    }

    public static short min(short[] array, int start, int end) {
        short m = Short.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (i < m) m = array[i];
        }
        return m;
    }

    public static char min(char[] array, int start, int end) {
        char m = Character.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (i < m) m = array[i];
        }
        return m;
    }

    public static byte min(byte[] array, int start, int end) {
        byte m = Byte.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (i < m) m = array[i];
        }
        return m;
    }

    public static float min(float[] array, int start, int end) {
        float m = Float.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (i < m) m = array[i];
        }
        return m;
    }

    public static double min(double[] array, int start, int end) {
        double m = Double.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (i < m) m = array[i];
        }
        return m;
    }

    public static long maxBy(long[] array, int start, int end, Comparator.Long c) {
        long m = 0;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) > 0) m = array[i];
        }
        return m;
    }

    public static int maxBy(int[] array, int start, int end, Comparator.Int c) {
        int m = 0;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) > 0) m = array[i];
        }
        return m;
    }

    public static short maxBy(short[] array, int start, int end, Comparator.Short c) {
        short m = 0;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) > 0) m = array[i];
        }
        return m;
    }

    public static char maxBy(char[] array, int start, int end, Comparator.Char c) {
        char m = 0;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) > 0) m = array[i];
        }
        return m;
    }

    public static byte maxBy(byte[] array, int start, int end, Comparator.Byte c) {
        byte m = 0;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) > 0) m = array[i];
        }
        return m;
    }

    public static float maxBy(float[] array, int start, int end, Comparator.Float c) {
        float m = 0;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) > 0) m = array[i];
        }
        return m;
    }

    public static double maxBy(double[] array, int start, int end, Comparator.Double c) {
        double m = 0;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) > 0) m = array[i];
        }
        return m;
    }

    public static long minBy(long[] array, int start, int end, Comparator.Long c) {
        long m = Long.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) < 0) m = array[i];
        }
        return m;
    }

    public static int minBy(int[] array, int start, int end, Comparator.Int c) {
        int m = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) < 0) m = array[i];
        }
        return m;
    }

    public static short minBy(short[] array, int start, int end, Comparator.Short c) {
        short m = Short.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) < 0) m = array[i];
        }
        return m;
    }

    public static char minBy(char[] array, int start, int end, Comparator.Char c) {
        char m = Character.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) < 0) m = array[i];
        }
        return m;
    }

    public static byte minBy(byte[] array, int start, int end, Comparator.Byte c) {
        byte m = Byte.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) < 0) m = array[i];
        }
        return m;
    }

    public static float minBy(float[] array, int start, int end, Comparator.Float c) {
        float m = Float.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) < 0) m = array[i];
        }
        return m;
    }

    public static double minBy(double[] array, int start, int end, Comparator.Double c) {
        double m = Double.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) < 0) m = array[i];
        }
        return m;
    }

    public static boolean windowMatch(long[] array, int start, int length, Predicate.Long p) {
        for (int i = start; i < start + length; i++) {
            if (!p.test(array[i])) return false;
        }
        return true;
    }

    public static boolean windowMatch(int[] array, int start, int length, Predicate.Int p) {
        for (int i = start; i < start + length; i++) {
            if (!p.test(array[i])) return false;
        }
        return true;
    }

    public static boolean windowMatch(short[] array, int start, int length, Predicate.Short p) {
        for (int i = start; i < start + length; i++) {
            if (!p.test(array[i])) return false;
        }
        return true;
    }

    public static boolean windowMatch(char[] array, int start, int length, Predicate.Char p) {
        for (int i = start; i < start + length; i++) {
            if (!p.test(array[i])) return false;
        }
        return true;
    }

    public static boolean windowMatch(byte[] array, int start, int length, Predicate.Byte p) {
        for (int i = start; i < start + length; i++) {
            if (!p.test(array[i])) return false;
        }
        return true;
    }

    public static boolean windowMatch(boolean[] array, int start, int length, Predicate.Boolean p) {
        for (int i = start; i < start + length; i++) {
            if (!p.test(array[i])) return false;
        }
        return true;
    }

    public static boolean windowMatch(float[] array, int start, int length, Predicate.Float p) {
        for (int i = start; i < start + length; i++) {
            if (!p.test(array[i])) return false;
        }
        return true;
    }

    public static boolean windowMatch(double[] array, int start, int length, Predicate.Double p) {
        for (int i = start; i < start + length; i++) {
            if (!p.test(array[i])) return false;
        }
        return true;
    }

    public static boolean any(long[] array, Predicate.LongIndexed pi) {
        for (int i = 0; i < array.length; i++) {
            if (pi.test(array[i], i)) return true;
        }
        return false;
    }

    public static boolean any(int[] array, Predicate.IntIndexed pi) {
        for (int i = 0; i < array.length; i++) {
            if (pi.test(array[i], i)) return true;
        }
        return false;
    }

    public static boolean any(short[] array, Predicate.ShortIndexed pi) {
        for (int i = 0; i < array.length; i++) {
            if (pi.test(array[i], i)) return true;
        }
        return false;
    }

    public static boolean any(byte[] array, Predicate.ByteIndexed pi) {
        for (int i = 0; i < array.length; i++) {
            if (pi.test(array[i], i)) return true;
        }
        return false;
    }

    public static boolean any(char[] array, Predicate.CharIndexed pi) {
        for (int i = 0; i < array.length; i++) {
            if (pi.test(array[i], i)) return true;
        }
        return false;
    }

    public static boolean any(boolean[] array, Predicate.BooleanIndexed pi) {
        for (int i = 0; i < array.length; i++) {
            if (pi.test(array[i], i)) return true;
        }
        return false;
    }

    public static boolean any(float[] array, Predicate.FloatIndexed pi) {
        for (int i = 0; i < array.length; i++) {
            if (pi.test(array[i], i)) return true;
        }
        return false;
    }

    public static boolean any(double[] array, Predicate.DoubleIndexed pi) {
        for (int i = 0; i < array.length; i++) {
            if (pi.test(array[i], i)) return true;
        }
        return false;
    }

    public static boolean any(long[] array, Predicate.Long p) {
        for (long l : array) {
            if (p.test(l)) return true;
        }
        return false;
    }

    public static boolean any(int[] array, Predicate.Int p) {
        for (int j : array) {
            if (p.test(j)) return true;
        }
        return false;
    }

    public static boolean any(short[] array, Predicate.Short p) {
        for (short value : array) {
            if (p.test(value)) return true;
        }
        return false;
    }

    public static boolean any(byte[] array, Predicate.Byte p) {
        for (byte b : array) {
            if (p.test(b)) return true;
        }
        return false;
    }

    public static boolean any(char[] array, Predicate.Char p) {
        for (char c : array) {
            if (p.test(c)) return true;
        }
        return false;
    }

    public static boolean any(boolean[] array, Predicate.Boolean p) {
        for (boolean b : array) {
            if (p.test(b)) return true;
        }
        return false;
    }

    public static boolean any(float[] array, Predicate.Float p) {
        for (float v : array) {
            if (p.test(v)) return true;
        }
        return false;
    }

    public static boolean any(double[] array, Predicate.Double p) {
        for (double v : array) {
            if (p.test(v)) return true;
        }
        return false;
    }

    public static boolean none(long[] array, Predicate.Long p) {
        for (long l : array) {
            if (p.test(l)) return false;
        }
        return true;
    }

    public static boolean none(int[] array, Predicate.Int p) {
        for (int j : array) {
            if (p.test(j)) return false;
        }
        return true;
    }

    public static boolean none(short[] array, Predicate.Short p) {
        for (short value : array) {
            if (p.test(value)) return false;
        }
        return true;
    }

    public static boolean none(byte[] array, Predicate.Byte p) {
        for (byte b : array) {
            if (p.test(b)) return false;
        }
        return true;
    }

    public static boolean none(char[] array, Predicate.Char p) {
        for (char c : array) {
            if (p.test(c)) return false;
        }
        return true;
    }

    public static boolean none(boolean[] array, Predicate.Boolean p) {
        for (boolean b : array) {
            if (p.test(b)) return false;
        }
        return true;
    }

    public static boolean none(float[] array, Predicate.Float p) {
        for (float v : array) {
            if (p.test(v)) return false;
        }
        return true;
    }

    public static boolean none(double[] array, Predicate.Double p) {
        for (double v : array) {
            if (p.test(v)) return false;
        }
        return true;
    }

    private static final char[][] HEX_PAIRS = new char[256][2];

    static {
        for (int i = 0; i < 256; i++) {
            HEX_PAIRS[i][0] = "0123456789ABCDEF".charAt(i >>> 4);
            HEX_PAIRS[i][1] = "0123456789ABCDEF".charAt(i & 0x0F);
        }
    }

    public static char[] toHexChars(byte[] bytes) {
        char[] out = new char[bytes.length * 2];
        int j = 0;
        for (byte b : bytes) {
            char[] pair = HEX_PAIRS[b & 0xFF];
            out[j++] = pair[0];
            out[j++] = pair[1];
        }
        return out;
    }

    public static <T> void forAllPairs(T[] arr, BiConsumer<T, T> func) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                func.accept(arr[i], arr[j]);
            }
        }
    }

    public static <T> void window(T[] arr, boolean looped, BiConsumer<T, T> func) {
        for (int i = 0; i < arr.length - 1; i++) {
            func.accept(arr[i], arr[i + 1]);
        }
        if (looped) func.accept(arr[arr.length - 1], arr[0]);
    }

    public static int[] strToI(String[] strs) {
        int[] result = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            result[i] = Integer.parseInt(strs[i]);
        }
        return result;
    }

    public static long[] strToL(String[] strs) {
        long[] result = new long[strs.length];
        for (int i = 0; i < strs.length; i++) {
            result[i] = Long.parseLong(strs[i]);
        }
        return result;
    }

    public static String toCompactStr(boolean[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (boolean b : arr) {
            sb.append(b ? 'T' : 'F');
            sb.append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public static <T> T[] map(long[] array, Mapper.LongTo<T> mapper) {
        Object[] result = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = mapper.map(array[i]);
        }
        return (T[]) result;
    }

    public static <T> T[] map(int[] array, Mapper.IntTo<T> mapper) {
        Object[] result = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = mapper.map(array[i]);
        }
        return (T[]) result;
    }

    public static <T> T[] map(short[] array, Mapper.ShortTo<T> mapper) {
        Object[] result = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = mapper.map(array[i]);
        }
        return (T[]) result;
    }

    public static <T> T[] map(char[] array, Mapper.CharTo<T> mapper) {
        Object[] result = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = mapper.map(array[i]);
        }
        return (T[]) result;
    }

    public static <T> T[] map(byte[] array, Mapper.ByteTo<T> mapper) {
        Object[] result = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = mapper.map(array[i]);
        }
        return (T[]) result;
    }

    public static <T> T[] map(boolean[] array, Mapper.BoolTo<T> mapper) {
        Object[] result = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = mapper.map(array[i]);
        }
        return (T[]) result;
    }

    public static <T> T[] map(float[] array, Mapper.FloatTo<T> mapper) {
        Object[] result = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = mapper.map(array[i]);
        }
        return (T[]) result;
    }

    public static <T> T[] map(double[] array, Mapper.DoubleTo<T> mapper) {
        Object[] result = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = mapper.map(array[i]);
        }
        return (T[]) result;
    }

    public static <T> T[] init(T[] array, java.util.function.Supplier<T> init) {
        for (int i = 0; i < array.length; i++) {
            array[i] = init.get();
        }
        return array;
    }

    public static int[] init(int[] array, Supplier.Int sup) {
        for (int i = 0; i < array.length; i++) {
            array[i] = sup.get();
        }
        return array;
    }

    public static short[] init(short[] array, Supplier.Short sup) {
        for (int i = 0; i < array.length; i++) {
            array[i] = sup.get();
        }
        return array;
    }

    public static char[] init(char[] array, Supplier.Char sup) {
        for (int i = 0; i < array.length; i++) {
            array[i] = sup.get();
        }
        return array;
    }

    public static byte[] init(byte[] array, Supplier.Byte sup) {
        for (int i = 0; i < array.length; i++) {
            array[i] = sup.get();
        }
        return array;
    }

    public static boolean[] init(boolean[] array, Supplier.Bool sup) {
        for (int i = 0; i < array.length; i++) {
            array[i] = sup.get();
        }
        return array;
    }

    public static float[] init(float[] array, Supplier.Long sup) {
        for (int i = 0; i < array.length; i++) {
            array[i] = sup.get();
        }
        return array;
    }

    public static double[] init(double[] array, Supplier.Long sup) {
        for (int i = 0; i < array.length; i++) {
            array[i] = sup.get();
        }
        return array;
    }

    public static int gcd(int[] array) {
        int result = gcd(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            result = gcd(result, array[i]);
        }
        return result;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    public static long count(long[] array, int end, Predicate.Long p) {
        long c = 0;
        for (int i = 0; i < end; i++) {
            c += p.test(array[i]) ? 1 : 0;
        }
        return c;
    }

    public static long count(int[] array, int end, Predicate.Int p) {
        long c = 0;
        for (int i = 0; i < end; i++) {
            c += p.test(array[i]) ? 1 : 0;
        }
        return c;
    }

    public static long count(short[] array, int end, Predicate.Short p) {
        long c = 0;
        for (int i = 0; i < end; i++) {
            c += p.test(array[i]) ? 1 : 0;
        }
        return c;
    }

    public static long count(byte[] array, int end, Predicate.Byte p) {
        long c = 0;
        for (int i = 0; i < end; i++) {
            c += p.test(array[i]) ? 1 : 0;
        }
        return c;
    }

    public static long count(char[] array, int end, Predicate.Char p) {
        long c = 0;
        for (int i = 0; i < end; i++) {
            c += p.test(array[i]) ? 1 : 0;
        }
        return c;
    }

    public static long count(float[] array, int end, Predicate.Float p) {
        long c = 0;
        for (int i = 0; i < end; i++) {
            c += p.test(array[i]) ? 1 : 0;
        }
        return c;
    }

    public static long count(double[] array, int end, Predicate.Double p) {
        long c = 0;
        for (int i = 0; i < end; i++) {
            c += p.test(array[i]) ? 1 : 0;
        }
        return c;
    }

    public static long count(boolean[] array, int end, Predicate.Boolean p) {
        long c = 0;
        for (int i = 0; i < end; i++) {
            c += p.test(array[i]) ? 1 : 0;
        }
        return c;
    }

    public static <T> long count(T[] array, int end, java.util.function.Predicate<T> p) {
        long c = 0;
        for (int i = 0; i < end; i++) {
            c += p.test(array[i]) ? 1 : 0;
        }
        return c;
    }

    public static long[] subArray(long[] array, int start, int len) {
        long[] arr = new long[len];
        System.arraycopy(array, start, arr, 0, len);
        return arr;
    }

    public static int[] subArray(int[] array, int start, int len) {
        int[] arr = new int[len];
        System.arraycopy(array, start, arr, 0, len);
        return arr;
    }

    public static byte[] subArray(byte[] array, int start, int len) {
        byte[] arr = new byte[len];
        System.arraycopy(array, start, arr, 0, len);
        return arr;
    }

    public static char[] subArray(char[] array, int start, int len) {
        char[] arr = new char[len];
        System.arraycopy(array, start, arr, 0, len);
        return arr;
    }

    public static float[] subArray(float[] array, int start, int len) {
        float[] arr = new float[len];
        System.arraycopy(array, start, arr, 0, len);
        return arr;
    }

    public static double[] subArray(double[] array, int start, int len) {
        double[] arr = new double[len];
        System.arraycopy(array, start, arr, 0, len);
        return arr;
    }

    public static String toString(Object[] arr, String sep, int start, int len, Function<Object, Object> mapper) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < len - 1; i++) {
            sb.append(mapper.apply(arr[i])).append(sep);
        }
        sb.append(mapper.apply(arr[len - 1])).append("]");
        return sb.toString();
    }

    public static String toString(byte[] array, String sep, int start, int len, Mapper.ByteTo<String> mapper) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = start; i < len - 1; i++) {
            sb.append(mapper.map(array[i])).append(sep);
        }
        sb.append(mapper.map(array[len - 1])).append("]");
        return sb.toString();
    }

    public static String toString(int[] array, String sep, int start, int len, Mapper.IntTo<String> mapper) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = start; i < len - 1; i++) {
            sb.append(mapper.map(array[i])).append(sep);
        }
        sb.append(mapper.map(array[len - 1])).append("]");
        return sb.toString();
    }

    public static String toString(long[] array, String sep, int start, int len, Mapper.LongTo<String> mapper) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = start; i < len - 1; i++) {
            sb.append(mapper.map(array[i])).append(sep);
        }
        sb.append(mapper.map(array[len - 1])).append("]");
        return sb.toString();
    }

    public static String toString(char[] array, String sep, int start, int len, Mapper.CharTo<String> mapper) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = start; i < len - 1; i++) {
            sb.append(mapper.map(array[i])).append(sep);
        }
        sb.append(mapper.map(array[len - 1])).append("]");
        return sb.toString();
    }

    public static String toString(short[] array, String sep, int start, int len, Mapper.ShortTo<String> mapper) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = start; i < len - 1; i++) {
            sb.append(mapper.map(array[i])).append(sep);
        }
        sb.append(mapper.map(array[len - 1])).append("]");
        return sb.toString();
    }

    public static String toString(float[] array, String sep, int start, int len, Mapper.FloatTo<String> mapper) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = start; i < len - 1; i++) {
            sb.append(mapper.map(array[i])).append(sep);
        }
        sb.append(mapper.map(array[len - 1])).append("]");
        return sb.toString();
    }

    public static String toString(double[] array, String sep, int start, int len, Mapper.DoubleTo<String> mapper) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = start; i < len - 1; i++) {
            sb.append(mapper.map(array[i])).append(sep);
        }
        sb.append(mapper.map(array[len - 1])).append("]");
        return sb.toString();
    }

    public static String toString(boolean[] array, String sep, int start, int len, Mapper.BoolTo<String> mapper) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = start; i < len - 1; i++) {
            sb.append(mapper.map(array[i])).append(sep);
        }
        sb.append(mapper.map(array[len - 1])).append("]");
        return sb.toString();
    }

    public static long[] expand(long[] start, int power) {
        long[] temp = new long[start.length << power];
        System.arraycopy(start, 0, temp, 0, start.length);
        return temp;
    }

    public static byte[] expand(byte[] start, int power) {
        byte[] temp = new byte[start.length << power];
        System.arraycopy(start, 0, temp, 0, start.length);
        return temp;
    }

    public static int[] expand(int[] start, int power) {
        int[] temp = new int[start.length << power];
        System.arraycopy(start, 0, temp, 0, start.length);
        return temp;
    }

    public static char[] expand(char[] start, int power) {
        char[] temp = new char[start.length << power];
        System.arraycopy(start, 0, temp, 0, start.length);
        return temp;
    }

    public static void move(char[] array, int i1, int i2) {
        var saved = array[i1];
        if (i2 > i1) {
            for (int i = i1; i < i2; i++) {
                array[i] = array[i + 1];
            }
        } else {
            for (int i = i1; i > i2; i--) {
                array[i] = array[i - 1];
            }
        }
        array[i2] = saved;
    }

    public static boolean removeAt(long[] array, int limit, int i, long tombStone) {
        if (i == -1) return false;
        for (int j = i + 1; j < limit; j++) {
            array[j - 1] = array[j];
        }
        array[limit - 1] = tombStone;
        return true;
    }

    public static boolean removeAt(int[] array, int limit, int i, int tombStone) {
        for (int j = i + 1; j < limit; j++) {
            array[j - 1] = array[j];
        }
        array[limit - 1] = tombStone;
        return true;
    }

    public static boolean removeAt(short[] array, int limit, int i, short tombStone) {
        if (i == -1) return false;
        for (int j = i + 1; j < limit; j++) {
            array[j - 1] = array[j];
        }
        array[limit - 1] = tombStone;
        return true;
    }

    public static boolean removeAt(byte[] array, int limit, int i, byte tombStone) {
        for (int j = i + 1; j < limit; j++) {
            array[j - 1] = array[j];
        }
        array[limit - 1] = tombStone;
        return true;
    }

    public static boolean removeAt(float[] array, int limit, int i, float tombStone) {
        for (int j = i + 1; j < limit; j++) {
            array[j - 1] = array[j];
        }
        array[limit - 1] = tombStone;
        return true;
    }

    public static boolean removeAt(double[] array, int limit, int i, float tombStone) {
        for (int j = i + 1; j < limit; j++) {
            array[j - 1] = array[j];
        }
        array[limit - 1] = tombStone;
        return true;
    }

    public static boolean removeAt(boolean[] array, int limit, int i, boolean tombStone) {
        for (int j = i + 1; j < limit; j++) {
            array[j - 1] = array[j];
        }
        array[limit - 1] = tombStone;
        return true;
    }

    public static <T> boolean removeAt(T[] array, int limit, int i, T tombStone) {
        for (int j = i + 1; j < limit; j++) {
            array[j - 1] = array[j];
        }
        array[limit - 1] = tombStone;
        return true;
    }

    //
    public static boolean remove(long[] array, int limit, long element, long tombStone) {
        int i = ArrUtils.indexOf(array, limit, element);
        if (i == -1) return false;
        for (int j = i + 1; j < limit; j++) {
            array[j - 1] = array[j];
        }
        array[limit - 1] = tombStone;
        return true;
    }

    public static boolean remove(int[] array, int limit, int element, int tombStone) {
        int i = ArrUtils.indexOf(array, limit, element);
        if (i == -1) return false;
        for (int j = i + 1; j < limit; j++) {
            array[j - 1] = array[j];
        }
        array[limit - 1] = tombStone;
        return true;
    }

    public static boolean remove(short[] array, int limit, short element, short tombStone) {
        int i = ArrUtils.indexOf(array, limit, element);
        if (i == -1) return false;
        for (int j = i + 1; j < limit; j++) {
            array[j - 1] = array[j];
        }
        array[limit - 1] = tombStone;
        return true;
    }

    public static boolean remove(byte[] array, int limit, byte element, byte tombStone) {
        int i = ArrUtils.indexOf(array, limit, element);
        if (i == -1) return false;
        for (int j = i + 1; j < limit; j++) {
            array[j - 1] = array[j];
        }
        array[limit - 1] = tombStone;
        return true;
    }

    public static boolean remove(float[] array, int limit, float element, float tombStone) {
        int i = ArrUtils.indexOf(array, limit, element);
        if (i == -1) return false;
        for (int j = i + 1; j < limit; j++) {
            array[j - 1] = array[j];
        }
        array[limit - 1] = tombStone;
        return true;
    }

    public static boolean remove(double[] array, int limit, double element, double tombStone) {
        int i = ArrUtils.indexOf(array, limit, element);
        if (i == -1) return false;
        for (int j = i + 1; j < limit; j++) {
            array[j - 1] = array[j];
        }
        array[limit - 1] = tombStone;
        return true;
    }

    public static boolean remove(boolean[] array, int limit, boolean element, boolean tombStone) {
        int i = ArrUtils.indexOf(array, limit, element);
        if (i == -1) return false;
        for (int j = i + 1; j < limit; j++) {
            array[j - 1] = array[j];
        }
        array[limit - 1] = tombStone;
        return true;
    }

    public static <T> boolean remove(T[] array, int limit, boolean element, T tombStone) {
        int i = ArrUtils.indexOf(array, limit, element);
        if (i == -1) return false;
        for (int j = i + 1; j < limit; j++) {
            array[j - 1] = array[j];
        }
        array[limit - 1] = tombStone;
        return true;
    }

    public static void swap(long[] array, int idx1, int idx2) {
        var temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    public static void swap(int[] array, int idx1, int idx2) {
        var temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    public static void swap(short[] array, int idx1, int idx2) {
        var temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    public static void swap(char[] array, int idx1, int idx2) {
        var temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    public static void swap(boolean[] array, int idx1, int idx2) {
        var temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }


    public static void swap(byte[] array, int idx1, int idx2) {
        var temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    public static void swap(float[] array, int idx1, int idx2) {
        var temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    public static void swap(double[] array, int idx1, int idx2) {
        var temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    public static <T> void swap(T[] array, int idx1, int idx2) {
        var temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    public static <T> void rotate(T[] array, int amount) {
        amount %= array.length;
        reverse(array, 0, array.length - 1);
        reverse(array, 0, amount - 1);
        reverse(array, amount, array.length - 1);
    }

    public static void rotate(long[] array, int amount) {
        amount %= array.length;
        reverse(array, 0, array.length - 1);
        reverse(array, 0, amount - 1);
        reverse(array, amount, array.length - 1);
    }

    public static void rotate(int[] array, int amount) {
        amount %= array.length;
        reverse(array, 0, array.length - 1);
        reverse(array, 0, amount - 1);
        reverse(array, amount, array.length - 1);
    }

    public static void rotate(short[] array, int amount) {
        amount %= array.length;
        reverse(array, 0, array.length - 1);
        reverse(array, 0, amount - 1);
        reverse(array, amount, array.length - 1);
    }


    public static void rotate(byte[] array, int amount) {
        amount %= array.length;
        reverse(array, 0, array.length - 1);
        reverse(array, 0, amount - 1);
        reverse(array, amount, array.length - 1);
    }


    public static void rotate(char[] array, int amount) {
        amount %= array.length;
        reverse(array, 0, array.length - 1);
        reverse(array, 0, amount - 1);
        reverse(array, amount, array.length - 1);
    }

    public static void rotate(boolean[] array, int amount) {
        amount %= array.length;
        reverse(array, 0, array.length - 1);
        reverse(array, 0, amount - 1);
        reverse(array, amount, array.length - 1);
    }


    public static void rotate(float[] array, int amount) {
        amount %= array.length;
        reverse(array, 0, array.length - 1);
        reverse(array, 0, amount - 1);
        reverse(array, amount, array.length - 1);
    }

    public static void rotate(double[] array, int amount) {
        amount %= array.length;
        reverse(array, 0, array.length - 1);
        reverse(array, 0, amount - 1);
        reverse(array, amount, array.length - 1);
    }

    public static void reverse(long[] array, int start, int end) {
        while (start < end) {
            swap(array, start++, end--);
        }
    }

    public static void reverse(int[] array, int start, int end) {
        while (start < end) {
            swap(array, start++, end--);
        }
    }


    public static void reverse(short[] array, int start, int end) {
        while (start < end) {
            swap(array, start++, end--);
        }
    }

    public static void reverse(char[] array, int start, int end) {
        while (start < end) {
            swap(array, start++, end--);
        }
    }

    public static void reverse(byte[] array, int start, int end) {
        while (start < end) {
            swap(array, start++, end--);
        }
    }

    public static void reverse(float[] array, int start, int end) {
        while (start < end) {
            swap(array, start++, end--);
        }
    }

    public static void reverse(double[] array, int start, int end) {
        while (start < end) {
            swap(array, start++, end--);
        }
    }

    public static void reverse(boolean[] array, int start, int end) {
        while (start < end) {
            swap(array, start++, end--);
        }
    }

    public static <T> void reverse(T[] array, int start, int end) {
        while (start < end) {
            swap(array, start++, end--);
        }
    }
}
