package Q2;

import java.util.HashMap;
import java.util.Map;

public class SuperFibs {
    private Map<Integer,Long> cache = new HashMap<>();
    public static int stepsCount = 1;

    public long getNthFib(int n) {
        if(cache.containsKey(n)) return cache.get(n);
        if(n<0) throw new IndexOutOfBoundsException();
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;

        cache.put(n,getNthFib(n-3) + getNthFib(n-2) + getNthFib(n-1));
        stepsCount++;
        return cache.get(n);
    }
}
