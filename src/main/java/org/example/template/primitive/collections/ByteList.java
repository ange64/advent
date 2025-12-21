package org.example.template.primitive.collections;

import org.example.template.primitive.arrays.ArrUtils;
import org.example.template.primitive.functional.Consumer;
import org.example.template.primitive.functional.Mapper;

import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ByteList extends PList {

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
            array = ArrUtils.expand(array, 1);
        }
        array[++pointer] = i;
        return this;
    }

    public ByteList addAll(byte[] b) {
        if (b.length + size() > array.length) {
            int newPow = Integer.numberOfLeadingZeros(b.length + size());
            int currPow = Integer.numberOfLeadingZeros(array.length);
            array = ArrUtils.expand(array, 1 + currPow - newPow);
        }
        System.arraycopy(b, 0, array, pointer + 1, b.length);
        pointer += b.length;
        return this;
    }

    public byte get(int i) {
        if (i > pointer) super.throwOOB(i);
        return array[i];
    }

    public byte pop() {
        if (pointer == -1) super.throwOOB(pointer);
        return array[pointer--];
    }

    public byte last() {
        return array[pointer];
    }

    public byte set(byte v, int idx) {
        if (idx > pointer) super.throwOOB(idx);
        var temp = array[idx];
        array[idx] = v;
        return temp;
    }

    @Override
    public ByteList sort() {
        Arrays.sort(array, 0, pointer + 1);
        return this;
    }

    public void forEachIndexed(Consumer.ByteIndexed c) {
        for (int i = 0; i < array.length; i++) {
            c.accept(array[i], i);
        }
    }

    @Override
    public byte[] toArray() {
        byte[] result = new byte[pointer + 1];
        System.arraycopy(array, 0, result, 0, pointer + 1);
        return result;
    }

    public void md5Hash(byte[] out) throws DigestException {
        MD5.update(array, 0, size());
        MD5.digest(out, 0, 16);
    }

    public String toString(Mapper.ByteTo<String> mapper) {
        return PrimitiveCollections.toString(array, size(), this.getClass().getName(), o -> mapper.map((Byte) o));
    }

    @Override
    public String toString() {
        return PrimitiveCollections.toString(array, size(), this.getClass().getName());
    }

}
