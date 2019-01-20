package com.ceh.algorithms.Chapter3.Excercise.Excercise3_1_2;

import com.ceh.algorithms.Chapter1.Queue.Queue;
import org.junit.Test;

/**
 * Created by enHui.Chen on 2019/1/20.
 */
public class Excercise3_1_1 {

    @Test
    public void araySTTest() {
        ArrayST<String, Integer> arrayST = new ArrayST<>();
        arrayST.put("s", 1);
        arrayST.put("b", 2);
        arrayST.put("s", 99);
        arrayST.put("a", 55);
        arrayST.put("z", 6);
        arrayST.put("c", 2);
        for (String key : arrayST.keys()) {
            System.out.println(key + " = " + arrayST.get(key));
        }
        System.out.println("size = " + arrayST.size());
        arrayST.delete("s");
        arrayST.delete("b");
        arrayST.delete("a");
        arrayST.delete("z");
        arrayST.delete("c");
        System.out.println(arrayST.isEmpty());
    }
}
