package com.fulin;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Fulin
 * @Description: HashMap实现
 * @DateTime: 2025/5/5 下午1:34
 **/
public class FulinHashMap<K, V> {

    private Node<K, V>[] table = new Node[16];

    private int size = 0;

    public V put(K key, V value) {
        int keyIndex = indexOf(key);
        Node<K, V> node = table[keyIndex];
        if (node == null) {
            table[keyIndex] = new Node<>(key, value);
            size++;
            resizeIfNecessary();
            return null;
        }
        while (true) {
            if(node.key.equals(key)){
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
            if(node.next == null){
                node.next = new Node<>(key, value);
                size++;
                resizeIfNecessary();
                return null;
            }
            node = node.next;
        }
    }

    public V get(K key) {
        int keyIndex = indexOf(key);
        Node<K, V> node = table[keyIndex];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public V remove(K key) {
        int keyIndex = indexOf(key);
        Node<K, V> node = table[keyIndex];
        if (node == null) {
            return null;
        }
        if(node.key.equals(key)){
            table[keyIndex] = node.next;
            size--;
            return node.value;
        }
        Node<K, V> pre = node;
        Node<K, V> cur = node.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                pre.next = cur.next;
                size--;
                return cur.value;
            }
            pre = cur;
            cur = cur.next;
        }
        return null;
    }

    public int size() {
        return this.size;
    }

    private void resizeIfNecessary() {
        if(this.size < table.length * 0.75){
            return;
        }
        Node<K, V>[] newTable = new Node[this.table.length * 2];
        for(Node<K,V> head: this.table){
            if(head == null) {
                continue;
            }
            Node<K,V> cur = head;
            while (cur != null){
                int newIndex = cur.key.hashCode() & (newTable.length - 1);
                if (newTable[newIndex] == null) {
                    newTable[newIndex] = cur;
                    Node<K,V> next = cur.next;
                    cur.next = null;
                    cur = next;
                }else {
                    Node<K,V> next = cur.next;
                    cur.next = newTable[newIndex];
                    newTable[newIndex] = cur;
                    cur = next;
                }
            }
        }
        this.table = newTable;
        System.out.println("发生扩容，扩容到"+this.table.length);
    }

    private int indexOf(Object key) {
        return key.hashCode() & (table.length - 1);
    }

    class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
