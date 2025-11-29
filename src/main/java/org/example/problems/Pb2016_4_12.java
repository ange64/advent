package org.example.problems;

import org.example.template.Template;

import java.util.ArrayList;
import java.util.List;

public class Pb2016_4_12 extends Template<Pb2016_4_12.RoomInfo[]> {

    public Pb2016_4_12() {
        super(2016, 4, "Day 4: Security Through Obscurity");
    }

    @Override
    protected void exec_part_1(RoomInfo[] data) {
        int sum = 0;
        for (var r : data) {
            int[] histogram = new int[26];
            for (char c: r.letters) {
                if (c == '-') continue;
                histogram[c - 'a']++;
            }
            List<Entry> sorted = new ArrayList<>();
            for (int i = 'a'; i < 'a' + 26; i++){
                if ( histogram[i - 'a'] == 0) continue;
                sorted.add(new Entry((char) i, histogram[i - 'a']));
            }
            sorted.sort((o1, o2) -> o2.f - o1.f);
            int lastCnt = 100000;
            char last = 'a';
            boolean isValid = true;
            int i = 0;
            for (char c : r.checksum) {
                if (!isValid) break;
                Entry e = sorted.get(i++);
                if (e.c != c || e.f > lastCnt || (e.f == lastCnt && c <= last)) {
                    isValid = false;
                }
                lastCnt = e.f;
                last = c;
            }
            if (isValid) sum += r.id;

            //part 2
            for (i = 0; i < r.letters.length; i++) {
                if (r.letters[i] == '-') continue;
                r.letters[i] = (char) (((r.letters[i] - 'a') + r.id) % 26 + 'a');
            }
            System.out.println("rotated : " + new String(r.letters) + " | id " + r.id);
        }
        System.out.println(sum);
    }

    @Override
    protected void exec_part_2(RoomInfo[] data) throws Exception {

    }

    @Override
    protected RoomInfo[] parseInput(String[] lines) {
        var result = new RoomInfo[lines.length];
        for (int i = 0; i < lines.length; i++) {
            var l = lines[i];
            var idx1 = l.lastIndexOf('-');
            var idx2 = l.indexOf('[');
            result[i] = new RoomInfo(
                    l.substring(0,idx1).toCharArray(),
                    Integer.parseInt(l.substring(idx1 + 1, idx2)),
                    l.substring(idx2 + 1, l.length() - 1).toCharArray()
            );
            System.out.println(result[i]);
        }
        return result;
    }

    private record Entry(char c, int f){

    }

    public record RoomInfo(char[] letters, int id, char[] checksum){
        @Override
        public String toString() {
            return "letters: " + new String(letters) + " id: " + id + " checksum: " + new String(checksum) + "";
        }
    }
}
