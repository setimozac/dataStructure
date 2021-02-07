package com.setimoart;

public class MyArray {
    private int[] data;
    private int size = 0;

    public MyArray() {
        data = new int[1];
    }

    public int size() {
        return this.size;
    }

    // helper method - increases the length of the array.
    private void increaseSize() {
        int[] aux = data.clone();
        data = new int[aux.length * 2];
        for(int i=0; i<aux.length;i++) {
            data[i] = aux[i];
        }
    }

    // helper method - remove item by index - being used in 'deleteByIndex()' and 'deleteByValue()'
    private boolean remove(int index) {

        try{
            while(index < this.size - 1) {
                this.data[index] = this.data[index + 1];
                index++;
            }
            size--;
        }
        catch (Exception ex) {
            return false;
        }
        return true;
    }

    public void add(int value) {
        if(this.data.length <= this.size + 1) {
            increaseSize();
        }
        this.data[size] = value;
        size++;
    }

    // may throw IndexOutOfBoundsException
    public int get(int index) {
        if(index >= this.size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return this.data[index];
    }

    public void deleteByIndex(int index) {

        if(index >= this.size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        remove(index);
    }

    public boolean deleteByValue(int value) {
        for(int i=0; i<this.data.length;i++) {
            if(this.data[i] == value){
                return remove(i);
            }
        }
        return false;
    }

    public void insertValueAtIndex(int value, int index) {
        if(index >= this.size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        if(this.data.length <= this.size + 1) {
            increaseSize();
        }
        for(int i=size-1;i >= index;i--) {
            this.data[i+1] = this.data[i];
        }
        this.data[index] = value;
        size++;
    }

    // may throw IndexOutOfBoundsException
    public int[] getSlice(int startIdx, int length) {
        if(startIdx+length > this.size ) throw new IndexOutOfBoundsException("This range is out of bounds");
        if(startIdx < 0 ) throw new IndexOutOfBoundsException("Index must be greater than or equal to Zero");
        int[] result = new int[length];
        int count = 0;
        for(int i=startIdx; i<startIdx+length;i++) {
            result[count] = this.data[i];
            count++;
        }
        return result;
    }

    public void clear() {
        this.data = new int[this.data.length];
        size = 0;
    }

    @Override  // returns String similar to: [3, 5, 6, -23]
    public String toString() {

        String[] str = new String[size];
        for(int i=0;i<this.size;i++){
            str[i] = Integer.toString(this.data[i]);
        }

        return "[" + String.join(", ",str ) + "]";
    }
}
