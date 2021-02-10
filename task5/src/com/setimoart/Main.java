package com.setimoart;

public class Main {

    public static void main(String[] args) {
	    MyLinkList<String> list = new MyLinkList<>();
	    list.addToFront("hi");
	    list.get(0);
        System.out.println(list.get(0));
        list.addToFront("bye");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println();
        list.addToFront("Hey");
        System.out.println(list.get(0));
        System.out.println(list.get(1));

        System.out.println();
        list.insertValueAtIndex(1,"Moe");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));

        System.out.println();
        list.addToEnd("www");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println(list.getSize());

        System.out.println();
        list.deleteByIndex(4);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.getSize());

        System.out.println();
        System.out.println(list.deleteByValue("byee"));
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.getSize());

        System.out.println(list);


        for(String i:list.toArray()) {
            System.out.println(i);
        }
    }
}
