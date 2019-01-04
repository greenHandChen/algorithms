package com.ceh.algorithms.Chapter2.Excercises;

/**
 * @Author: enHui.Chen
 * @Description: 计算数论.a, b, c, d∈0~10^6,从小到大打印a^3+b^3的结果,并且找出a^3+b^3=c^3+d^3的不同整数a,b,c,d.
 * (其实由于优先队列的性质,相等的两个值必然接连出现)
 */
public class Excercise2_4_25 {
    public static void main(String[] args) {
        // MinPQ的实现在Excercise2_4_15
        int N = 14;
        MinPQ<CubeSum> minPQ = new MinPQ<>(N);
        for (long i = 0; i <= N; i++) {
            minPQ.insert(new CubeSum(i, 0));
        }
        CubeSum rc = new CubeSum(0, 0);
        while (minPQ.getSize() > 0) {
            CubeSum c = minPQ.delMin();
            if (c.getI() != 0 && c.getJ() != 0 && (c.getI() != rc.getJ() && c.getI() != rc.getI()) && rc.getSum() == c.getSum())
                System.out.println(rc.getI() + "^3 + " + rc.getJ() + "^3 = " + c.getI() + "^3 + " + c.getJ() + "^3");
            rc = c;
            if (c.getJ() < N) minPQ.insert(new CubeSum(c.getI(), c.getJ() + 1));
        }
    }
}

class CubeSum implements Comparable<CubeSum> {
    private long sum;
    private long i;
    private long j;

    public CubeSum(long i, long j) {
        this.i = i;
        this.j = j;
        this.calSum();
    }

    @Override
    public int compareTo(CubeSum o) {
        return compare(this.sum, o.sum);
    }

    public int compare(long i, long j) {
        return (i > j) ? 1 : ((i == j) ? 0 : -1);
    }

    @Override
    public String toString() {
        return sum + "=" + i + "^3" + "+" + j + "^3";
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public void setI(long i) {
        this.i = i;
    }

    public void setJ(long j) {
        this.j = j;
    }

    public long getSum() {
        return sum;
    }

    public long getI() {
        return i;
    }

    public long getJ() {
        return j;
    }

    public void calSum() {
        sum = i * i * i + j * j * j;
    }
}