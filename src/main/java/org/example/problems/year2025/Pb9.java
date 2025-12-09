package org.example.problems.year2025;

import org.example.template.Template;
import org.example.template.Utils;
import org.example.template.primitive.collections.IntList;

import java.util.*;

public class Pb9 extends Template<Pb9.Point[]> {


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
        Set<Point> valid = computeDirectLines(data);
        //computeIndirectLines(data, valid);
        //char[][] grid = new char[15][15];
       // for (char[] chars : grid) {
       //     Arrays.fill(chars, '.');
       // }

       // for (Point point : valid) {
        //    grid[(int) point.y][(int) point.x] = 'O';
       // }
       //Utils.print2dArray(grid, "", 1);
        List<Point> verti = new ArrayList<>();
        List<Point> hori = new ArrayList<>();
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i].y == data[i + 1].y) {
                hori.add(data[i]);
                hori.add(data[i + 1]);
            } else {
                verti.add(data[i]);
                verti.add(data[i + 1]);
            }
        }
        long max = 0;
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                Point p1 = data[i];
                Point p2 = data[j];
                Point c1 = new Point(p1.x, p2.y);
                Point c2 = new Point(p2.x, p1.y);

            }
        }
        System.out.println(max);
    }


    long areaIfValid(Point p1, Point p2, Set<Point> valid) {
        long x =  Math.min(p1.x, p2.x);
        long y =  Math.min(p1.y, p2.y);
        long x2 =  Math.max(p1.x, p2.x);
        long y2 =  Math.max(p1.y, p2.y);
        for (long i = x; i < x2 ; i++) {
            if (!valid.contains(new Point(i, y)) || !valid.contains(new Point(i, y2))) return 0;
        }
        for (long i = y; i < y2 ; i++) {
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

    void computeIndirectLines(Point[] data, Set<Point> valid) {

    }

    boolean exploreX(Point origin, int dx, List<Point> verticals) {
        int linesCount = 0;
        for (int i = 0; i < verticals.size(); i += 2) {
            int delta = (int) (verticals.get(i).x - origin.x);
            if (delta * dx <= 0) continue;
            var interX = interX(verticals.get(i), verticals.get(i + 1), origin, 1000000 * dx);
            if (interX != -1) linesCount++;
        }
        return  linesCount % 2 == 1;
    }

    boolean exploreY(Point origin, int dy, List<Point> horizontals) {
        int crossed = 0;
        for (int i = 0; i < horizontals.size(); i += 2) {
            int delta = (int) (horizontals.get(i).y - origin.y);
            if (delta * dy <= 0 ) continue;
            var interY = interY(horizontals.get(i), horizontals.get(i + 1), origin, 1000000 * dy);
            if (interY != -1) crossed++;
        }
        return crossed % 2 == 1;
    }


    //parameter v1 and v2 is vertical
    int interX(Point v1, Point v2, Point origin, int xEnd) {
        if (((v1.x - origin.x) ^ (v1.x - xEnd)) > 0) return -1;
        if (((origin.y - v1.y) ^ (origin.y - v2.y)) > 0) return -1;
        return (int) v1.x;
    }

    //parameter h1 and h2 is horizontal
    int interY(Point h1, Point h2, Point origin, int yEnd) {
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

