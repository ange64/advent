package org.example.problems.year2025;

import org.example.template.Template;
import org.example.template.primitive.arrays.ArrUtils;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

public class Pb10 extends Template<Pb10.Command[]> {

    public Pb10() {
        super(2025, 10, "Factory");
    }

    @Override
    protected void exec_part_1(Command[] data) throws Exception {
        for (Command c : data) {

        }
    }

    int minMoves(Command target){
        int lights = 0;
        var visited = new HashSet<Integer>();
        var queue = new ArrayDeque<Integer>();
        queue.add(lights);
        int nbMoves = 0;
        while (!queue.isEmpty()) {
            int onLevel = queue.size();
            while (onLevel-- > 0) {
                int first = queue.pop();
                if (visited.contains(first)) continue;
                visited.add(first);

            }
            nbMoves++;
        }
        return 0;
    }


    @Override
    protected void exec_part_2(Command[] data) throws Exception {

    }

    @Override
    protected Command[] parseInput(String[] lines) {
        var result = new Command[lines.length];
        for (int i = 0; i < lines.length; i++) {
            String[] split = lines[i].split(" ");
            int lights = 0;
            for (int j = 1; j < split[0].length() - 1; j++) {
                if (split[0].charAt(j) == '.') continue;
                lights |= (1 << (j - 1));
            }
            int[] buttons = new int[split.length - 2];
            for (int j = 1; j < split.length - 1; j++) {
                String[] buttonDigits = split[j].substring(1, split[j].length() - 1).split(",");
                for (String bd : buttonDigits) {
                    buttons[j - 1] |= 1 << (bd.charAt(0) - '0');
                }
            }
            String last = split[split.length - 1];
            int[] jolts = ArrUtils.strToI(last.substring(1, last.length() - 1).split(","));
            result[i] = new Command(lights, buttons, jolts);
            System.out.println(result[i]);
        }
        return result;
    }

    record Command(int lights, int[] buttons, int[] jolt){
        @Override
        public String toString() {

            return "L"+ Integer.toBinaryString(lights).substring(16)+
                    "   B"+ Arrays.toString(ArrUtils.mapTo(buttons, i -> Integer.toBinaryString(16)))+
                    "   J" + Arrays.toString(jolt);
        }
    }
}
