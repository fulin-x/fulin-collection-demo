package com.fulin;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Fulin
 * @Description: ArrayMap实现
 * @DateTime: 2025/5/5 下午1:06
 **/
public class FulinArrayMap<K,V> {

    List<Node<K,V>> table = new ArrayList<>();

    public V put(K key,V value){
        for (Node<K,V> node : table){
            if (node.key.equals(key)){
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
        }
        Node<K,V> newNode = new Node<>(key,value);
        table.add(newNode);
        return null;
    }

    public V get(K key){
        for (Node<K,V> node : table){
            if (node.key.equals(key)){
                return node.value;
            }
        }
        return null;
    }

    public V remove(K key){
        for (int i = 0; i < table.size(); i++){
            Node<K,V> node = table.get(i);
            if (node.key.equals(key)){
                return this.table.remove(i).value;
            }
        }
        return null;
    }

    public int size(){
        return this.table.size();
    }

    class Node<K,V>{
        K key;
        V value;
        public Node(K key,V value){
            this.key = key;
            this.value = value;
        }
    }
}
