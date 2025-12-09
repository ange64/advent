package org.example.problems.year2025;

import org.example.template.Template;
import org.example.template.primitive.arrays.ArrUtils;

import java.util.*;

public class Pb9 extends Template<Pb9.Point[]> {


    static final int BIG = 200_000;
    static final int[] TOP_LEFT = new int[]{-1, -1};
    static final int[] TOP_RIGHT = new int[]{1, -1};
    static final int[] BOT_LEFT = new int[]{-1, 1};
    static final int[] BOT_RIGHT = new int[]{1, 1};

    public Pb9() {
        super(2025, 9, "Movie Theater");
    }

    @Override
    protected void exec_part_1(Point[] data) throws Exception {
        long max = 0;
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                long area = (Math.abs(data[j].x - data[i].x) + 1) * (Math.abs(data[j].y - data[i].y) + 1);
                if (area > max) max = area;
            }
        }
        System.out.println(max);
    }

    @Override
    protected void exec_part_2(Point[] data) throws Exception {
        List<Point> verticals = new ArrayList<>();
        List<Point> horizontals = new ArrayList<>();
        computeVertiHori(data, verticals, horizontals);
        Map<Point, int[]> dirs = computeDirections(data);
        long[] area = new long[]{0};
        ArrUtils.forAllPairs(data, (p1, p2) -> {
            if (p1.x == p2.x || p1.y == p2.y) return; // same line, osef
            if (!exploreX(p1, p1.x < p2.x ? 1 : -1, verticals, dirs)) return;
            if (!exploreY(p1, p1.y < p2.y ? 1 : -1, horizontals, dirs)) return;
            if (!exploreX(p2, p2.x < p1.x ? 1 : -1, verticals, dirs)) return;
            if (!exploreY(p2, p2.y < p1.y ? 1 : -1, horizontals, dirs)) return;
            long current = (Math.abs(p1.x - p2.x) + 1) * (Math.abs(p1.y - p2.y) + 1);
            if (current > area[0]) area[0] = current;
        });
        System.out.println(area[0]);
    }

    void computeVertiHori(Point[] data, List<Point> verticals, List<Point> horizontals) {
        ArrUtils.window(data, false, (p1, p2) -> {
            if (p1.x == p2.x) {
                verticals.add(p1);
                verticals.add(p2);
            } else {
                horizontals.add(p1);
                horizontals.add(p2);
            }
        });
    }

    HashMap<Point, int[]> computeDirections(Point[] data) {
        var result = new HashMap<Point, int[]>();
        for (int i = 1; i < data.length - 1; i++) { //triple window
            populateMap(data[i - 1], data[i], data[i + 1], result);
        }
        populateMap(data[data.length - 1], data[0], data[1], result);
        return result;
    }

    void populateMap(Point a, Point b, Point c, HashMap<Point, int[]> dirs) {
        if (a.x != b.x) {
            if (a.x > b.x) dirs.put(b, c.y > b.y ? BOT_RIGHT : TOP_RIGHT);
            else dirs.put(b, c.y > b.y ? BOT_LEFT : TOP_LEFT);
        } else {
            if (a.y > b.y) dirs.put(b, c.x > b.x ? BOT_RIGHT : BOT_LEFT);
            else dirs.put(b, c.x > b.x ? TOP_LEFT : TOP_RIGHT);
        }
    }


    long areaIfValid(Point p1, Point p2, Set<Point> valid) {
        long x = Math.min(p1.x, p2.x);
        long y = Math.min(p1.y, p2.y);
        long x2 = Math.max(p1.x, p2.x);
        long y2 = Math.max(p1.y, p2.y);
        for (long i = x; i < x2; i++) {
            if (!valid.contains(new Point(i, y)) || !valid.contains(new Point(i, y2))) return 0;
        }
        for (long i = y; i < y2; i++) {
            if (!valid.contains(new Point(x, i)) || !valid.contains(new Point(x2, i))) return 0;
        }
        return (x2 - x + 1) * (y2 - y + 1);
    }

    Set<Point> computeDirectLines(Point[] data) {
        Set<Point> validCoords = new HashSet<>();
        for (int i = 0; i < data.length - 1; i++) {
            Point p1 = data[i];
            Point p2 = data[i + 1];
            for (long j = Math.min(p1.x, p2.x); j <= Math.max(p1.x, p2.x); j++) {
                validCoords.add(new Point(j, p1.y));
            }
            for (long j = Math.min(p1.y, p2.y); j <= Math.max(p1.y, p2.y); j++) {
                validCoords.add(new Point(p1.x, j));
            }
        }
        return validCoords;
    }


    boolean exploreX(Point origin, int dx, List<Point> verticals, Map<Point, int[]> dirs) {
        //if (dirs.get(origin)[0] != dx) return false; // bad direction
        int crossed = 0;
        for (int i = 0; i < verticals.size(); i += 2) {
            if (((verticals.get(i).x - origin.x) ^ dx) <= 0) continue;
            var interX = interX(verticals.get(i), verticals.get(i + 1), origin, dx < 0 ? -BIG : BIG);
            if (interX > 0) crossed++;
        }
        return crossed == 0 || crossed % 2 == 1;
    }

    boolean exploreY(Point origin, int dy, List<Point> horizontals, Map<Point, int[]> dirs) {
       // if (dirs.get(origin)[1] != dy) return false; // bad direction
        int crossed = 0;
        for (int i = 0; i < horizontals.size(); i += 2) {
            if (((horizontals.get(i).y - origin.y) ^ dy) <= 0) continue;
            var interY = interY(horizontals.get(i), horizontals.get(i + 1), origin, dy < 0 ? -BIG : BIG);
            if (interY > 0) crossed++;
        }
        return crossed == 0 || crossed % 2 == 1;
    }


    //parameter v1 and v2 is vertical. exclusive intersection
    int interX(Point v1, Point v2, Point origin, int xEnd) {
        if (origin.x == v1.x || v1.x == xEnd) return -1;
        if (((v1.x - origin.x) ^ (v1.x - xEnd)) > 0) return -1;
        if (((origin.y - v1.y) ^ (origin.y - v2.y)) > 0) return -1;
        return (int) v1.x;
    }

    //parameter h1 and h2 is horizontal. exclusive intersection
    int interY(Point h1, Point h2, Point origin, int yEnd) {
        if (origin.y == h1.y || h1.y == yEnd) return -1;
        if (((origin.x - h1.x) ^ (origin.x - h2.x)) > 0) return -1;
        if (((h1.y - origin.y) ^ (h1.y - yEnd)) > 0) return -1;
        return (int) h1.y;
    }

    @Override
    protected Point[] parseInput(String[] lines) {
        var points = new Point[lines.length + 1];
        int i = 0;
        for (String line : lines) {
            var split = line.split(",");
            points[i++] = new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }
        points[lines.length] = new Point(points[0].x, points[0].y);
        return points;
    }

    record Point(long x, long y) {
    }
}

