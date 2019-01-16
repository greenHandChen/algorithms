package com.ceh.algorithms.Chapter2.Excercises;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: enHui.Chen
 * @Description: 统计输入的字符串中字符出现的频率, 按频率由高到低进行排序
 */
public class Excersice2_5_8 {

    @Test
    public void countTest() {
        String[] str = {"12", "12", "aa", "bb", "cc", "12", "cc", "bb", "11", "12"};
        int count = 1;
        int j = 0;
        String word = str[0];
        CountWord[] cws = new CountWord[str.length];
        Arrays.sort(str);
        for (int i = 1; i < str.length; i++, count++) {
            if (!str[i].equals(word)) {
                cws[j++] = new CountWord(count, word);
                word = str[i];
                count = 0;
            }
        }
        // 对最后一个元素特殊处理
        cws[j] = new CountWord(count, word);
        Arrays.sort(cws, (o1, o2) -> {
            if (o1 == null || o2 == null || o1.getCount() > o2.getCount()) return -1;
            if (o1.getCount() < o2.getCount()) return 1;
            else return 0;
        });
        for (int i = 0; i < cws.length; i++) {
            if (cws[i] == null) continue;
            System.out.println(cws[i]);
        }
    }
}

class CountWord {
    private int count;
    private String word;

    public CountWord(int count, String word) {
        this.count = count;
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "CountWord{" +
                "count=" + count +
                ", word='" + word + '\'' +
                '}';
    }
}
