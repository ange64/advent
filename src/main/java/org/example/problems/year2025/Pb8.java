package org.example.problems.year2025;

import org.example.template.Template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Pb8 extends Template<Pb8.Point[]> {

    public Pb8() {
        super(2025, 8, "Playground");
    }

    @Override
    protected void exec_part_1(Point[] data) throws Exception {
        long[] distances = new long[(data.length - 1) * (data.length / 2)];
        var groupToPoints = new HashMap<Integer, List<Integer>>();
        int k = 0;
        for (int i = 0; i < data.length; i++) {
            data[i].g = i;
            groupToPoints.put(i, new ArrayList<>());
            groupToPoints.get(i).add(i);
            for (int j = i + 1; j < data.length; j++) {
                int dist = Point.dist2(data[i], data[j]);
                distances[k++] = (((long) dist) << 32) | (((long) i) << 16) | j;
            }
        }
        Arrays.sort(distances);
        int connectionsLeft = 10;
        for (int i = 0; i < connectionsLeft; i++) {
            Point a = data[(int) ((distances[i] >> 16) & 0xFFFF)];
            Point b = data[(int) (distances[i] & 0xFFFF)];
            if (a.g == b.g) continue;
            var allOfGroupB = groupToPoints.get(b.g);
            int oldGroup = b.g;
            var allOfGroupA = groupToPoints.get(a.g);
            for (Integer idx : allOfGroupB) {
                data[idx].g = a.g;
                allOfGroupA.add(idx);
            }
            groupToPoints.remove(oldGroup);
        }
        var r = groupToPoints.values().stream().mapToInt(List::size).sorted().toArray();
        System.out.println(r[r.length - 1] * r[r.length - 2] * r[r.length - 3]);
    }

    @Override
    protected void exec_part_2(Point[] data) throws Exception {
        long[] distances = new long[(data.length - 1) * (data.length / 2)];
        var groupToPoints = new HashMap<Integer, List<Integer>>();
        int k = 0;
        for (int i = 0; i < data.length; i++) {
            data[i].g = i;
            groupToPoints.put(i, new ArrayList<>());
            groupToPoints.get(i).add(i);
            for (int j = i + 1; j < data.length; j++) {
                int dist = Point.dist2(data[i], data[j]);
                distances[k++] = (((long) dist) << 32) | (((long) i) << 16) | j;
            }
        }
        Arrays.sort(distances);
        for (long distance : distances) {
            Point a = data[(int) ((distance >> 16) & 0xFFFF)];
            Point b = data[(int) (distance & 0xFFFF)];
            if (a.g == b.g) continue;
            var allOfGroupB = groupToPoints.get(b.g);
            int oldGroup = b.g;
            var allOfGroupA = groupToPoints.get(a.g);
            for (Integer idx : allOfGroupB) {
                data[idx].g = a.g;
                allOfGroupA.add(idx);
            }
            groupToPoints.remove(oldGroup);
            if (groupToPoints.size() == 1) {
                System.out.println(a + " " + b + " result " + (long) a.x * (long) b.x);
                break;
            }
        }
    }

    @Override
    protected Point[] parseInput(String[] lines) {
        var pts = new Point[lines.length];
        for (int i = 0; i < lines.length; i++) {
            String[] split = lines[i].split(",");
            var pt = new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 0);
            pts[i] = pt;
        }
        return pts;
    }

    protected static class Point {
        int x, y, z, g;

        Point(int x, int y, int z, int g) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.g = g;
        }

        static int dist2(Point p1, Point p2) {
            int dx = (p2.x - p1.x) >> 4;
            int dy = (p2.y - p1.y) >> 4;
            int dz = (p2.z - p1.z) >> 4;
            return dx * dx + dy * dy + dz * dz;
        }

        @Override
        public String toString() {
            return String.format("pts[x:%s,y:%s,z%s]", x, y, z);
        }
    }
}
