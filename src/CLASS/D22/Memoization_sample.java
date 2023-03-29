package CLASS.D22;

import java.util.Arrays;
import java.util.Scanner;

public class Memoization_sample {

    private static long[] memo;

    private static long fibo2(int n) {
        if (memo[n] == -1) {
            memo[n] = fibo2(n - 1) + fibo2(n - 2);
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        memo = new long[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;

        System.out.println(fibo2(n));

    }
}
