package CLASS.D16.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class prob329_서로소집합 {

    static int[] par;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();

        int t=Integer.parseInt(in.readLine());
        //int t=1;
        int tt=0;
        while(t>tt){
            st = new StringTokenizer(in.readLine(), " ");
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            par=new int[n+1];
            setPar(n);
            ++tt;
            sb.append("#").append(++tt).append(" ");
            for (int i = 0; i < m; i++) {
                st=new StringTokenizer(in.readLine()," ");
                int op=Integer.parseInt(st.nextToken());
                int val1=Integer.parseInt(st.nextToken());
                int val2=Integer.parseInt(st.nextToken());

                if(op==1){
                    if(finding(val1)==finding(val2)){
                        sb.append("1");
                    }
                    else sb.append("0");
                }
                else{
                    union(val1,val2);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void setPar(int n) {
        for (int i = 1; i <n+1 ; i++) {
            par[i]=i;
        }
    }

    private static void union(int a, int b) {
        int pa=finding(a);
        int pb=finding(b);
        if(pa!=pb){
            par[pa]=pb;}
    }
    private static int finding(int a) {
        if(par[a]==a) return a;
        else{
            return par[a]=finding(par[a]);
        }
    }
}