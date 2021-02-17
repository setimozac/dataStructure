package com.setimoart;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MyLinkList<T> {
    private Container start, end;
    private int size;

    public MyLinkList() {
        size = 0;
        start = null;
        end = null;
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

    public int getSize() {
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
        if(index  > size || index < 0) {
            throw new IndexOutOfBoundsException("can not insert in index " + index);
        }
        if(index  == size) addToEnd(obj);

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
            size --;
            return;
        }

        Container prev = this.getContainer(index-1);

        if(prev.getNext() == end) {
            end = prev;
            prev.setNext(null);
        }
        else{
            prev.setNext(prev.getNext().getNext());
        }
        size --;
    }

    public boolean deleteByValue(T value) {
        for(int i=0;i<size;i++) {
            if(value.equals(this.get(i))) {
                this.deleteByIndex(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String str = "";
        str += "[";
        for(int i=0;i<size;i++) {
            str += this.get(i);
            if(i+1 != size) {
                str += ", ";
            }
        }
        str+= "]";
        return str;
    }

    public List<T> toArray() {

        List<T> arr = new ArrayList<>();
        for(int i=0;i<size;i++) {
            arr.add(this.get(i));
        }
        return arr;
    }


}
