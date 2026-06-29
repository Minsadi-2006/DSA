public class RabbitProblem {
    public static long fibRecursive(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public static long fibMemo(int n, long[] memo) {
    
        if (n == 1) return 1;
        if (n == 2) return 1;

     
        if (memo[n] != 0) {
            return memo[n];  
        }
        memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
        return memo[n];
    }
    public static long fibIterative(int n) {
        if (n == 1 || n == 2) return 1;

        long prev2 = 1;  
        long prev1 = 1;  
        long current = 0;

        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;  
            prev2 = prev1;           
            prev1 = current;
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci sequence (month 1 to 15):");
        System.out.print("  Months: ");
        for (int i = 1; i <= 15; i++) System.out.printf("%5d", i);
        System.out.println();
        System.out.print("  Pairs:  ");
        for (int i = 1; i <= 15; i++) System.out.printf("%5d", fibIterative(i));
        System.out.println("\n");
        int testMonth = 10;
        System.out.println("Testing month " + testMonth + " using all 3 approaches:");
        long result1 = fibRecursive(testMonth);
        System.out.println("  1. Recursive  → " + result1 + " pairs");
        long[] memo = new long[testMonth + 1];   
        long result2 = fibMemo(testMonth, memo);
        System.out.println("  2. Memoized   → " + result2 + " pairs");
        long result3 = fibIterative(testMonth);
        System.out.println("  3. Iterative  → " + result3 + " pairs");

        System.out.println("\nAll three give the same answer: "
            + (result1 == result2 && result2 == result3 ? "YES ✓" : "NO ✗"));
        System.out.println("\nLarge n tests (Iterative, fast):");
        int[] bigTests = {20, 30, 40, 50};
        for (int n : bigTests) {
            System.out.println("  Month " + n + " → " + fibIterative(n) + " pairs");
        }
        System.out.println("\nStep-by-step rabbit growth (first 8 months):");
        String[] explanations = {
            "1 newborn pair (original, not mature)",
            "1 mature pair  (no babies yet)",
            "1 mature + 1 new baby = 2 pairs",
            "2 mature + 1 new baby = 3 pairs",
            "3 mature + 2 new babies = 5 pairs",
            "5 mature + 3 new babies = 8 pairs",
            "8 mature + 5 new babies = 13 pairs",
            "13 mature + 8 new babies = 21 pairs"
        };
        for (int i = 1; i <= 8; i++) {
            System.out.printf("  │   %2d  │ %-42s │%n", i, explanations[i - 1]);
        }
        System.out.println("\nPattern: f(n) = f(n-1) + f(n-2)  [Fibonacci sequence]");
    }
}
