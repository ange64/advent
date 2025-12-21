package org.example.problems.year2016;

import org.example.template.Template;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pb2016_11 extends Template<Pb2016_11.Building> {

    private static final Pattern gen = Pattern.compile("(\\w+) generator");
    private static final Pattern chip = Pattern.compile("(\\w+)-compatible");

    public Pb2016_11() {
        super(2016, 11, "Radioisotope Thermoelectric Generators");
    }

    @Override
    protected void exec_part_1(Building data) throws Exception {
        //data.print();
        var visited = new HashSet<Integer>();
        var queue = new ArrayDeque<Building>();
        queue.add(data);
        int depth = 0;
        outer:
        while (!queue.isEmpty()) {
            int leftOnLevel = queue.size();
            while (leftOnLevel-- > 0) {
                var first = queue.pop();
                Integer hash = first.perfectHash();
                if (visited.contains(hash)) continue;
                visited.add(hash);
                //first.print();
                if (first.endCondition()) break outer;
                first.computeMoves(queue);
            }
            depth++;
        }
        System.out.println("final depth : " + depth + " " + queue.size());
    }

    @Override
    protected void exec_part_2(Building data) throws Exception {
    }

    @Override
    protected Building parseInput(String[] lines) {
        int nbFloors = lines.length;
        byte[] mapGen = new byte[26];
        byte[] mapChip = new byte[26];
        int filled = 0;
        Arrays.fill(mapGen, (byte) -1);
        Arrays.fill(mapChip, (byte) -1);
        for (int i = 0; i < lines.length; i++) {
            Matcher gens = gen.matcher(lines[i]);
            Matcher chips = chip.matcher(lines[i]);
            while (chips.find()) {
                int idx = chips.group(1).charAt(0) - 'a';
                mapChip[idx] = (byte) i;
                filled++;
            }
            while (gens.find()) {
                int idx = gens.group(1).charAt(0) - 'a';
                mapGen[idx] = (byte) i;
            }
        }
        short[] tuples = new short[filled];
        int i = 0;
        for (int j = 0; j < mapGen.length; j++) {
            if (mapGen[j] == -1) continue;
            tuples[i++] = (short) ((mapChip[j] << 8) | mapGen[j]);
        }
        return new Building(nbFloors, 0, tuples);
    }

    protected static class Building {
        private static final byte CHIP = (byte) 1;
        private static final byte GEN = (byte) 2;
        private static final byte TUPLE = (byte) 3;
        private final byte[][] floors;
        private final short[] tuples;
        private final int elevator;

        Building(int nbFloors, int elevator, short[] tuples) {
            this.floors = new byte[nbFloors][tuples.length];
            this.elevator = elevator;
            this.tuples = tuples;
            int i = 0;
            for (short tuple : tuples) {
                byte chip = (byte) (tuple >>> 8);
                byte gen = (byte) (tuple & 255);
                floors[chip][i] |= CHIP;
                floors[gen][i] |= GEN;
                i++;
            }
        }

        private boolean isValid(int dir) {
            boolean hasSigleChip = false;
            boolean hasGen = false;
            for (byte b : floors[elevator - dir]) {
                if (b >= 2) hasGen = true;
                if (b == 1) hasSigleChip = true;
                if (hasSigleChip && hasGen) return false;
            }
            hasSigleChip = false;
            hasGen = false;
            for (byte b : floors[elevator]) {
                if (b >= 2) hasGen = true;
                if (b == 1) hasSigleChip = true;
                if (hasSigleChip && hasGen) return false;
            }
            return true;
        }

        private void computeMoves(ArrayDeque<Building> queue) {
            if (elevator < 3) computeMoves((byte) 1, queue);
            if (elevator > 0) computeMoves((byte) -1, queue);
        }

        private void computeMoves(byte dir, ArrayDeque<Building> queue) {
            var tupleIdx = allSameTypeMoves(dir, GEN, queue);
            tupleIdx = allSameTypeMoves(dir, CHIP, queue);
            if (tupleIdx > -1) cloneIfValid(moveTuples(this.tuples, dir, TUPLE, tupleIdx), dir, queue);
        }

        private byte allSameTypeMoves(byte dir, byte type, ArrayDeque<Building> queue) {
            byte tupleIdx = -1;
            for (int i = 0; i < floors[elevator].length; i++) {
                if (floors[elevator][i] == 3) tupleIdx = (byte) i;
                if ((floors[elevator][i] & type) == 0) continue;
                short[] tuples2 = moveTuples(this.tuples, dir, type, (byte) i);
                cloneIfValid(tuples2, dir, queue);
                for (int j = i + 1; j < floors[elevator].length; j++) {
                    if ((floors[elevator][j] & type) == 0) continue;
                    cloneIfValid(moveTuples(tuples2, dir, type, (byte) j), dir, queue);
                }
            }
            return tupleIdx;
        }

        private short[] moveTuples(short[] base, byte dir, byte type, byte elem) {
            short[] newTuples = base.clone();
            if ((type & 1) == CHIP) {
                newTuples[elem] = (short) ((((newTuples[elem] >> 8) + dir) << 8) | (newTuples[elem] & 0xFF));
            }
            if ((type & 2) == GEN) {
                newTuples[elem] += dir;
            }
            return newTuples;
        }

        private void cloneIfValid(short[] tuples, byte dir, ArrayDeque<Building> out) {
            var b = new Building(floors.length, this.elevator + dir, tuples);
            if (b.isValid(dir)) out.add(b);
        }

        public Integer perfectHash() {
            short[] clone = tuples.clone();
            Arrays.sort(clone);
            return Arrays.hashCode(clone) << 3 + elevator;
        }

        private boolean endCondition() {
            int count = 0;
            for (byte b : floors[floors.length - 1]) {
                count += b;
            }
            return count == tuples.length * 3;
        }

        void print() {
            System.out.println("------------------------");
            for (int i = floors.length - 1; i >= 0; i--) {
                int nb = i + 1;
                String e = nb + (elevator + 1 == nb ? "E" : " ");
                System.out.println(e + Arrays.toString(floors[i]) + "|");
            }
            System.out.println("hash : " + this.perfectHash());
        }
    }
}
