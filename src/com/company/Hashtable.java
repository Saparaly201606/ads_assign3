package com.company;
class Hashtbl<K,V> {

    private Hashnode<K, V>[] nodes;

    public Hashtbl(int size) {
        nodes = new Hashnode[size];
    }

    private int getIndex(K key) {
        int hash = key.hashCode() % nodes.length;
        if (hash < 0) {
            hash += nodes.length;
        }
        return hash;
    }

    public V insert(K key, V data) {
        int hash = getIndex(key);

        // Lets check if same key already exists and if so lets update it with the new value
        for (Hashnode<K, V> node = nodes[hash]; node != null; node = node.next) {
            if ((hash == node.hash) && key.equals(node.key)) {
                V oldData = node.data;
                node.data = data;
                return oldData;
            }
        }

        // Lets add the new hash node created below to the start of linked list at nodes[hash] position
        Hashnode<K, V> node = new Hashnode<K, V>(key, data, nodes[hash], hash);
        nodes[hash] = node;

        return null;
    }

    public boolean remove(K key) {
        int hash = getIndex(key);
        Hashnode<K, V> previous = null;
        for (Hashnode<K, V> node = nodes[hash]; node != null; node = node.next) {
            if ((hash == node.hash) && key.equals(node.key)) {
                if (previous != null) {
                    previous.next = node.next;
                } else {
                    nodes[hash] = node.next;
                }
                return true;
            }
            previous = node;
        }
        return false;
    }

    public V get(K key) {
        int hash = getIndex(key);

        for (Hashnode<K, V> node = nodes[hash]; node != null; node = node.next) {
            if (key.equals(node.key))
                return node.data;
        }
        return null;
    }

    public void resize(int size) {
        Hashtbl<K, V> newtbl = new Hashtbl<K, V>(size);
        for (Hashnode<K, V> node : nodes) {
            for (; node != null; node = node.next) {
                newtbl.insert(node.key, node.data);
                remove(node.key);
            }
        }
        nodes = newtbl.nodes;
    }
}

