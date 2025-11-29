package org.example.problems;

import org.example.template.Template;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HexFormat;
import java.util.List;

public class Pb2016_5 extends Template<String> {

    public Pb2016_5() {
        super(2016, 5, "Day 5: How About a Nice Game of Chess?");
    }

    @Override
    protected void exec_part_1(String data) throws Exception {
        part1(data);
    }

    @Override
    protected void exec_part_2(String data) throws Exception {
        part2(data);
    }

    private void part1(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        int i = 1;
        byte[] temp;
        List<Character> password = new ArrayList<>();
        for (int j = 0; j < 8; j++) {
            do {
                temp = md.digest((data + i++).getBytes());
            } while (temp[0] != 0 || temp[1] != 0 || temp[2] > 15 || temp[2] < 0);
            String hex = HexFormat.of().formatHex(temp);
            System.out.println(hex);
            password.add(hex.charAt(5));
            System.out.println("char " + j + ": " + password.getLast());
        }
        System.out.println("result : " + password);
    }

    private void part2(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        int i = 1;
        byte[] temp;
        char[] password = new char[8];
        for (int j = 0; j < 8; j++) {
            do {
                temp = md.digest((data + i++).getBytes());
            } while (temp[0] != 0 || temp[1] != 0 || temp[2] > 7 || temp[2] < 0);
            String hex = HexFormat.of().formatHex(temp);
            System.out.println(hex);
            System.out.println(hex.charAt(6) + " | " + hex.charAt(5));
            if ( password[hex.charAt(5) - '0'] != '\0') {
                j--;
                continue;
            }
            password[hex.charAt(5) - '0'] = hex.charAt(6);

        }
        System.out.println("result : " + Arrays.toString(password));
    }


    @Override
    protected String parseInput(String[] lines) {
        return lines[0];
    }
}
