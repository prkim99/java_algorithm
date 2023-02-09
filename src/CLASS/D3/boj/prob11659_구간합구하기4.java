package CLASS.D3.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob11659_구간합구하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st= new StringTokenizer(in.readLine()," ");
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int arr[]=new int[n+1];
        st=new StringTokenizer(in.readLine()," ");
        for (int i = 1; i < n+1; i++) {
            arr[i]=arr[i-1]+Integer.parseInt(st.nextToken());
        }
        int tt=0;
        while(m>tt){
            st=new StringTokenizer(in.readLine()," ");
            int i,j;
            i=Integer.parseInt(st.nextToken());
            j=Integer.parseInt(st.nextToken());

            System.out.println(arr[j]-arr[i-1]);
            tt++;
        }
    }
}
