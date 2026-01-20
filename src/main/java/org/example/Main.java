package org.example;

import org.example.problems.games.queensgame.*;
import org.example.problems.year2016.Pb22;
import org.example.template.Utils;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
        advent();
    }

    private static void advent() {
        var pb = new Pb22();
        pb.run();
    }

    private static void queenSolve() {
        var solver = new QgVercelSolverBuilder(158).build();
        var before = System.nanoTime();
        solver.solve();
        var after = System.nanoTime();
        System.out.println((after - before) / 1_000_000);
        var solution = solver.getSolution();
        Utils.print2dArray(solution, " ", 1, (HashMap<Character, Integer>) solver.getColorMap());
    }
}