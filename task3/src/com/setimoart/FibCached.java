package com.setimoart;

import java.util.ArrayList;

public class FibCached {
    FibCached() {
        fibsCached.add(0L); // #0
        fibsCached.add(1L); // #1
    }

    private ArrayList<Long> fibsCached = new ArrayList<>(); // NOT a HashMap !
    private int fibsCompCount = 2;
    // in a correct caching implementation fibsCompCount will end up the same as fibsCached.size();

    public long getNthFib(int n) {
        if(n <= fibsCompCount)
            return fibsCached.get(n-1);
        return computeNthFib(n);
    }

    // You can find implementation online, recursive or non-recursive.
    // For 100% solution you should use values in fibsCached as a starting point
    // instead of always starting from the first two values of 0, 1.
    private long computeNthFib(int n) {
        while(n > fibsCompCount) {
            fibsCached.add(fibsCached.get(fibsCompCount - 2) + fibsCached.get(fibsCompCount - 1));
            fibsCompCount++;
        }
        return fibsCached.get(fibsCompCount - 1);
    }

    // You are allowed to add another private method for fibonacci generation
    // if you want to use recursive approach. I recommend non-recursive though.

    // How many fibonacci numbers has your code computed as opposed to returned cached?
    // Use this in your testing to make sure your caching actually works properly.
    public int getCountOfFibsComputed() { return fibsCompCount; }

    @Override
    public String toString() {
        String str = "";
        for(long fib : fibsCached)
            str += (fib + ", ");
        return  str.substring(0,str.length() - 2);
    } // returns all cached Fib values, comma-space-separated on a single line
}
