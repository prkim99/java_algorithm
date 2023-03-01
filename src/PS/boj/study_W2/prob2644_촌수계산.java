package PS.boj.study_W2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class prob2644_촌수계산 {


    static int dist[]=new int[101];
    static ArrayList<Integer> p[]=new ArrayList[101];
    static void DFS(int st, int fin){
        Stack<Integer> s= new Stack<>();
        s.push(st);
        while(!s.empty()){
            int node=s.peek();
            s.pop();
            for (int i = 0; i < p[node].size(); ++i) {
                if(dist[p[node].get(i)]==0&&p[node].get(i)!=st){
                    dist[p[node].get(i)]=dist[node]+1;
                    s.push(p[node].get(i));
                    if(p[node].get(i)==fin){
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n,k,v1,v2;
        n= Integer.parseInt(in.readLine());
        int a,b;
        st=new StringTokenizer(in.readLine()," ");
        a=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(in.readLine());
        for (int i = 0; i < n+1; i++) {
            p[i]=new ArrayList<>();
        }
        for (int i = 0; i < k; i++) {
            st=new StringTokenizer(in.readLine()," ");
            v1=Integer.parseInt(st.nextToken());
            v2=Integer.parseInt(st.nextToken());
            p[v1].add(v2);
            p[v2].add(v1);
        }
        DFS(a,b);
        if(dist[b]==0){
            System.out.println(-1);
        }
        else{
            System.out.println(dist[b]);
    }}
}
