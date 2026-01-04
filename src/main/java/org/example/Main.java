package org.example;

import org.example.problems.games.queensgame.*;
import org.example.template.Utils;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
        var solver = new QgVercelSolverBuilder(105).build();
        solver.solve();
        var solution = solver.getSolution();
        Utils.print2dArray(solution, " ", 1, (HashMap<Character, Integer>) solver.getColorMap());
    }
}