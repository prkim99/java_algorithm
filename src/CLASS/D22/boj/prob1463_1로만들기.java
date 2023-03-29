package CLASS.D22.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob1463_1로만들기
{
    static int dp[];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        StringTokenizer st;

        n=Integer.parseInt(in.readLine());

        dp=new int[n+1];
        dp[1] = 0;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
            }
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
            }
        }
        System.out.println(dp[n]);
    }

}
