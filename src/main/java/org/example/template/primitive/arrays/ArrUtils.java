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

    public static <T> double sumBy(T[] array, Pmapper.ObjToDoubleIndexed<T> mapper) {
        return ArrUtils.sumBy(array, array.length, mapper);
    }

    public static <T> long sumBy(T[] array, Pmapper.ObjToLongIndexed<T> mapper) {
        return ArrUtils.sumBy(array, array.length, mapper);
    }

    public static long sumBy(long[] array, Pmapper.LongIndexed mapper) {
        return ArrUtils.sumBy(array, array.length, mapper);
    }

    public static long sumBy(int[] array, Pmapper.IntIndexed mapper) {
        return ArrUtils.sumBy(array, array.length, mapper);
    }

    public static long sumBy(char[] array, Pmapper.CharToIntIndexed mapper) {
        return ArrUtils.sumBy(array, array.length, mapper);
    }

    public static long sumBy(short[] array, Pmapper.ShortIndexed mapper) {
        return ArrUtils.sumBy(array, array.length, mapper);
    }

    public static long sumBy(byte[] array, Pmapper.ByteIndexed mapper) {
        return ArrUtils.sumBy(array, array.length, mapper);
    }

    public static double sumBy(float[] array, Pmapper.FloatIndexed mapper) {
        return ArrUtils.sumBy(array, array.length, mapper);
    }

    public static double sumBy(double[] array, Pmapper.DoubleIndexed mapper) {
        return ArrUtils.sumBy(array, array.length, mapper);
    }

    private static <T> long sumBy(T[] array, int end, Pmapper.ObjToLongIndexed<T> mapper) {
        long sum = 0;
        for (var i = 0; i < end; i++) {
            sum += mapper.map(array[i], i);
        }
        return sum;
    }

    private static <T> double sumBy(T[] array, int end, Pmapper.ObjToDoubleIndexed<T> mapper) {
        double sum = 0;
        for (var i = 0; i < end; i++) {
            sum += mapper.map(array[i], i);
        }
        return sum;
    }

    public static long sumBy(long[] array, int end, Pmapper.LongIndexed mapper) {
        long sum = 0;
        for (var i = 0; i < end; i++) {
            sum += mapper.map(array[i], i);
        }
        return sum;
    }

    public static long sumBy(int[] array, int end, Pmapper.IntIndexed mapper) {
        long sum = 0;
        for (var i = 0; i < end; i++) {
            sum += mapper.map(array[i], i);
        }
        return sum;
    }

    public static long sumBy(short[] array, int end, Pmapper.ShortIndexed mapper) {
        long sum = 0;
        for (var i = 0; i < end; i++) {
            sum += mapper.map(array[i], i);
        }
        return sum;
    }

    public static long sumBy(byte[] array, int end, Pmapper.ByteIndexed mapper) {
        long sum = 0;
        for (var i = 0; i < end; i++) {
            sum += mapper.map(array[i], i);
        }
        return sum;
    }

    public static long sumBy(boolean[] array, int end, Pmapper.BoolToIntIndexed mapper) {
        long sum = 0;
        for (var i = 0; i < end; i++) {
            sum += mapper.map(array[i], i);
        }
        return sum;
    }

    public static long sumBy(char[] array, int end, Pmapper.CharToIntIndexed mapper) {
        long sum = 0;
        for (var i = 0; i < array.length; i++) {
            sum += mapper.map(array[i], i);
        }
        return sum;
    }

    public static double sumBy(float[] array, int end, Pmapper.FloatIndexed mapper) {
        double sum = 0;
        for (var i = 0; i < array.length; i++) {
            sum += mapper.map(array[i], i);
        }
        return sum;
    }

    public static double sumBy(double[] array, int end, Pmapper.DoubleIndexed mapper) {
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

    public static void forEach(long[] array, Pconsumer.Long c, int start, int end, int step) {
        for (int i = start; i < end; i += step) {
            c.accept(array[i]);
        }
    }

    public static void forEach(int[] array, Pconsumer.Int c, int start, int end, int step) {
        for (int i = start; i < end; i += step) {
            c.accept(array[i]);
        }
    }

    public static void forEach(short[] array, Pconsumer.Short c, int start, int end, int step) {
        for (int i = start; i < end; i += step) {
            c.accept(array[i]);
        }
    }

    public static void forEach(byte[] array, Pconsumer.Byte c, int start, int end, int step) {
        for (int i = start; i < end; i += step) {
            c.accept(array[i]);
        }
    }

    public static void forEach(char[] array, Pconsumer.Char c, int start, int end, int step) {
        for (int i = start; i < end; i += step) {
            c.accept(array[i]);
        }
    }

    public static void forEach(boolean[] array, Pconsumer.Bool c, int start, int end, int step) {
        for (int i = start; i < end; i += step) {
            c.accept(array[i]);
        }
    }

    public static void forEach(float[] array, Pconsumer.Float c, int start, int end, int step) {
        for (int i = start; i < end; i += step) {
            c.accept(array[i]);
        }
    }

    public static void forEach(double[] array, Pconsumer.Double c, int start, int end, int step) {
        for (int i = start; i < end; i += step) {
            c.accept(array[i]);
        }
    }

    public static void forEach(long[] array, Pconsumer.Long c) {
        for (long l : array) {
            c.accept(l);
        }
    }

    public static void forEach(int[] array, Pconsumer.Int c) {
        for (int j : array) {
            c.accept(j);
        }
    }

    public static void forEach(short[] array, Pconsumer.Short c) {
        for (short value : array) {
            c.accept(value);
        }
    }

    public static void forEach(byte[] array, Pconsumer.Byte c) {
        for (byte b : array) {
            c.accept(b);
        }
    }

    public static void forEach(char[] array, Pconsumer.Char c) {
        for (char value : array) {
            c.accept(value);
        }
    }

    public static void forEach(boolean[] array, Pconsumer.Bool c) {
        for (boolean b : array) {
            c.accept(b);
        }
    }

    public static void forEach(float[] array, Pconsumer.Float c) {
        for (float v : array) {
            c.accept(v);
        }
    }

    public static void forEach(double[] array, Pconsumer.Double c) {
        for (double v : array) {
            c.accept(v);
        }
    }


    public static void forEachIndexed(long[] array, Pconsumer.LongIndexed c) {
        for (int i = 0; i < array.length; i++) {
            c.accept(array[i], i);
        }
    }

    public static void forEachIndexed(int[] array, Pconsumer.IntIndexed c) {
        for (int i = 0; i < array.length; i++) {
            c.accept(array[i], i);
        }
    }

    public static void forEachIndexed(short[] array, Pconsumer.ShortIndexed c) {
        for (int i = 0; i < array.length; i++) {
            c.accept(array[i], i);
        }
    }

    public static void forEachIndexed(byte[] array, Pconsumer.ByteIndexed c) {
        for (int i = 0; i < array.length; i++) {
            c.accept(array[i], i);
        }
    }

    public static void forEachIndexed(char[] array, Pconsumer.CharIndexed c) {
        for (int i = 0; i < array.length; i++) {
            c.accept(array[i], i);
        }
    }

    public static void forEachIndexed(boolean[] array, Pconsumer.BoolIndexed c) {
        for (int i = 0; i < array.length; i++) {
            c.accept(array[i], i);
        }
    }

    public static void forEachIndexed(float[] array, Pconsumer.FloatIndexed c) {
        for (int i = 0; i < array.length; i++) {
            c.accept(array[i], i);
        }
    }

    public static void forEachIndexed(double[] array, Pconsumer.DoubleIndexed c) {
        for (int i = 0; i < array.length; i++) {
            c.accept(array[i], i);
        }
    }

    /**
     * Maps an element to another value in place in the array.
     */
    public static void mapInPlace(long[] array, int limit, Pmapper.Long m) {
        for (int i = 0; i < limit; i++) {
            array[i] = m.map(array[i]);
        }
    }

    /**
     * Maps an element to another value in place in the array.
     */
    public static void mapInPlace(int[] array, int limit, Pmapper.Int m) {
        for (int i = 0; i < limit; i++) {
            array[i] = m.map(array[i]);
        }
    }

    /**
     * Maps an element to another value in place in the array.
     */
    public static void mapInPlace(short[] array, int limit, Pmapper.Short m) {
        for (int i = 0; i < limit; i++) {
            array[i] = m.map(array[i]);
        }
    }

    /**
     * Maps an element to another value in place in the array.
     */
    public static void mapInPlace(byte[] array, int limit, Pmapper.Byte m) {
        for (int i = 0; i < limit; i++) {
            array[i] = m.map(array[i]);
        }
    }

    /**
     * Maps an element to another value in place in the array.
     */
    public static void mapInPlace(char[] array, int limit, Pmapper.Char m) {
        for (int i = 0; i < limit; i++) {
            array[i] = m.map(array[i]);
        }
    }

    /**
     * Maps an element to another value in place in the array.
     */
    public static void mapInPlace(boolean[] array, int limit, Pmapper.Bool m) {
        for (int i = 0; i < limit; i++) {
            array[i] = m.map(array[i]);
        }
    }

    /**
     * Maps an element to another value in place in the array.
     */
    public static void mapInPlace(float[] array, int limit, Pmapper.Float m) {
        for (int i = 0; i < limit; i++) {
            array[i] = m.map(array[i]);
        }
    }

    /**
     * Maps an element to another value in place in the array.
     */
    public static void mapInPlace(double[] array, int limit, Pmapper.Double m) {
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
    public static int first(long[] array, Ppredicate.Long p) {
        for (int i = 0; i < array.length; i++) {
            if (p.test(array[i])) return i;
        }
        return -1;
    }

    /**
     * @return the first index of array matching the predicate, -1 otherwise
     */
    public static int first(int[] array, Ppredicate.Int p) {
        for (int i = 0; i < array.length; i++) {
            if (p.test(array[i])) return i;
        }
        return -1;
    }


    /**
     * @return the first index of array matching the predicate, -1 otherwise
     */
    public static int first(short[] array, Ppredicate.Short p) {
        for (int i = 0; i < array.length; i++) {
            if (p.test(array[i])) return i;
        }
        return -1;
    }

    /**
     * @return the first index of array matching the predicate, -1 otherwise
     */
    public static int first(char[] array, Ppredicate.Char p) {
        for (int i = 0; i < array.length; i++) {
            if (p.test(array[i])) return i;
        }
        return -1;
    }

    /**
     * @return the first index of array matching the predicate, -1 otherwise
     */
    public static int first(byte[] array, Ppredicate.Byte p) {
        for (int i = 0; i < array.length; i++) {
            if (p.test(array[i])) return i;
        }
        return -1;
    }

    /**
     * @return the first index of array matching the predicate, -1 otherwise
     */
    public static int first(boolean[] array, Ppredicate.Boolean p) {
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

    public static long maxBy(long[] array, int start, int end, Pcomparator.Long c) {
        long m = 0;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) > 0) m = array[i];
        }
        return m;
    }

    public static int maxBy(int[] array, int start, int end, Pcomparator.Int c) {
        int m = 0;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) > 0) m = array[i];
        }
        return m;
    }

    public static short maxBy(short[] array, int start, int end, Pcomparator.Short c) {
        short m = 0;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) > 0) m = array[i];
        }
        return m;
    }

    public static char maxBy(char[] array, int start, int end, Pcomparator.Char c) {
        char m = 0;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) > 0) m = array[i];
        }
        return m;
    }

    public static byte maxBy(byte[] array, int start, int end, Pcomparator.Byte c) {
        byte m = 0;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) > 0) m = array[i];
        }
        return m;
    }

    public static float maxBy(float[] array, int start, int end, Pcomparator.Float c) {
        float m = 0;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) > 0) m = array[i];
        }
        return m;
    }

    public static double maxBy(double[] array, int start, int end, Pcomparator.Double c) {
        double m = 0;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) > 0) m = array[i];
        }
        return m;
    }

    public static long minBy(long[] array, int start, int end, Pcomparator.Long c) {
        long m = Long.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) < 0) m = array[i];
        }
        return m;
    }

    public static int minBy(int[] array, int start, int end, Pcomparator.Int c) {
        int m = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) < 0) m = array[i];
        }
        return m;
    }

    public static short minBy(short[] array, int start, int end, Pcomparator.Short c) {
        short m = Short.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) < 0) m = array[i];
        }
        return m;
    }

    public static char minBy(char[] array, int start, int end, Pcomparator.Char c) {
        char m = Character.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) < 0) m = array[i];
        }
        return m;
    }

    public static byte minBy(byte[] array, int start, int end, Pcomparator.Byte c) {
        byte m = Byte.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) < 0) m = array[i];
        }
        return m;
    }

    public static float minBy(float[] array, int start, int end, Pcomparator.Float c) {
        float m = Float.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) < 0) m = array[i];
        }
        return m;
    }

    public static double minBy(double[] array, int start, int end, Pcomparator.Double c) {
        double m = Double.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (c.compare(array[i], m) < 0) m = array[i];
        }
        return m;
    }

    public static boolean windowMatch(long[] array, int start, int length, Ppredicate.Long p) {
        for (int i = start; i < start + length; i++) {
            if (!p.test(array[i])) return false;
        }
        return true;
    }

    public static boolean windowMatch(int[] array, int start, int length, Ppredicate.Int p) {
        for (int i = start; i < start + length; i++) {
            if (!p.test(array[i])) return false;
        }
        return true;
    }

    public static boolean windowMatch(short[] array, int start, int length, Ppredicate.Short p) {
        for (int i = start; i < start + length; i++) {
            if (!p.test(array[i])) return false;
        }
        return true;
    }

    public static boolean windowMatch(char[] array, int start, int length, Ppredicate.Char p) {
        for (int i = start; i < start + length; i++) {
            if (!p.test(array[i])) return false;
        }
        return true;
    }

    public static boolean windowMatch(byte[] array, int start, int length, Ppredicate.Byte p) {
        for (int i = start; i < start + length; i++) {
            if (!p.test(array[i])) return false;
        }
        return true;
    }

    public static boolean windowMatch(boolean[] array, int start, int length, Ppredicate.Boolean p) {
        for (int i = start; i < start + length; i++) {
            if (!p.test(array[i])) return false;
        }
        return true;
    }

    public static boolean windowMatch(float[] array, int start, int length, Ppredicate.Float p) {
        for (int i = start; i < start + length; i++) {
            if (!p.test(array[i])) return false;
        }
        return true;
    }

    public static boolean windowMatch(double[] array, int start, int length, Ppredicate.Double p) {
        for (int i = start; i < start + length; i++) {
            if (!p.test(array[i])) return false;
        }
        return true;
    }

    public static boolean any(long[] array, Ppredicate.LongIndexed pi) {
        for (int i = 0; i < array.length; i++) {
            if (pi.test(array[i], i)) return true;
        }
        return false;
    }

    public static boolean any(int[] array, Ppredicate.IntIndexed pi) {
        for (int i = 0; i < array.length; i++) {
            if (pi.test(array[i], i)) return true;
        }
        return false;
    }

    public static boolean any(short[] array, Ppredicate.ShortIndexed pi) {
        for (int i = 0; i < array.length; i++) {
            if (pi.test(array[i], i)) return true;
        }
        return false;
    }

    public static boolean any(byte[] array, Ppredicate.ByteIndexed pi) {
        for (int i = 0; i < array.length; i++) {
            if (pi.test(array[i], i)) return true;
        }
        return false;
    }

    public static boolean any(char[] array, Ppredicate.CharIndexed pi) {
        for (int i = 0; i < array.length; i++) {
            if (pi.test(array[i], i)) return true;
        }
        return false;
    }

    public static boolean any(boolean[] array, Ppredicate.BooleanIndexed pi) {
        for (int i = 0; i < array.length; i++) {
            if (pi.test(array[i], i)) return true;
        }
        return false;
    }

    public static boolean any(float[] array, Ppredicate.FloatIndexed pi) {
        for (int i = 0; i < array.length; i++) {
            if (pi.test(array[i], i)) return true;
        }
        return false;
    }

    public static boolean any(double[] array, Ppredicate.DoubleIndexed pi) {
        for (int i = 0; i < array.length; i++) {
            if (pi.test(array[i], i)) return true;
        }
        return false;
    }

    public static boolean any(long[] array, Ppredicate.Long p) {
        for (long l : array) {
            if (p.test(l)) return true;
        }
        return false;
    }

    public static boolean any(int[] array, Ppredicate.Int p) {
        for (int j : array) {
            if (p.test(j)) return true;
        }
        return false;
    }

    public static boolean any(short[] array, Ppredicate.Short p) {
        for (short value : array) {
            if (p.test(value)) return true;
        }
        return false;
    }

    public static boolean any(byte[] array, Ppredicate.Byte p) {
        for (byte b : array) {
            if (p.test(b)) return true;
        }
        return false;
    }

    public static boolean any(char[] array, Ppredicate.Char p) {
        for (char c : array) {
            if (p.test(c)) return true;
        }
        return false;
    }

    public static boolean any(boolean[] array, Ppredicate.Boolean p) {
        for (boolean b : array) {
            if (p.test(b)) return true;
        }
        return false;
    }

    public static boolean any(float[] array, Ppredicate.Float p) {
        for (float v : array) {
            if (p.test(v)) return true;
        }
        return false;
    }

    public static boolean any(double[] array, Ppredicate.Double p) {
        for (double v : array) {
            if (p.test(v)) return true;
        }
        return false;
    }

    public static boolean none(long[] array, Ppredicate.Long p) {
        for (long l : array) {
            if (p.test(l)) return false;
        }
        return true;
    }

    public static boolean none(int[] array, Ppredicate.Int p) {
        for (int j : array) {
            if (p.test(j)) return false;
        }
        return true;
    }

    public static boolean none(short[] array, Ppredicate.Short p) {
        for (short value : array) {
            if (p.test(value)) return false;
        }
        return true;
    }

    public static boolean none(byte[] array, Ppredicate.Byte p) {
        for (byte b : array) {
            if (p.test(b)) return false;
        }
        return true;
    }

    public static boolean none(char[] array, Ppredicate.Char p) {
        for (char c : array) {
            if (p.test(c)) return false;
        }
        return true;
    }

    public static boolean none(boolean[] array, Ppredicate.Boolean p) {
        for (boolean b : array) {
            if (p.test(b)) return false;
        }
        return true;
    }

    public static boolean none(float[] array, Ppredicate.Float p) {
        for (float v : array) {
            if (p.test(v)) return false;
        }
        return true;
    }

    public static boolean none(double[] array, Ppredicate.Double p) {
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

    public static <T> T[] map(long[] array, Pmapper.LongTo<T> mapper) {
        Object[] result = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = mapper.map(array[i]);
        }
        return (T[]) result;
    }

    public static <T> T[] map(int[] array, Pmapper.IntTo<T> mapper) {
        Object[] result = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = mapper.map(array[i]);
        }
        return (T[]) result;
    }

    public static <T> T[] map(short[] array, Pmapper.ShortTo<T> mapper) {
        Object[] result = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = mapper.map(array[i]);
        }
        return (T[]) result;
    }

    public static <T> T[] map(char[] array, Pmapper.CharTo<T> mapper) {
        Object[] result = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = mapper.map(array[i]);
        }
        return (T[]) result;
    }

    public static <T> T[] map(byte[] array, Pmapper.ByteTo<T> mapper) {
        Object[] result = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = mapper.map(array[i]);
        }
        return (T[]) result;
    }

    public static <T> T[] map(boolean[] array, Pmapper.BoolTo<T> mapper) {
        Object[] result = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = mapper.map(array[i]);
        }
        return (T[]) result;
    }

    public static <T> T[] map(float[] array, Pmapper.FloatTo<T> mapper) {
        Object[] result = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = mapper.map(array[i]);
        }
        return (T[]) result;
    }

    public static <T> T[] map(double[] array, Pmapper.DoubleTo<T> mapper) {
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

    public static int[] init(int[] array, Psupplier.Int sup) {
        for (int i = 0; i < array.length; i++) {
            array[i] = sup.get();
        }
        return array;
    }

    public static short[] init(short[] array, Psupplier.Short sup) {
        for (int i = 0; i < array.length; i++) {
            array[i] = sup.get();
        }
        return array;
    }

    public static char[] init(char[] array, Psupplier.Char sup) {
        for (int i = 0; i < array.length; i++) {
            array[i] = sup.get();
        }
        return array;
    }

    public static byte[] init(byte[] array, Psupplier.Byte sup) {
        for (int i = 0; i < array.length; i++) {
            array[i] = sup.get();
        }
        return array;
    }

    public static boolean[] init(boolean[] array, Psupplier.Bool sup) {
        for (int i = 0; i < array.length; i++) {
            array[i] = sup.get();
        }
        return array;
    }

    public static float[] init(float[] array, Psupplier.Long sup) {
        for (int i = 0; i < array.length; i++) {
            array[i] = sup.get();
        }
        return array;
    }

    public static double[] init(double[] array, Psupplier.Long sup) {
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

    public static long count(long[] array, int end, Ppredicate.Long p) {
        long c = 0;
        for (int i = 0; i < end; i++) {
            c += p.test(array[i]) ? 1 : 0;
        }
        return c;
    }

    public static long count(int[] array, int end, Ppredicate.Int p) {
        long c = 0;
        for (int i = 0; i < end; i++) {
            c += p.test(array[i]) ? 1 : 0;
        }
        return c;
    }

    public static long count(short[] array, int end, Ppredicate.Short p) {
        long c = 0;
        for (int i = 0; i < end; i++) {
            c += p.test(array[i]) ? 1 : 0;
        }
        return c;
    }

    public static long count(byte[] array, int end, Ppredicate.Byte p) {
        long c = 0;
        for (int i = 0; i < end; i++) {
            c += p.test(array[i]) ? 1 : 0;
        }
        return c;
    }

    public static long count(char[] array, int end, Ppredicate.Char p) {
        long c = 0;
        for (int i = 0; i < end; i++) {
            c += p.test(array[i]) ? 1 : 0;
        }
        return c;
    }

    public static long count(float[] array, int end, Ppredicate.Float p) {
        long c = 0;
        for (int i = 0; i < end; i++) {
            c += p.test(array[i]) ? 1 : 0;
        }
        return c;
    }

    public static long count(double[] array, int end, Ppredicate.Double p) {
        long c = 0;
        for (int i = 0; i < end; i++) {
            c += p.test(array[i]) ? 1 : 0;
        }
        return c;
    }

    public static long count(boolean[] array, int end, Ppredicate.Boolean p) {
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

    public static String toString(byte[] array, String sep, int start, int len, Pmapper.ByteTo<String> mapper) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = start; i < len - 1; i++) {
            sb.append(mapper.map(array[i])).append(sep);
        }
        sb.append(mapper.map(array[len - 1])).append("]");
        return sb.toString();
    }

    public static String toString(int[] array, String sep, int start, int len, Pmapper.IntTo<String> mapper) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = start; i < len - 1; i++) {
            sb.append(mapper.map(array[i])).append(sep);
        }
        sb.append(mapper.map(array[len - 1])).append("]");
        return sb.toString();
    }

    public static String toString(long[] array, String sep, int start, int len, Pmapper.LongTo<String> mapper) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = start; i < len - 1; i++) {
            sb.append(mapper.map(array[i])).append(sep);
        }
        sb.append(mapper.map(array[len - 1])).append("]");
        return sb.toString();
    }

    public static String toString(char[] array, String sep, int start, int len, Pmapper.CharTo<String> mapper) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = start; i < len - 1; i++) {
            sb.append(mapper.map(array[i])).append(sep);
        }
        sb.append(mapper.map(array[len - 1])).append("]");
        return sb.toString();
    }

    public static String toString(short[] array, String sep, int start, int len, Pmapper.ShortTo<String> mapper) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = start; i < len - 1; i++) {
            sb.append(mapper.map(array[i])).append(sep);
        }
        sb.append(mapper.map(array[len - 1])).append("]");
        return sb.toString();
    }

    public static String toString(float[] array, String sep, int start, int len, Pmapper.FloatTo<String> mapper) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = start; i < len - 1; i++) {
            sb.append(mapper.map(array[i])).append(sep);
        }
        sb.append(mapper.map(array[len - 1])).append("]");
        return sb.toString();
    }

    public static String toString(double[] array, String sep, int start, int len, Pmapper.DoubleTo<String> mapper) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = start; i < len - 1; i++) {
            sb.append(mapper.map(array[i])).append(sep);
        }
        sb.append(mapper.map(array[len - 1])).append("]");
        return sb.toString();
    }

    public static String toString(boolean[] array, String sep, int start, int len, Pmapper.BoolTo<String> mapper) {
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

    /**
     * efficiently recurses on all possible permutations of the parameter array.
     */
    public static <T> void heapPermute(T[] array, java.util.function.Consumer<T[]> c) {
        heapPermute(array, array.length, c);
    }

    /**
     * efficiently recurses on all possible permutations of the parameter array.
     */
    public static void heapPermute(char[] array, java.util.function.Consumer<char[]> c) {
        heapPermute(array, array.length, c);
    }

    /**
     * efficiently recurses on all possible permutations of the parameter array.
     */
    public static void heapPermute(byte[] array, java.util.function.Consumer<byte[]> c) {
        heapPermute(array, array.length, c);
    }

    /**
     * efficiently recurses on all possible permutations of the parameter array.
     */
    public static void heapPermute(boolean[] array, java.util.function.Consumer<boolean[]> c) {
        heapPermute(array, array.length, c);
    }

    /**
     * efficiently recurses on all possible permutations of the parameter array.
     */
    public static void heapPermute(float[] array, java.util.function.Consumer<float[]> c) {
        heapPermute(array, array.length, c);
    }

    /**
     * efficiently recurses on all possible permutations of the parameter array.
     */
    public static void heapPermute(double[] array, java.util.function.Consumer<double[]> c) {
        heapPermute(array, array.length, c);
    }

    /**
     * efficiently recurses on all possible permutations of the parameter array.
     */
    public static void heapPermute(int[] array, java.util.function.Consumer<int[]> c) {
        heapPermute(array, array.length, c);
    }

    /**
     * efficiently recurses on all possible permutations of the parameter array.
     */
    public static void heapPermute(long[] array, java.util.function.Consumer<long[]> c) {
        heapPermute(array, array.length, c);
    }

    /**
     * efficiently recurses on all possible permutations of the parameter array.
     */
    public static void heapPermute(short[] array, java.util.function.Consumer<short[]> c) {
        heapPermute(array, array.length, c);
    }

    public static void heapPermute(char[] array, int index, java.util.function.Consumer<char[]> c) {
        if (index == 1) {
            c.accept(array);
            return;
        }
        heapPermute(array, index - 1, c);
        for (int i = 0; i < index - 1; i++) {
            if (index % 2 == 0) ArrUtils.swap(array, i, index - 1);
            else  ArrUtils.swap(array, 0, index - 1);
            heapPermute(array, index - 1, c);
        }
    }



    public static <T> void heapPermute(T[] array, int index, java.util.function.Consumer<T[]> c) {
        if (index == 1) {
            c.accept(array);
            return;
        }
        heapPermute(array, index - 1, c);
        for (int i = 0; i < index - 1; i++) {
            if (index % 2 == 0) ArrUtils.swap(array, i, index - 1);
            else  ArrUtils.swap(array, 0, index - 1);
            heapPermute(array, index - 1, c);
        }
    }


    public static void heapPermute(int[] array, int size, java.util.function.Consumer<int[]> consumer) {
        if (size == 1) {
            consumer.accept(array.clone());
            return;
        }
        for (int i = 0; i < size; i++) {
            heapPermute(array, size - 1, consumer);
            if (size % 2 == 0) {
                swap(array, i, size - 1);
            } else {
                swap(array, 0, size - 1);
            }
        }
    }

    // Heap's algorithm for long[]
    public static void heapPermute(long[] array, int size, java.util.function.Consumer<long[]> consumer) {
        if (size == 1) {
            consumer.accept(array.clone());
            return;
        }
        for (int i = 0; i < size; i++) {
            heapPermute(array, size - 1, consumer);
            if (size % 2 == 0) {
                swap(array, i, size - 1);
            } else {
                swap(array, 0, size - 1);
            }
        }
    }

    // Heap's algorithm for short[]
    public static void heapPermute(short[] array, int size, java.util.function.Consumer<short[]> consumer) {
        if (size == 1) {
            consumer.accept(array.clone());
            return;
        }
        for (int i = 0; i < size; i++) {
            heapPermute(array, size - 1, consumer);
            if (size % 2 == 0) {
                swap(array, i, size - 1);
            } else {
                swap(array, 0, size - 1);
            }
        }
    }

    // Heap's algorithm for byte[]
    public static void heapPermute(byte[] array, int size, java.util.function.Consumer<byte[]> consumer) {
        if (size == 1) {
            consumer.accept(array.clone());
            return;
        }
        for (int i = 0; i < size; i++) {
            heapPermute(array, size - 1, consumer);
            if (size % 2 == 0) {
                swap(array, i, size - 1);
            } else {
                swap(array, 0, size - 1);
            }
        }
    }

    // Heap's algorithm for float[]
    public static void heapPermute(float[] array, int size, java.util.function.Consumer<float[]> consumer) {
        if (size == 1) {
            consumer.accept(array.clone());
            return;
        }
        for (int i = 0; i < size; i++) {
            heapPermute(array, size - 1, consumer);
            if (size % 2 == 0) {
                swap(array, i, size - 1);
            } else {
                swap(array, 0, size - 1);
            }
        }
    }

    // Heap's algorithm for double[]
    public static void heapPermute(double[] array, int size, java.util.function.Consumer<double[]> consumer) {
        if (size == 1) {
            consumer.accept(array.clone());
            return;
        }
        for (int i = 0; i < size; i++) {
            heapPermute(array, size - 1, consumer);
            if (size % 2 == 0) {
                swap(array, i, size - 1);
            } else {
                swap(array, 0, size - 1);
            }
        }
    }

    // Heap's algorithm for boolean[]
    public static void heapPermute(boolean[] array, int size, java.util.function.Consumer<boolean[]> consumer) {
        if (size == 1) {
            consumer.accept(array.clone());
            return;
        }
        for (int i = 0; i < size; i++) {
            heapPermute(array, size - 1, consumer);
            if (size % 2 == 0) {
                swap(array, i, size - 1);
            } else {
                swap(array, 0, size - 1);
            }
        }
    }


}
