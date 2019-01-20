package com.ceh.algorithms.Chapter3.Excercise.Excercise2_5_16;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: enHui.Chen
 * @Description: 公平的选举:按照设定的字母顺序,将给定的字符串排序
 */
public class Excercise2_5_16 {

    @Test
    public void californiaTest() {
        California[] californias = new California[5];
        californias[0] = new California("razbbb");
        californias[1] = new California("aazzzz");
        californias[2] = new California("bazzzz");
        californias[3] = new California("cccuioph");
        californias[4] = new California("raz");
        Arrays.sort(californias);
        for (California california : californias) {
            System.out.println(california.getStr());
        }

    }
}