package com.ceh.algorithms.Chapter2.Excercises.Excercise2_5_24;


public class Domain implements Comparable<Domain> {

    private String str;

    // 用于观察记录
    private int order;

    public Domain(String str, int order) {
        this.str = str;
        this.order = order;
    }

    @Override
    public int compareTo(Domain o) {
        if (this.str.equals(o.str)) return 0;
        if (this.str.compareTo(o.str) > 0) return 1;
        if (this.str.compareTo(o.str) < 0) return -1;
        return 0;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Domain{" +
                "str='" + str + '\'' +
                ", order=" + order +
                '}';
    }
}
