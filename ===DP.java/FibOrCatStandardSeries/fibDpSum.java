public class fibDpSum {
    // Best Fib Method 
static Map<Long, Long> memo = new HashMap<>();
    
public static long fibMemo(long x) {
    if (x == 0L || x == 1L) {
        return x;
    }
    
    if (memo.containsKey(x)) {
        return memo.get(x);
    }
    
    long result = fibMemo(x - 1) + fibMemo(x - 2);
    memo.put(x, result);
    return result;
}

// M2 --> Iterative Way 
static Map<Long, Long> memo2 = new HashMap<>();

public static long Iterafib(long x) {
    memo2.put(0L, 0L);
    memo2.put(1L, 1L);

    for (long i = 2; i <= x; i++) {
        long result = memo2.get(i - 1) + memo2.get(i - 2);
        memo2.put(i, result);
    }

    return memo2.get(x);
}
}
