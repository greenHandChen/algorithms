package com.ceh.algorithms.Chapter3.Excercise.Excercise2_5_16;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by enHui.Chen on 2019/1/20.
 */
public class California implements Comparable<California> {
    private static final Map<String, Integer> WORD_ORDER = new HashMap<>();
    private String str;

    static {
        WORD_ORDER.put("R", 1);
        WORD_ORDER.put("W", 2);
        WORD_ORDER.put("O", 3);
        WORD_ORDER.put("J", 4);
        WORD_ORDER.put("M", 5);
        WORD_ORDER.put("V", 6);
        WORD_ORDER.put("A", 7);
        WORD_ORDER.put("H", 8);
        WORD_ORDER.put("B", 9);
        WORD_ORDER.put("S", 10);
        WORD_ORDER.put("G", 11);
        WORD_ORDER.put("Z", 12);
        WORD_ORDER.put("X", 13);
        WORD_ORDER.put("N", 14);
        WORD_ORDER.put("T", 15);
        WORD_ORDER.put("C", 16);
        WORD_ORDER.put("I", 17);
        WORD_ORDER.put("E", 18);
        WORD_ORDER.put("K", 19);
        WORD_ORDER.put("U", 20);
        WORD_ORDER.put("P", 21);
        WORD_ORDER.put("D", 22);
        WORD_ORDER.put("Y", 23);
        WORD_ORDER.put("F", 24);
        WORD_ORDER.put("L", 25);
        WORD_ORDER.put("Q", 26);
    }

    public California(String str) {
        this.str = str;
    }

    @Override
    public int compareTo(California c) {
        if (this.getStr().equals(c.getStr())) return 0;
        for (int i = 0; i < Math.min(this.getStr().length(), c.getStr().length()); i++) {
            int index1 = WORD_ORDER.get(this.getStr().substring(i, i + 1).toUpperCase());
            int index2 = WORD_ORDER.get(c.getStr().substring(i, i + 1).toUpperCase());
            if (index1 > index2) return 1;
            if (index1 < index2) return -1;
        }
        return this.getStr().length() - c.getStr().length();
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}

