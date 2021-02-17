package com.setimoart;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Hash<Integer, String> dic = new Hash<>(2);
        dic.add(1, "moe");
        dic.add(2, "Seti");
        dic.add(1, "Andrew");
        System.out.println(dic.getValue(2));
    }
}
