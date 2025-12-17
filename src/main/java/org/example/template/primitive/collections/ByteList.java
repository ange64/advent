package org.example.template.primitive.collections;

import org.example.template.primitive.PUtils;
import org.example.template.primitive.arrays.ArrUtils;
import org.example.template.primitive.functional.Mapper;

import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.function.Function;

public class ByteList extends PrimitiveList{

    private static final MessageDigest MD5;
    static {
        try {
            MD5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] array;
    int pointer = -1;

    public ByteList() {
        array = new byte[64];
    }

    public ByteList(int initial) {
        array = new byte[initial];
    }

    public ByteList initializeTo(byte value) {
        Arrays.fill(array, value);
        return this;
    }

    public ByteList add(byte i) {
        if (pointer == array.length - 1) {
            expand(1);
        }
        array[++pointer] = i;
        return this;
    }

    public ByteList addAll(byte[] b) {
        if (b.length + size()  > array.length){
            int newPow =  Integer.numberOfLeadingZeros(b.length + size());
            int currPow = Integer.numberOfLeadingZeros(array.length);
            expand(1 + currPow - newPow);
        }
        System.arraycopy(b,0, array, pointer + 1, b.length);
        pointer += b.length;
        return this;
    }

    private void expand(int power) {
        byte[] temp = new byte[array.length << power];
        System.arraycopy(array, 0, temp, 0, array.length);
        array = temp;
    }

    public void force(byte i) {
        array[++pointer] = i;
    }

    public byte get(int i) {
        if (i > pointer)  super.throwOOB(i);
        return array[i];
    }

    public byte pop() {
        if (pointer == -1) super.throwOOB(pointer);
        return array[pointer--];
    }

    public byte last() {
        return array[pointer];
    }

    public int size() {
        return pointer + 1;
    }

    public int capacity() {
        return array.length;
    }

    public byte set(byte v, int idx) {
        if (idx > pointer)  super.throwOOB(idx);
        var temp = array[idx];
        array[idx] = v;
        return temp;
    }

    public void softClear() {
        pointer = -1;
    }

    public void hardClear(byte defaultValue) {
        Arrays.fill(array, defaultValue);
    }

    @Override
    public ByteList sort() {
        Arrays.sort(array, 0, pointer + 1);
        return this;
    }

    public byte[] toArray() {
        byte[] result = new byte[pointer + 1];
        System.arraycopy(array, 0, result, 0, pointer + 1);
        return result;
    }

    public void md5Hash(byte[] out) throws DigestException {
        MD5.update(array, 0, size());
        MD5.digest(out, 0, 16);
    }

    public String toString(String sep) {
        StringBuilder sb = new StringBuilder("ByteList[");
        for (int i = 0; i < size() - 1; i++) {
            sb.append(array[i]).append(sep);
        }
        sb.append(last()).append("]");
        return sb.toString();
    }

    public String toString(String sep, Mapper.ByteTo<String> mapper) {
        StringBuilder sb = new StringBuilder("ByteList[");
        for (int i = 0; i < size() - 1; i++) {
            sb.append(mapper.map(array[i])).append(sep);
        }
        sb.append(mapper.map(last())).append("]");
        return sb.toString();
    }


    @Override
    public String toString() {
        return this.toString(",");
    }
}
