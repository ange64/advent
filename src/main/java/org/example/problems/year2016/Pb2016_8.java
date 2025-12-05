package org.example.problems.year2016;

import org.example.template.Template;
import org.example.template.Utils;

public class Pb2016_8 extends Template<Pb2016_8.Command[]> {


    public Pb2016_8() {
        super(2016, 8, "Day 8: Two-Factor Authentication");
    }

    @Override
    protected void exec_part_1(Command[] data) throws Exception {
        char[][] grid = Utils.charGrid(6,50, '.');
        for (Command c : data) {
            c.applyTo(grid);
            Utils.print2dArray(grid, " ");
        }
        int count = 0;
        for (char[] chars : grid) {
            for (char aChar : chars) {
                if (aChar == '#') count++;
            }
        }
        System.out.println("lit pixels : " + count);
    }

    @Override
    protected void exec_part_2(Command[] data) throws Exception {

    }

    private void applyRect(char[][] grid, int w, int h) {
        System.out.println("rect : " + w + " * " + h);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                grid[i][j] = '#';
            }
        }
    }

    private void applyRotateX(char[][] grid, int col, int amount) {
        System.out.println("rotateX : " + col + " by" + amount);
        int h = grid.length;
        int[] indices = new int[h];
        amount = amount % h;
        for (int y = 0; y < h; y++) {
            if (grid[y][col] == '.') {
                indices[y] = -1;
            } else {
                grid[y][col] = '.';
                indices[y] = y + amount >= h ?  y + amount - h : y + amount;
            }
        }
        for (int idx : indices) {
            if (idx == -1) continue;
            grid[idx][col] = '#';
        }
    }

    private void applyRotateY(char[][] grid, int row, int amount) {
        System.out.println("rotateY : " + row + " by" + amount);
        int w = grid[0].length;
        int[] indices = new int[w];
        amount = amount % w;
        for (int x = 0; x < w; x++) {
            if (grid[row][x] == '.') {
                indices[x] = -1;
            } else {
                grid[row][x] = '.';
                indices[x] = x + amount >= w ?  x + amount -w : x + amount;
            }
        }
        for (int idx : indices) {
            if (idx == -1) continue;
            grid[row][idx] = '#';
        }
    }

    @Override
    protected Command[] parseInput(String[] lines) {
        var result = new Command[lines.length];
        for (int i = 0; i < lines.length; i++) {
            var split = lines[i].split(" ");
            if (split[0].equals("rect")) {
                String[] numbers = split[1].split("x");
                result[i] = new Command(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]), this::applyRect);
            } else {
                int a = Integer.parseInt(split[2].substring(2));
                int b = Integer.parseInt(split[4]);
                result[i] = new Command(a, b, split[2].charAt(0) == 'x'  ? this::applyRotateX : this::applyRotateY);
            }
            System.out.println(result[i]);
        }
        return result;
    }

    protected record Command(int a, int b, GridConsumer gc){

        public void applyTo(char[][] grid) {
            gc.accept(grid, a, b);
        }

        interface GridConsumer {
            void accept(char[][] grid, int a, int b);
        }
    }
}
