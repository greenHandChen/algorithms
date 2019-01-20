package com.ceh.algorithms.Chapter3.Excercise.Excersice2_5_14;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: enHui.Chen
 * @Description: 逆域名排序:aa.bca bb.abc 排序后 bb.abc aa.bca
 */
public class Excersice2_5_14 {
    private String[] words = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l"};
    private Domain[] domains;

    @Before
    public void generateData() {
        int n = 15;
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        this.domains = new Domain[n];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < random.nextInt(2) + 2; j++) {
                sb.append(this.words[random.nextInt(this.words.length)]);
            }
            sb.append(".");
            for (int j = 0; j < random.nextInt(8) + 5; j++) {
                sb.append(this.words[random.nextInt(this.words.length)]);
            }
            sb.append(".");
            for (int j = 0; j < random.nextInt(2) + 2; j++) {
                sb.append(this.words[random.nextInt(this.words.length)]);
            }
            this.domains[i] = new Domain(sb.toString());
            sb.setLength(0);
        }
    }

    @Test
    public void reverseSortTest() {
        Arrays.sort(this.domains, (o1, o2) -> {
            for (int i = 0; i < Math.min(o1.getLength(), o2.getLength()); i++) {
                String str1 = o1.getStrs()[o1.getLength() - 1 - i];
                String str2 = o2.getStrs()[o2.getLength() - 1 - i];
                if (str1.compareTo(str2) > 0) return 1;
                if (str1.compareTo(str2) < 0) return -1;
            }
            return o1.getLength() - o2.getLength();
        });
        for (Domain domain : domains) {
            System.out.println(domain);
        }
    }

}