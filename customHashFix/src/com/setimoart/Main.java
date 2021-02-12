package com.setimoart;

public class Main {

    public static void main(String[] args) {
        CustomeHashMapString hash = new CustomeHashMapString();
        hash.putValue("1", "a");
        hash.putValue("2", "b");
        hash.putValue("3", "c");
        hash.putValue("4", "d");
        hash.putValue("5", "e");
        hash.putValue("6", "f");
        hash.putValue("7", "g");
        hash.putValue("8", "h");
        hash.putValue("9", "i");
        hash.putValue("10", "j");
        hash.putValue("11", "k");
        hash.putValue("12", "456");



        System.out.println("--------------");
        //hash.printDebug();
        System.out.println(hash);
    }
}
