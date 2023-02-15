package CLASS.D7.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob9229_한빈이와SpotMart {
    public static void main(String[] args) throws IOException {
        BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        int t=Integer.parseInt(in.readLine());
        int tt=0;
        while(t>tt){
            st= new StringTokenizer(in.readLine()," ");
            int n=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            int arr[]=new int[n];
            st= new StringTokenizer(in.readLine()," ");
            for (int i = 0; i < n; i++) {
                arr[i]=Integer.parseInt(st.nextToken());
            }
            sb.append("#").append(++tt).append(" ");
            Arrays.sort(arr);
            if(arr[0]+arr[1]>w){
                sb.append(-1).append("\n");
                continue;
            }

            int max=0;
            int s=0,e=n-1;
            while(s!=e){
                if(arr[e]>w){
                    e--;
                    continue;
                }
                int m=arr[s]+arr[e];
                if(m==w){
                    max=m;
                    break;
                }
                else if(m>w){
                    e--;
                }
                else{
                    s++;
                    if(max<m)
                        max=m;
                }
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
