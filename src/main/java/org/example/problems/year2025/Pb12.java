package org.example.problems.year2025;

import org.example.template.Template;
import org.example.template.primitive.arrays.ArrUtils;
import org.example.template.primitive.arrays.GridUtils;

import java.util.*;

public class Pb12 extends Template<Pb12.Data> {
    char[][][][] configs;
    static int[] counts = new int[]{7, 7, 6, 7, 7, 5};

    public Pb12() {
        super(2025, 12, "Tree Farm");
    }

    @Override
    protected void exec_part_1(Data data) throws Exception {
        var sizes = data.sizes;
        int sum = 0;
        for (int i = 0; i < data.sizes.size(); i++) {
            var fit = data.toFit.get(i);
            int totalsize = (sizes.get(i)[0] * sizes.get(i)[1]);
            long needed = ArrUtils.sumBy(fit, (i1, idx) -> i1 * counts[idx]);
            // var str = String.format("totalsize %s | needed %s", totalsize, needed);
            if (totalsize >= needed) {
                System.out.println("can fit");
                sum++;
            } else System.out.println("can't fit");
            //System.out.println(str);
        }
        System.out.println(sum);
    }

    @Override
    protected void exec_part_2(Data data) throws Exception {

    }

    @Override
    protected Data parseInput(String[] lines) {
        int i = 0;
        List<char[][]> pres = new ArrayList<>();
        char c = 'A';
        while (!lines[i].contains("x")) {
            char[][] grid = new char[3][];
            grid[0] = lines[i + 1].replaceAll("#", String.valueOf(c)).toCharArray();
            grid[1] = lines[i + 2].replaceAll("#", String.valueOf(c)).toCharArray();
            grid[2] = lines[i + 3].replaceAll("#", String.valueOf(c++)).toCharArray();
            i += 5;
            pres.add(grid);
        }
        List<int[]> sizes = new ArrayList<>();
        List<int[]> toFit = new ArrayList<>();
        while (i < lines.length) {
            var split = lines[i].split(":");
            int[] size = ArrUtils.strToI(split[0].split("x"));
            int[] constraints = ArrUtils.strToI(split[1].trim().split(" "));
            sizes.add(size);
            toFit.add(constraints);
            i++;
        }
        generateConfigs(pres);
        return new Data(pres, sizes, toFit);
    }

    void generateConfigs(List<char[][]> grids) {
        this.configs = new char[grids.size()][][][];
        SequencedSet<char[][]> confSet = new TreeSet<>(Comparator.comparingInt(this::binaryHashCode));
        int i = 0;
        for (char[][] grid : grids) {
            ;
            confSet.clear();
            confSet.add(grid);
            confSet.add(GridUtils.rotateCW(grid));
            confSet.add(GridUtils.rotateCCW(grid));
            confSet.add(GridUtils.rotate180(grid));
            var rm = GridUtils.flipH(grid);
            confSet.add(rm);
            confSet.add(GridUtils.rotateCW(rm));
            confSet.add(GridUtils.rotateCCW(rm));
            confSet.add(GridUtils.rotate180(rm));
            configs[i] = new char[confSet.size()][][];
            int j = 0;
            for (char[][] chars : confSet) {
                configs[i][j++] = chars;
            }
            i++;
        }
    }


    private int binaryHashCode(char[][] grid) {
        int i = 0;
        i += (grid[0][0] == '.' ? 0 : 1);
        i += (grid[0][1] == '.' ? 0 : 1) << 1;
        i += (grid[0][2] == '.' ? 0 : 1) << 2;
        i += (grid[1][0] == '.' ? 0 : 1) << 3;
        i += (grid[1][1] == '.' ? 0 : 1) << 4;
        i += (grid[1][2] == '.' ? 0 : 1) << 5;
        i += (grid[2][0] == '.' ? 0 : 1) << 6;
        i += (grid[2][1] == '.' ? 0 : 1) << 7;
        i += (grid[2][2] == '.' ? 0 : 1) << 8;
        return i;
    }

    record Data(List<char[][]> presents, List<int[]> sizes, List<int[]> toFit) {

    }
}
