package com.ceh.algorithms.Chapter1.Bag;

import java.util.Iterator;

/**
 * Created by enHui.Chen on 2018/12/30.
 */
public class Test {
    public static void main(String[] args) {
        Bag<String> bags = new Bag<String>();
        bags.add("a");
        bags.add("b");
        bags.add("c");
        bags.add("a");
        bags.add("c");
        for (Iterator<String> iterator = bags.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }
}
