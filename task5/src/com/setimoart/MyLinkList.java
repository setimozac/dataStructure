package com.setimoart;


import java.util.ArrayList;
import java.util.List;

public class MyLinkList<T> {
    private ArrayList<T> list;
    private Container start, end;
    private int size;

    public MyLinkList() {
        size = 0;
        start = null;
        end = null;
        list =  new ArrayList<>();
    }

    private class Container {           // start inner class Container
        private Container next;
        private T data;

        public Container(T data) {
            this.data = data;
            next = null;
        }

        public Container getNext() {
            return next;
        }

        public void setNext(Container next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }                                   // end inner class Container

    public int size() {
        return this.size;
    }

    public void addToFront(T obj) {
        Container item = new Container(obj);
        if(start == null) {
            start = item;
            end = item;
        }
        else{
            item.setNext(start);
            start = item;
        }
        size ++;
    }

    public void addToEnd(T obj) {
        Container item = new Container(obj);
        if(end == null) {
            start = item;
            end = item;
        }
        else {
            end.setNext(item);
            end = item;
        }
        size ++;
    }

    public T get(int index) {
        if(index + 1 > size || index < 0) {
            throw new IndexOutOfBoundsException("index out of bound");
        }
        Container item = start;
        for(int i = 0;i<index; i++) {
            item = item.getNext();
        }
        return item.getData();
    }
    private Container getContainer(int index) {
        Container item = start;
        for(int i = 0;i<index; i++) {
            item = item.getNext();
        }
        return item;
    }

    public void insertValueAtIndex(int index, T obj) {
        if(index + 1 > size || index < 0) {
            throw new IndexOutOfBoundsException("can not insert in index " + index);
        }
        if(index + 1 == size) addToEnd(obj);

        Container item = new Container(obj);

        if(index == 0) {
            this.addToFront(obj);
            return;
        }

        Container prev = this.getContainer(index-1);

        item.next = this.getContainer(index);
        prev.next = item;

        size++;
    }

    public void deleteByIndex(int index) {
        if(index + 1 > size || index < 0) {
            throw new IndexOutOfBoundsException("can not delete index " + index);
        }

        if(index == 0) {
            if(size == 1) {
                start = null;
                end = null;
            }else{
                start = this.getContainer(1);
            }

        }
        Container prev = this.getContainer(index-1);
    }

}