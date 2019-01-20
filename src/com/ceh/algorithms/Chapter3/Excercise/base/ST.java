package com.ceh.algorithms.Chapter3.Excercise.base;

/**
 * Created by enHui.Chen on 2019/1/20.
 */
public interface ST<K, V> {
    // 插入
    void put(K k, V v);

    // 删除
    void delete(K k);

    // 查找
    V get(K k);

    // 是否包含
    boolean contains(K k);

    // 是否为空
    boolean isEmpty();

    // 符号表长度
    int size();

    // 遍历,keys
    Iterable<K> keys();
}
