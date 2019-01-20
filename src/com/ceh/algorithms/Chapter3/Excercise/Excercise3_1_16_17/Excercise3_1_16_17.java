package com.ceh.algorithms.Chapter3.Excercise.Excercise3_1_16_17;

import org.junit.Test;

 /**
   * @Author: enHui.Chen
   * @Description: 基于有序的二分查找符号表
   */
public class Excercise3_1_16_17 {

    @Test
    public void binarySearchSTTest() {
        BinarySearchST<String, Integer> bsST = new BinarySearchST<>();
        bsST.put("X", 1);
        bsST.put("A", 2);
        bsST.put("C", 3);
        bsST.put("H", 4);
        bsST.put("E", 5);
        bsST.put("M", 6);
        bsST.put("H", 88);
        bsST.put("L", 7);
        bsST.put("P", 222);
        bsST.put("R", 8);
        bsST.put("S", 9);
        bsST.put("X", 99);
        bsST.put("Q", 123);
        for (String key : bsST.keys()) {
            System.out.println(key + " = " + bsST.get(key));
        }
        System.out.println("floor:"+bsST.floor("N"));
        bsST.delete("M");
        System.out.println("---Del---");
        for (String key : bsST.keys()) {
            System.out.println(key + " = " + bsST.get(key));
        }

    }
}
