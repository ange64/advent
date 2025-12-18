package org.example.problems.year2016;

import org.example.template.Template;
import org.example.template.primitive.arrays.ArrUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Pb14 extends Template<String> {

    MessageDigest md = MessageDigest.getInstance("MD5");

    public Pb14() throws NoSuchAlgorithmException {
        super(2016, 14, "One-Time Pad");
    }

    @Override
    protected void exec_part_1(String data) throws Exception {
        var quintuples = new HashMap<Character, Integer>();
        int keyCount = 0;
        int curr = -1;
        while (keyCount < 64) {
            curr++;
            byte[] hash = md.digest((data + curr).getBytes(StandardCharsets.UTF_8));
            char[] str = ArrUtils.toHexChars(hash);
            for (int i = 0; i < str.length - 4; i++) {
                char c = str[i];
                if (c == str[i + 1] && c == str[i + 2] && c == str[i + 3] && c == str[i + 4]) {
                    quintuples.put(c, curr);
                    break;
                }
            }
            if (curr < 1000) continue;
            hash = md.digest((data + (curr - 1000)).getBytes(StandardCharsets.UTF_8));
            str = ArrUtils.toHexChars(hash);
            for (int i = 0; i < str.length - 2; i++) {
                char c = str[i];
                if (c == str[i + 1] && c == str[i + 2]) {
                    if (quintuples.containsKey(c)) {
                        if (quintuples.get(c) <= (curr - 1000)) {
                            quintuples.remove(c);
                        }else {
                            System.out.printf("match %s found : %s, %s, %s\n", keyCount + 1, c, (curr - 1000), quintuples.get(c));
                            keyCount++;
                        }
                    }
                    break;
                }
            }
        }
        System.out.println((curr - 1000));
    }

    @Override
    protected void exec_part_2(String data) throws Exception {
        var quintuples = new HashMap<Character, Integer>();
        int keyCount = 0;
        int curr = -1;
        while (keyCount < 64) {
            curr++;
            byte[] hash = md.digest((data + curr).getBytes(StandardCharsets.UTF_8));
            for (int i = 0; i < 2016; i++) {
                String str = new String(ArrUtils.toHexChars(hash));
               hash = md.digest(str.getBytes(StandardCharsets.UTF_8));
            }
            char[] str = ArrUtils.toHexChars(hash);
            for (int i = 0; i < str.length - 4; i++) {
                char c = str[i];
                if (c == str[i + 1] && c == str[i + 2] && c == str[i + 3] && c == str[i + 4]) {
                    quintuples.put(c, curr);
                    break;
                }
            }
            if (curr < 1000) continue;
            hash = md.digest((data + (curr - 1000)).getBytes(StandardCharsets.UTF_8));
            for (int i = 0; i < 2016; i++) {
                hash = md.digest(new String(ArrUtils.toHexChars(hash)).getBytes(StandardCharsets.UTF_8));
            }
            str = ArrUtils.toHexChars(hash);
            for (int i = 0; i < str.length - 2; i++) {
                char c = str[i];
                if (c == str[i + 1] && c == str[i + 2]) {
                    if (quintuples.containsKey(c)) {
                        if (quintuples.get(c) <= (curr - 1000)) {
                            quintuples.remove(c);
                        }else {
                            System.out.printf("match %s found : %s, %s, %s\n", keyCount + 1, c, (curr - 1000), quintuples.get(c));
                            keyCount++;
                        }
                    }
                    break;
                }
            }
        }
        System.out.println((curr - 1000));

    }

    @Override
    protected String parseInput(String[] lines) {
        return lines[0];
    }
}
