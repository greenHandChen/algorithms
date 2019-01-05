package com.ceh.algorithms.Chapter2.Excercises;

/**
 * @Author: enHui.Chen
 * @Description: 中位数的动态查找(插入删除时间复杂度为lgN, 查找时间复杂度为1)
 * @Data 2019/1/4
 */
public class Excersice2_4_30 {
    public static void main(String[] args) {
        MediumPQ mediumPQ = new MediumPQ();
        mediumPQ.insert(5);
        mediumPQ.insert(4);
        mediumPQ.insert(6);
        mediumPQ.insert(2);
        mediumPQ.insert(1);
        mediumPQ.insert(8);
        System.out.println(mediumPQ.delMedium());
        System.out.println(mediumPQ.delMedium());
    }
}

class MediumPQ {
    // 最小堆(存放较大数一侧),根节点在最小
    private MinPQ minPQ;
    // 最大堆(存放较小数一侧),根节点在最大
    private MaxPQ maxPQ;
    private int N = 0;
    // 中位数,大于较小里最大,小于较大里的最小
    private int medium;

    public MediumPQ() {
        this(16);
    }

    public MediumPQ(int size) {
        this.maxPQ = new MaxPQ(size);
        this.minPQ = new MinPQ(size);
    }

    public void insert(int e) {
        // 先插入再调整
        if (isEmpty()) {
            medium = e;
            N++;
            return;
        }
        if (e > medium) minPQ.insert(e);
        else maxPQ.insert(e);
        N++;
        calMedium();
    }

    public int delMedium() {
        if (isEmpty()) return -1;
        int oldMedium = medium;
        if (maxPQ.getSize() >= minPQ.getSize()) medium = maxPQ.delMax();
        else medium = (int) minPQ.delMin();
        N--;
        return oldMedium;
    }

    public void calMedium() {
        while (minPQ.getSize() - maxPQ.getSize() > 1) {
            maxPQ.insert(medium);
            medium = (int) minPQ.delMin();
        }
        while (maxPQ.getSize() - minPQ.getSize() > 1) {
            minPQ.insert(medium);
            medium = maxPQ.delMax();
        }
    }

    public int getMedium() {
        return this.medium;
    }

    public boolean isEmpty() {
        return N == 0;
    }

}
