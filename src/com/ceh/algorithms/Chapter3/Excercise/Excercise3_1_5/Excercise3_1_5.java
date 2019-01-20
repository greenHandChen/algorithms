package com.ceh.algorithms.Chapter3.Excercise.Excercise3_1_5;

import org.junit.Test;

/**
 * @Author: enHui.Chen
 * @Descriptio: 基于无序链表的符号表
 */
public class Excercise3_1_5 {
    @Test
    public void st() {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
        st.put("s", 1);
        st.put("b", 2);
        st.put("s", 99);
        st.put("a", 55);
        st.put("z", 6);
        st.put("c", 2);
        for (String key : st.keys()) {
            System.out.println(key + " = " + st.get(key));
        }
        System.out.println("size = " + st.size());
//        st.delete("s");
        st.delete("b");
        st.delete("a");
        st.delete("z");
        st.delete("c");
        System.out.println(st.isEmpty());
    }
}
