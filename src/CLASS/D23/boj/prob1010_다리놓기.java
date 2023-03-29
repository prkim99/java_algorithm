package CLASS.D23.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob1010_다리놓기 {

    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(in.readLine());
        int tt=0;

        while(t>tt){
            int n,m;
            StringTokenizer st=new StringTokenizer(in.readLine()," ");
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());

            if(n>m){
                calcComb(n, m);
            }
            else if(n<m){
                int[][]b=new int[n+1][m+1];
                calcComb(m, n);
            }
            else{
                cnt=1;
            }
            System.out.println(cnt);
            cnt=0;
            tt++;
        }
    }

    private static void calcComb(int n, int m) {
        if(m>n-m) m=n-m;
        int[][]b=new int[n+1][m+1];
        for (int i = 0; i <=n; i++) {
            for (int j = 0, end= Math.min(i,m);j<=end; j++) {
                if(j==0||i==j)
                    b[i][j]=1;
                else b[i][j]=b[i-1][j-1]+b[i-1][j];
            }
        }
        cnt=b[n][m];
    }
}
