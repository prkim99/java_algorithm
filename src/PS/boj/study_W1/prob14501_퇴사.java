package PS.boj.study_W1;

import java.io.*;
import java.util.StringTokenizer;

public class prob14501_퇴사 {
    static int d_info[]= new int[15];
    static int m_info[]= new int[15];
    static int dp[]= new int [20];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st ;
        int n=Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(in.readLine()," ");
            d_info[i]=Integer.parseInt(st.nextToken());
            m_info[i]=Integer.parseInt(st.nextToken());
        }

        dp[d_info[0]-1]=m_info[0];
        for (int i = 1; i < n; i++) {
            dp[i+d_info[i]-1]=Math.max(dp[i+d_info[i]-1],dp[i-1]+m_info[i]);
            dp[i]=Math.max(dp[i],dp[i-1]);
        }
        int profit=0;
        for (int i = 0; i < n; i++) {
            if(dp[i]>profit){
                profit=dp[i];
            }
        }
        System.out.println(profit);
    }

}
