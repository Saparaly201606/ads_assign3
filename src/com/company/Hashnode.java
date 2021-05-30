package com.company;

public class Hashnode<K, V> {
        final K key;
        V data;
        Hashnode<K,V> next;
        final int hash;

        public Hashnode(K k, V v, Hashnode<K,V> n, int h){
            key = k;
            data = v;
            next = n;
            hash = h;
        }
}
