package org.example;

import org.example.template.primitive.arrays.ArrUtils;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws Exception {
        long[] test = new long[]{ 1,2,3,4,5,6};
        ArrUtils.rotateInPlace(test, 4);
        System.out.println(Arrays.toString(test));
    }
}