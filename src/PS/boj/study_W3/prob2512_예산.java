package PS.boj.study_W3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob2512_예산 {

    public static void main(String[] args) throws IOException {
        int m,n,val;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        n=Integer.parseInt(in.readLine());
        st= new StringTokenizer(in.readLine()," ");
        int v[]=new int [n];
        for (int i = 0; i < n; i++) {
            v[i]=Integer.parseInt(st.nextToken());
        }
        m=Integer.parseInt(in.readLine());
        Arrays.sort(v);
        long len=v[0];
        long sum=0;
        long s=1,e=v[n-1];
        e++;
        while(s<e){
            sum=0;
            for (int i = 0; i < n; ++i) {
                if(v[i]>len){
                    sum+=len;
                }
                else{
                    sum+=v[i];
                }
            }
            if(sum<=m){
                s=len+1;
                len=(s+e)/2;
            }
            else{
                e=len;
                len=(s+e)/2;
            }
        }
        System.out.println(s-1);

    }
}

