package CLASS.D3.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob11660_구간합구하기5 {

    static int arr[][]= new int[1025][1025];
    public static void main(String[] args) throws IOException {
        BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st=new StringTokenizer(in.readLine()," ");
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());


        for (int i = 1; i <= n; i++) {
            st=new StringTokenizer(in.readLine()," ");
            for (int j = 1; j <= n; j++) {
                arr[i][j]=arr[i][j-1]+arr[i-1][j]-arr[i-1][j-1]+Integer.parseInt(st.nextToken());
            }
        }
        int x1,x2,y1,y2;
        int tt=0;
        while(m>tt){
            st=new StringTokenizer(in.readLine()," ");
            x1=Integer.parseInt(st.nextToken());
            y1=Integer.parseInt(st.nextToken());
            x2=Integer.parseInt(st.nextToken());
            y2=Integer.parseInt(st.nextToken());
            int total=arr[x2][y2]-arr[x2][y1-1]-arr[x1-1][y2]+arr[x1-1][y1-1];
            System.out.println(total);
            tt++;
        }
    }
}
