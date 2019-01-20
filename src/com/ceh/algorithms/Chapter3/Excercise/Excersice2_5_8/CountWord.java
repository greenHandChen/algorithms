package com.ceh.algorithms.Chapter3.Excercise.Excersice2_5_8;

/**
 * Created by enHui.Chen on 2019/1/20.
 */
public class CountWord {
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
