package com.ceh.algorithms.Chapter3.Excercise.Excercise3_1_5;

import com.ceh.algorithms.Chapter1.Queue.Queue;
import com.ceh.algorithms.Chapter3.Excercise.base.ST;

/**
 * @Author: enHui.Chen
 * @Descriptio: 基于无序链表的符号表
 */
public class SequentialSearchST<K, V> implements ST<K, V> {
    private Node first;
    private int size = 0;

    private static class Node<K, V> {
        private K key;
        private V val;
        private Node next;

        public Node(K key, V val, Node node) {
            this.key = key;
            this.val = val;
            this.next = node;
        }
    }

    @Override
    public void put(K k, V v) {
        for (Node currentNode = first; currentNode != null; currentNode = currentNode.next) {
            if (currentNode.key.equals(k)) {
                currentNode.val = v;
                return;
            }
        }
        size++;
        first = new Node(k, v, first);
    }

    @Override
    public void delete(K k) {
        // 改变原有顺序
        for (Node currentNode = first; currentNode != null; currentNode = currentNode.next) {
            if (currentNode.key.equals(k)) {
                size--;
                currentNode.key = first.key;
                currentNode.val = first.val;
                first = first.next;
                return;
            }
        }
        // 不打乱原有顺序
//        first = delete(first, k);
    }

    public Node delete(Node currentNode, K k) {
        if (currentNode.key.equals(k)) {
            size--;
            return currentNode.next;
        }
        currentNode.next = delete(currentNode.next, k);
        return currentNode;
    }

    @Override
    public V get(K k) {
        for (Node currentNode = first; currentNode != null; currentNode = currentNode.next) {
            if (currentNode.key.equals(k)) return (V) currentNode.val;
        }
        return null;
    }

    @Override
    public boolean contains(K k) {
        for (Node currentNode = first; currentNode != null; currentNode = currentNode.next) {
            if (currentNode.key.equals(k)) return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<K> keys() {
        Queue<K> queue = new Queue<>();
        for (Node currentNode = first; currentNode != null; currentNode = currentNode.next) {
            queue.enqueue((K) currentNode.key);
        }
        return queue;
    }
}
