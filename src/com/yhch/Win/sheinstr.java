package com.yhch.Win;

import java.util.HashSet;
import java.util.Scanner;

public class sheinstr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String shuru = in.nextLine();
        StringBuffer sb = new StringBuffer();
        HashSet<Character> hs = new HashSet<Character>();

        char[] c = shuru.toCharArray();

        for (int i = 0; i < c.length; i++) {
            if (hs.add(c[i])) {
                sb.append(c[i]);
            }
        }
        System.out.println(sb);
    }
}
