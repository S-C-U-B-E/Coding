package dynamicprogramming.december_2024;

import java.util.Arrays;
import java.util.Scanner;

public class DP1_Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = sc.nextInt();  // Considering 1 based indexing for the series itself

        System.out.print(0 + " "  + 1 + " ");
        int ans = fibonacciRecursive(n); // returning the 3rd number in the series.
        System.out.println("\n recursion : "+ ans);

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[1] = 0;
        dp[2] = 1;
        System.out.print("\n" + 0 + " "  + 1 + " ");
        ans = fibonacciMemoizedrecursion(n , dp);
        System.out.println("\n fibonacciMemoizedrecursion : "+ ans);

        dp = new int[n+1];
        dp[1] = 0;
        dp[2] = 1;
        System.out.print("\n" + 0 + " "  + 1 + " ");
        fibonacciTopDown(n , dp);
        System.out.println("\n fibonacciTopDown : "+ dp[n]);

    }

    private static int fibonacciRecursive(int n){
      if(n == 2)
          return 1;
      if(n == 1)
          return 0;

      int fiboNum = fibonacciRecursive(n -1) + fibonacciRecursive(n - 2);
        System.out.print(fiboNum + " "); // If I print it here, the output will not be correct since it will also print values for those states whose answer has already been calculated previously and since this is not a memoized soln. it will print them too.
        return fiboNum;
    }

    private static int fibonacciMemoizedrecursion(int n , int[] dp){
        if(dp[n] != -1)
            return dp[n];

        if(n == 1)
            return dp[1];
        if(n == 2)
            return dp[2];

        dp[n] = fibonacciMemoizedrecursion(n-1 , dp) + fibonacciMemoizedrecursion(n-2 , dp);
        System.out.print(dp[n] + " ");
        return dp[n];
    }

    private static void fibonacciTopDown(int n , int[] dp){
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
            System.out.print(dp[i] + " ");
        }
    }
}
