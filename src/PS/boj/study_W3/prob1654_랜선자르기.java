package PS.boj.study_W3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob1654_랜선자르기 {

    public static void main(String[] args) throws IOException {
        int k,n,val;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st= new StringTokenizer(in.readLine()," ");
        k=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());

        int v[]=new int [k];
        for (int i = 0; i < k; i++) {
            v[i]=Integer.parseInt(in.readLine());
        }
        Arrays.sort(v);
        int index=k-1;
        long cnt=0L;
        long s=1L, e=v[index];
        e++;
        long len=(s+e)/2;
        while(s<e){
            cnt=0;
            for (int i = 0; i < k; i++) {
                cnt+=v[i]/len;
            }
            if(cnt>=n){
                s=len+1;
                len=(s+e)/2;
            }
            else {
                e=len;
                len=(s+e)/2;
            }
        }
        System.out.println(s-1);

    }
}
