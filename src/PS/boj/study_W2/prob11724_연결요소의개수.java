package PS.boj.study_W2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class prob11724_연결요소의개수 {


    static ArrayList<Integer>[] edge= new ArrayList[1001];
    static boolean visit[]=new boolean[1001];
    static void DFS(int node){
        Stack<Integer> s= new Stack<>();
        s.push(node);
        visit[node]=true;
        while(!s.empty()){
            node=s.peek();
            s.pop();
            for (int i = 0; i < edge[node].size(); ++i) {
                if(!visit[edge[node].get(i)]){
                    s.push(edge[node].get(i));
                    visit[edge[node].get(i)]=true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(in.readLine()," ");
        StringBuilder sb = new StringBuilder();
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int v1,v2;
        for (int i = 0; i < n+1; i++) {
            edge[i]=new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(in.readLine()," ");
            v1=Integer.parseInt(st.nextToken());
            v2=Integer.parseInt(st.nextToken());
            edge[v1].add(v2);
            edge[v2].add(v1);
        }
        int cnt=0;
        for (int i = 1; i <= n; ++i) {
            if(!visit[i]){
                DFS(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}
