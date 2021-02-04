package com.setimoart;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static int width;
    public static int height;
    public static int[][] myArr;
    public static Random rand = new Random();

    public static void main(String[] args) {
        try{
            System.out.println("Insert the Width of your array: ");
            width = sc.nextInt();
            System.out.println("Insert the Height of your array: ");
            height = sc.nextInt();

            if(width < 1 || height < 1) throw new IllegalArgumentException("eidht and height must be greater than 0");

            myArr = new int[width][height];

            for(int i=0;i<width;i++)
                for(int j=0;j<height;j++) {
                    myArr[i][j] = rand.nextInt(99 + 99) -99;
                }

            showNumbers();
            int sum = showSum();
            showSumRow();
            showSumColumn();
            StandardDeviation(sum);
            sumOfPrimes();
        }
        catch(IllegalArgumentException ex) {
            System.out.println(ex);
            return;
        }


    }

    private static void sumOfPrimes() {
        System.out.println();
        for (int i=0;i<myArr.length;i++)
            for(int j=0;j<myArr[i].length;j++)
                for(int k=i; k<myArr.length;k++)
                    for(int t=j; t<myArr[i].length;t++){
                        if(t == j) continue;
                        if(IsPrime(myArr[i][j] + myArr[k][t])){
                            System.out.printf("%3d + %3d = %3d %n",myArr[i][j], myArr[k][t], myArr[i][j] + myArr[k][t]);
                        }
                    }
    }

    private static boolean IsPrime(int num) {
        if(num < 2) return false;
        for(int i=2;i<= num/2;i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    private static void StandardDeviation(int sum) {
        System.out.println();
        double x = sum/(width*height);
        int a = 0;
        for (int i=0;i<myArr.length;i++)
            for(int j=0;j<myArr[i].length;j++)
                a += Math.pow(((myArr[i][j]) - x),2);

        System.out.println("Standard deviation is: " + Math.sqrt(a/((width*height)-1)));

    }

    private static void showSumColumn() {
        int sum = 0;
        System.out.println();
        for(int i=0;i<height;i++) {
            for (int j = 0; j < myArr.length; j++) {
                sum += myArr[j][i];
            }
            System.out.println("sum of the column " + i + ": " + sum);
            sum = 0;
        }
    }

    private static void showSumRow() {
        int sum = 0;
        System.out.println();
        for(int i=0;i<myArr.length;i++){
            System.out.print("sum of row " + i + ": ");
            for(int j=0;j<myArr[i].length;j++)
                sum += myArr[i][j];
            System.out.println(sum);
            sum = 0;
        }
    }

    private static int showSum() {
        int sum = 0;
        for (int i=0;i<myArr.length;i++)
            for(int j=0;j<myArr[i].length;j++)
                sum += myArr[i][j];
        System.out.println();
        System.out.println("sum of all the numbers is: " + sum);
        return sum;
    }

    private static void showNumbers() {
        System.out.println();
        for(int i=0;i<myArr.length;i++) {

            for(int j=0;j<myArr[i].length;j++) {
                System.out.printf("%3d%s",myArr[i][j],myArr[i][j] == myArr[i][(myArr[i].length)-1]?"":",");
            }
            System.out.println();
        }

    }
}
