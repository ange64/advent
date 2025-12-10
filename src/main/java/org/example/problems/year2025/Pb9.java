package org.example.problems.year2025;

import org.example.template.Template;
import org.example.template.Utils;
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
        var xMap = new HashMap<Integer, Integer>();
        var yMap = new HashMap<Integer, Integer>();
        for (Point p : data) {
            if (p == null) continue;
            xMap.put((int) p.x, xMap.getOrDefault((int) p.x, 0) + 1);
            yMap.put((int) p.y, yMap.getOrDefault((int) p.y, 0) + 1);
        }
        System.out.println(xMap.values().stream().max(Comparator.naturalOrder()).get());
        System.out.println(yMap.values().stream().max(Comparator.naturalOrder()).get());
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
        //test
        List<Point> verticals = new ArrayList<>();
        List<Point> horizontals = new ArrayList<>();
        computeVertiHori(data, verticals, horizontals);
        HashMap<Point, int[]> dirs = computeDirections(data);
        Set<Point> allCross = getAllCross(data, verticals, horizontals, dirs);

        long max = 0;
        Point mP1 = null;
        Point mp2 = null;
        for (Point p1 : data) {
            for (Point p2 : data) {
                if (p1 == p2 || p1.x == p2.x || p1.y == p2.y) continue;
                if (!allCross.contains(new Point(p1.x, p2.y))) continue;
                if (!allCross.contains(new Point(p2.x, p1.y))) continue;
                long area = (Math.abs(p1.x - p2.x) + 1) * (Math.abs(p1.y - p2.y) + 1);
                if (area > max) {
                    max = area;
                    mp2 = p2;
                    mP1 = p1;
                }
            }
        }
        System.out.println(max);
        System.out.println(mP1 + " " + mp2);
        draw(data, allCross, mP1, mp2);
    }


    void draw(Point[] data, Set<Point> allCross, Point mp1, Point mp2) {
        char[][] test = new char[500][500];
        for (char[] chars : test) {
            Arrays.fill(chars, ' ');
        }
        for (int i = 0; i < test.length; i++) {
            test[i][0] = (char) ('0' + (i % 10));
        }
        for (int i = 0; i < test[0].length; i++) {
            test[0][i] = (char) ('0' + (i % 10));
        }

        if (data.length > 100) {
            var data2 = new Point[data.length];
            System.out.println(mp1.x /200 + "," + mp1.y /200);
            System.out.println(mp2.x /200 + "," + mp2.y /200);
            for (int i = 0; i < data.length; i++) {
                data2[i] = new Point(data[i].x / 200, data[i].y / 200);
            }
            var bbb = computeDirectLines(data2);
            for (Point point : bbb) {
                test[(int) point.y][(int) point.x] = '+';
            }
            for (Point p : data2) {
                test[(int) p.y][(int) p.x] = '#';
            }
            test[(int) (mp1.y /200)][(int) (mp1.x /200)] = '$';
            test[(int) (mp2.y /200)][(int) (mp2.x /200)] = '$';

        } else {
            var aaa = computeDirectLines(data);
            for (Point point : aaa) {
                test[(int) point.y][(int) point.x] = '+';
            }
            var temp = List.of(data);
            for (Point cross : allCross) {
                if (temp.contains(cross)) test[(int) cross.y][(int) cross.x] = '#';
                else test[(int) cross.y][(int) cross.x] = 'X';
            }
            test[(int) mp1.y][(int) mp1.x] = '$';
            test[(int) mp2.y][(int) mp2.x] = '$';
        }

        Utils.print2dArray(test, "", 1);
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

    protected Set<Point> getAllCross(Point[] data, List<Point> vert, List<Point> hori, HashMap<Point, int[]> dirs) {
        var result = new HashSet<Point>();
        var createdHori = new ArrayList<Point>();
        var createdVerti = new ArrayList<Point>();
        for (Point p : data) {
            result.add(p);
            if (!dirs.containsKey(p)) continue;
            int interX = exploreX(p, -dirs.get(p)[0], vert);
            if (interX != -1) {
                result.add(new Point(interX, p.y));
                createdHori.add(p);
                createdHori.add(new Point(interX, p.y));
            }
            int interY = exploreY(p, -dirs.get(p)[1], hori);
            if (interY != -1) {
                result.add(new Point(p.x, interY));
                createdVerti.add(p);
                createdVerti.add(new Point(p.x, interY));
            }
        }
        for (int i = 0; i < createdHori.size() - 1; i += 2) {
            Point h1 = createdHori.get(i);
            Point h2 = createdHori.get(i + 1);
            for (int j = 0; j < createdVerti.size() - 1; j += 2) {
                Point v1 = createdVerti.get(j);
                Point v2 = createdVerti.get(j + 1);
                var interX = interX(v1, v2, h1, (int) h2.x, false);
                var interY = interY(h1, h2, v1, (int) v2.y, false);
                if (interX > -1 && interY > -1) result.add(new Point(interX, interY));
            }
        }
        return result;
    }

    int exploreX(Point origin, int dx, List<Point> verticals) {
        int bound = dx < 0 ? -BIG : BIG;
        int minDistance = BIG;
        int minInterX = -1;
        for (int i = 0; i < verticals.size(); i += 2) {
            if (((verticals.get(i).x - origin.x) ^ dx) <= 0) continue;
            var interX = interX(verticals.get(i), verticals.get(i + 1), origin, bound, false);
            if (interX != -1 && Math.abs(origin.x - interX) < minDistance) {
                minDistance = (int) Math.abs(origin.x - interX);
                minInterX = interX;
            }
        }
        return minInterX;
    }

    int exploreY(Point origin, int dy, List<Point> horizontals) {
        int bound = dy < 0 ? -BIG : BIG;
        int minDistance = BIG;
        int minInterY = -1;
        for (int i = 0; i < horizontals.size(); i += 2) {
            if (((horizontals.get(i).y - origin.y) ^ dy) <= 0) continue;
            var interY = interY(horizontals.get(i), horizontals.get(i + 1), origin, bound, false);
            if (interY != -1 && Math.abs(origin.y - interY) < minDistance) {
                minDistance = (int) Math.abs(origin.y - interY);
                minInterY = interY;
            }
        }
        return minInterY;
    }


    //parameter v1 and v2 is vertical. exclusive intersection
    int interX(Point v1, Point v2, Point origin, int xEnd, boolean inclusive) {

        if (!inclusive && (origin.y == v1.y || v2.y == origin.y)) return -1;
        if (((v1.x - origin.x) ^ (v1.x - xEnd)) > 0) return -1;
        if (((origin.y - v1.y) ^ (origin.y - v2.y)) > 0) return -1;
        return (int) v1.x;
    }

    //parameter h1 and h2 is horizontal. exclusive intersection
    int interY(Point h1, Point h2, Point origin, int yEnd, boolean inclusive) {
        if (!inclusive && (origin.x == h1.x || h2.x == origin.x)) return -1;
        if (((origin.x - h1.x) ^ (origin.x - h2.x)) > 0) return -1;
        if (((h1.y - origin.y) ^ (h1.y - yEnd)) > 0) return -1;
        return (int) h1.y;
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
        long cross = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        if (cross > 0) return;
        if (a.x != b.x) {
            if (a.x > b.x) dirs.put(b, c.y > b.y ? BOT_RIGHT : TOP_RIGHT);
            else dirs.put(b, c.y > b.y ? BOT_LEFT : TOP_LEFT);
        } else {
            if (a.y > b.y) dirs.put(b, c.x > b.x ? BOT_RIGHT : BOT_LEFT);
            else dirs.put(b, c.x > b.x ? TOP_RIGHT : TOP_LEFT);
        }
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

