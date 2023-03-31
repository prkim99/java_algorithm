package CLASS.D24.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob12865_평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(in.readLine()," ");;
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        int w[]=new int[n+1];
        int v[]=new int[n+1];
        for (int i = 1; i <= n; i++) {
            st=new StringTokenizer(in.readLine()," ");
            w[i]=Integer.parseInt(st.nextToken());
            v[i]=Integer.parseInt(st.nextToken());
        }

        int[][] dp=new int[n+1][k+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < k+1; j++) {
                if(j>=w[i]){
                    dp[i][j]=Math.max(dp[i-1][j],v[i]+dp[i-1][j-w[i]]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}

