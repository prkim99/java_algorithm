package CLASS.D23.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob17070_파이프옮기기 {

    static int table[][];
    static int dp[][][];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(in.readLine());

        table = new int[n][n];

        dp = new int[n][n][3];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < n; j++) {

                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if(table[i][j]==1){
                    continue;
                }
                if (i == 0) {
                        dp[i][j][0] = dp[i][j - 1][0];
                }
                else{
                    dp[i][j][0]=dp[i][j-1][0]+dp[i][j-1][1];
                    dp[i][j][2]=dp[i-1][j-1][1]+dp[i-1][j][2];
                    if(table[i-1][j]+ table[i][j-1]==0){
                        dp[i][j][1]=dp[i-1][j-1][1]+dp[i-1][j-1][0]+dp[i][j-1][2];
                    }
                }
            }
        }
        System.out.println(dp[n-1][n-1][0]+dp[n-1][n-1][1]+dp[n-1][n-1][2]);
    }

}
