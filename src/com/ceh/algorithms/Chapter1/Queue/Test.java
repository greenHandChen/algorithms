package com.ceh.algorithms.Chapter1.Queue;

/**
 * Created by enHui.Chen on 2018/12/30.
 */
public class Test {
    public static void main(String[] args) {
        Queue<String> queues = new Queue<String>();
        queues.enqueue("a");
        queues.enqueue("b");
        queues.enqueue("c");
        queues.enqueue("a");
        queues.enqueue("c");
        queues.dequeue();
        queues.dequeue();
        queues.forEach(queue -> System.out.println(queue));
    }
}
