package org.example.problems.year2025;

import org.example.template.Template;

import java.util.Arrays;

public class Pb2025_1 extends Template<int[]> {


    public Pb2025_1() {
        super(2025, 1, "Secret Entrance ");
    }

    @Override
    protected void exec_part_1(int[] data) throws Exception {
        int clock = 50;
        int count = 0;
        for (int datum : data) {
            clock += datum;
            clock %= 100;
            if (clock == 0) count++;
        }
        System.out.println(count);
    }

    @Override
    protected void exec_part_2(int[] data) throws Exception {
        int clock = 50;
        int count = 0;
        for (int datum : data) {
            if (datum > 0 ) {
                for (int i = 0; i < datum ; i++) {
                    if (++clock == 100) {
                        count++;
                        clock = 0;
                    }
                }
            } else {
                for (int i = -datum; i > 0; i--) {
                    if (--clock == 0) count++;
                    if (clock == -1) clock = 99;

                }
            }
        }
        System.out.println(count);
    }

    @Override
    protected int[] parseInput(String[] lines) {
        return Arrays.stream(lines).mapToInt(it ->  {
            int digit = Integer.parseInt(it.substring(1));
            return it.charAt(0) == 'L'? -1 * digit : digit;
        }).toArray();
    }


}
