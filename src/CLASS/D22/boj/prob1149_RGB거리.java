package CLASS.D22.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob1149_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        StringTokenizer st;
        int home[][]=new int[n][3];
        int dp[][]=new int[n][3];

        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(in.readLine()," ");
            home[i][0]=Integer.parseInt(st.nextToken());
            home[i][1]=Integer.parseInt(st.nextToken());
            home[i][2]=Integer.parseInt(st.nextToken());
        }
        dp[0][0]=home[0][0];
        dp[0][1]=home[0][1];
        dp[0][2]=home[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0]=home[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1]=home[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2]=home[i][2]+Math.min(dp[i-1][0],dp[i-1][1]);
        }
        System.out.println(Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2])));

    }
}
