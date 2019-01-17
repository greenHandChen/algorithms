package com.ceh.algorithms.Chapter2.Excercises.Excercise2_5_24;

import org.junit.Test;

/**
 * @Author: enHui.Chen
 * @Description: 稳定的优先队列:保证取出重复元素时和插入时的顺序一致
 */
public class Excercise2_5_24 {

    @Test
    public void stablePQTest() {
        StablePQ<Domain> stablePQ = new StablePQ<>(15);

        stablePQ.insert(new Domain("z", 2));
        stablePQ.insert(new Domain("b", 1));
        stablePQ.insert(new Domain("b", 3));
        stablePQ.insert(new Domain("c", 1));
        stablePQ.insert(new Domain("b", 99));
        stablePQ.insert(new Domain("a", 3));
        stablePQ.insert(new Domain("b", 2));
        stablePQ.insert(new Domain("a", 1));
        int N = stablePQ.getN();
        for (int i = 0; i < N; i++) {
            System.out.println(stablePQ.delMin());
        }
    }
}


