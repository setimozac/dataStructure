package com.setimoart;

import java.util.Random;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int size = 0;
        Random rand = new Random();
        StringJoiner nums = new StringJoiner(", ");
        String prime = "";

        try{
            System.out.println("insert the size for an array: ");
            size = sc.nextInt();
        }
        catch (Exception ex) {
            System.out.println("array size is not numeric!");
            return;
        }
        if(size > 1) {
            int[] myArray = new int[size];

            for(int i=0; i<myArray.length;i++) {
                myArray[i] = rand.nextInt(100);
            }

            IntStream.of(myArray).forEach(x -> nums.add(String.valueOf(x)));
            System.out.println(nums.toString());

            for(int i : myArray) {
                if(isPrime(i)) {
                    prime += (i + ", ");
                }

            }
            System.out.println(prime.substring(0, prime.length()-2));

        }
        else{
            System.out.println("size must be greater than 0");
            return;
        }

    }

    public static boolean isPrime(int num) {
        for(int i=2;i<num;i++){
            if((num % i) == 0) {
                return false;
            }

        }
        return true;

    }
}
