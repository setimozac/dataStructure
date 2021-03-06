package com.setimoart;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        System.out.println(fib(10));
//        System.out.println(fact(5));
//        System.out.println(power(2,3));
//        System.out.println(lowerHi("hiGhiHihihi"));
//        System.out.println(xToy("xyyybnsfxff"));
//        System.out.println(convertPi("olpikkpis"));
//        System.out.println(sevens(757758717));
//        System.out.println(repeatLastN("Hello", 4));
//        System.out.println(groupSum(0, new int[]{8}, 8));
//        System.out.println(array220(new int[]{2, 1, 10, 2}, 2));
        strDist("catcowcat", "cat");

//        int[][] data2D = {
//                {1, 3, 6, 8},
//                {7, 1, 2, 3},
//                {8, 3, 2, 1},
//                {1, 7, 1, 9},
//        };
//
//        int sum = Integer.MAX_VALUE;
//        String position = "";
//        for(int row=0;row<data2D.length;row++)
//            for (int col = 0; col < data2D[row].length; col++) {
//                if(sum > sumOfCross(data2D, row, col)) {
//                    sum = sumOfCross(data2D, row, col);
//                    position = "row: " + row + " " + " col: " + col;
//                }
//
//            }
//
//        System.out.printf("smallest sum is: %d - position is %s%n",sum, position);
//
//        int[][] dubArr = duplicateEmptyArray2D(data2D);
//        print2D(data2D);
//        System.out.println();
//        print2D(dubArr);
//
//        FibCached myFib = new FibCached();
//        System.out.println(myFib.getNthFib(4));
//        System.out.println(myFib);
//        System.out.println(myFib.getNthFib(70));
//        System.out.println(myFib);
    }

    public static int strDist(String str, String sub) {
        if(str.length() < sub.length()) return 0;
        if(str.startsWith(sub) && str.substring((str.length()-sub.length())).equals(sub)) return str.length();
        if(str.startsWith(sub)) return strDist(str.substring(0,str.length()-1), sub);

        return strDist(str.substring(1), sub);
    }


    public static boolean array220(int[] nums, int index) {

        if(index +1 == nums.length || nums.length == 0) return false;
        if(nums[index] * 10 == nums[index+1]) return true;

        return array220(nums,index+1);
    }

    public static boolean groupSum(int start, int[] nums, int target) {


        if (start >= nums.length) return (target == 0);
        if (groupSum(start + 1, nums, target - nums[start])) return true;
        if (groupSum(start + 1, nums, target)) return true;


        return false;

    }

    static int getIfExists(int[][] data, int row, int col) {
        // If exists, return the element, otherwise return 0
        try{ return data[row][col]; }
        catch (Exception ex) { return 0; }
    }

    static int sumOfCross(int[][] data, int row, int col) {
        // return sum of the element at row/col
        // plus (if they exist) element above, below, to the left and right of it
        return getIfExists(data,row,col) + getIfExists(data,row-1,col) + getIfExists(data,row+1,col)
                + getIfExists(data,row,col+1) + getIfExists(data,row,col-1);
    }

    // useful helper for debugging
    static void print2D(int[][] data) {
        for(int row=0;row<data.length;row++) {
            for (int col = 0; col < data[row].length; col++) {
                System.out.printf("%3d%s", data[row][col], col == (data[row].length - 1) ? "" : ",");
            }
            System.out.println();
        }
    }

    // duplicate a jagged array
    static int[][] duplicateEmptyArray2D(int[][] orig2d) {
        int[][] dupArr = new int[orig2d.length][orig2d[0].length];
//        int[][] dupArr = orig2d.clone();

        for(int row=0;row<orig2d.length;row++)
            for(int col=0;col<orig2d[row].length;col++)
                dupArr[row][col] = sumOfCross(orig2d,row,col);

        return dupArr;
    }

    // recursion for fibonacci
    private static int fib(int num) {

        if(num == 0) return 0;
        if(num == 1) return 1;

        return fib(num - 1) + fib(num - 2);
    }

    // recursion for factorielle
    public static int fact(int num) {
        if(num < 2) return 1;

        return num * fact(num-1);
    }

    public static int power(int num1, int num2) {
        if(num2 == 0) return 1;
        if(num2 == 1) return num1;

        return num1 * power(num1, (num2 - 1));
    }

    public static int lowerHi(String str) {
        if(str.length() < 2) return 0;

        if(str.charAt(0) == 'h')
            if(str.charAt(1) == 'i'){
                return 1 + lowerHi(str.substring(2)) ;
            }

        return lowerHi(str.substring(1)) ;
    }

    public static String xToy(String str) {

        if(str.length() == 0) {
            return str;
        }

        if(str.charAt(0) == 'x')
            return 'y' + xToy(str.substring(1));

        return str.charAt(0)+xToy(str.substring(1));
    }

    public static String convertPi(String str) {

        if(str.length() < 2) return str;

        if(str.charAt(0) == 'p')
            if(str.charAt(1) == 'i')
                return "3.14" + convertPi(str.substring(2));

            return str.charAt(0) + convertPi(str.substring(1));
    }

    public static int sevens(int num) {
        if(num < 7) return 0;
        if(num % 10 == 7)
            return 1 + sevens(num / 10);

        return sevens(num / 10);
    }

    public static String repeatLastN(String str, int num) {
        String st = "";
        for (int i = 0; i < num; i++) {
            st += str.substring(str.length()-num);
        }
        return st;
    }
}
