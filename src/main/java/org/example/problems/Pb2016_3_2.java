package org.example.problems;

import java.util.Arrays;

public class Pb2016_3_2 extends  Pb2016_3{

    public Pb2016_3_2(){
        super();
    }

    @Override
    protected void exec_part_1(int[][] data) {
        int valid = 0;
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < data.length; i+=3) {
                var triangle = new int[]{data[i][j], data[i + 1][j], data[i + 2][j]};
                Arrays.sort(triangle);
                if (triangle[0] + triangle[1] > triangle[2]) valid++;
            }
        }
        System.out.println(valid);
    }

}
