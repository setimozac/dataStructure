package com.setimoart;

import java.util.*;

public class Hash<K extends Comparable<K>,V> {


    int numElements, tableSize;
    double maxLoadFactor;
    List<HashElement<K,V>>[] hArray;

    public Hash(int tableSize) {
        this.tableSize = tableSize;
        hArray = (LinkedList<HashElement<K,V>>[]) new LinkedList[tableSize];
//        hArray = (LinkedList<HashElement<K,V>>[])  Array.newInstance(LinkedList.class, this.tableSize);
        for(int i=0;i<tableSize;i++)
            hArray[i] = new LinkedList<>();
        maxLoadFactor = 0.75;
        numElements = 0;

    }

    private class HashElement<T extends Comparable<T>, S> implements Comparable<HashElement<T, S>> {

        T key;
        S value;
        public HashElement(T key, S value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public int compareTo(HashElement<T, S> o) {
            return this.key.compareTo(o.key);
        }


    }

    private int hashBuilder(int hash, int tableSize) {
        int res = hash & 0x7fffffff;
        res %= tableSize;
        return res;
    }

    private boolean IsIncreaseLoadFactorNeeded() {
        return ((double)this.numElements / this.tableSize) >= this.maxLoadFactor;
    }

    private void increaseSize() {
        LinkedList<HashElement<K, V>>[] auxTable = (LinkedList<HashElement<K, V>>[]) new LinkedList[this.tableSize * 2];
        for(int i=0;i<this.tableSize * 2;i++)
            auxTable[i] = new LinkedList<>();
        for(List<HashElement<K,V>> item : hArray) {
            for(HashElement<K,V> element : item) {
                auxTable[hashBuilder(element.key.hashCode(), this.tableSize*2)].add(element);
            }
        }

        this.tableSize *= 2;
        hArray = auxTable;
    }

    public boolean add(K key, V value) {
        if(IsIncreaseLoadFactorNeeded()) {
            increaseSize();
        }
        HashElement<K, V> hashElement = new HashElement<>(key, value);
        int hashKey = hashBuilder(key.hashCode(), this.tableSize);

        hArray[hashKey].add(hashElement);
        this.numElements ++;
        return true;
    }

    public boolean remove(K key, V value) {
        int hashKey = hashBuilder(key.hashCode(), this.tableSize);
        boolean res = hArray[hashKey].remove(new HashElement<>(key, value));
        if(res) {
            this.numElements --;
        }
        return res;
    }

    public V getValue(K key) {
        int hashKey = hashBuilder(key.hashCode(), this.tableSize);
        for(HashElement<K, V>  item : hArray[hashKey]) {
//            if(item.key.equals(key)) return item.value;
            if((item.key).compareTo(key) == 0) return item.value;
        }
        return null;
    }

}
