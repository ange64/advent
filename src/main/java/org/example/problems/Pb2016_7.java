package org.example.problems;

import org.example.template.Template;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Pb2016_7 extends Template<char[][]> {

    public Pb2016_7() {
        super(2016, 7, "Day 7: Internet Protocol Version 7");
    }


    @Override
    protected void exec_part_1(char[][]  data) throws Exception {
        int count = 0;
        for (char[] ip : data) {
            boolean inside = false;
            boolean supportsTLS = false;
            for (int i = 3; i < ip.length; i++) {
                if (ip[i] < 'a') {
                    inside = ip[i] == '[';
                    i += 4;
                }
                if (ip[i - 3] == ip[i] && ip[i - 2] == ip[i - 1] && ip[i - 1] != ip[i]) {
                    supportsTLS = !inside;
                    if (inside) break;
                }
            }
            if (supportsTLS) count++;
        }
        System.out.println(count);
    }

    @Override
    protected void exec_part_2(char[][]  data) throws Exception {
        int count = 0;
        for (char[] ip : data) {
            boolean inside = false;;
            Set<String> abas = new HashSet<>();
            Set<String> babs = new HashSet<>();
            for (int i = 2; i < ip.length; i++) {
                if (ip[i] < 'a') {
                    inside = ip[i] == '[';
                    i += 3;
                }
                if (ip[i - 2] == ip[i] && ip[i - 1] != ip[i]) {
                    if (inside) {
                        abas.add(ip[i] + "" + ip[i - 1] + "" +  ip[i]);
                    } else {
                        babs.add(ip[i - 1] + "" + ip[i] + "" +  ip[i - 1]);
                    }
                }
                if (abas.stream().anyMatch(babs::contains)){
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }

    @Override
    protected char[][] parseInput(String[] lines) {
        return Arrays.stream(lines).map(String::toCharArray).toArray(char[][]::new);
    }
}
