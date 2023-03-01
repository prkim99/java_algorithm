package PS.boj.study_W3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class prob2470_두용액 {

    public static void main(String[] args) throws IOException {
        int m,n;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n=Integer.parseInt(in.readLine());

        int v[]= new int[n];

        st=new StringTokenizer(in.readLine()," ");
        for (int i = 0; i < n; i++) {
            v[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(v);
        int s=0,e=n-1;
        int ss=0,ee=0;
        int min=2000000000;

        while(s<e){
            int sum=v[s]+v[e];
            if(Math.abs(sum)<min){
                min=Math.abs(sum);
                ss=s;
                ee=e;
                if(min==0)break;
            }
            if(Math.abs(v[s])<Math.abs(v[e])){
                e--;
            }
            else{
                s++;
            }
        }
        sb.append(v[ss]).append(" ").append(v[ee]);
        System.out.println(sb);

    }
}

