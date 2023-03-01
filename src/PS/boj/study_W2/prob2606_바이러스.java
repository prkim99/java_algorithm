package PS.boj.study_W2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class prob2606_바이러스 {

    //vector<int> network[100];
    static ArrayList<Integer>[] network;
    static boolean visit[];
   static int cnt;
    static void BFS(int st){
        Queue<Integer> q= new ArrayDeque<>();
        q.add(st);

        visit[st]=true;
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            for (int i = 0; i < network[node].size(); ++i) {
                if(!visit[network[node].get(i)]){
                    visit[network[node].get(i)]=true;
                    cnt++;
                    q.add(network[node].get(i));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n,v;
        n=Integer.parseInt(in.readLine());
        v=Integer.parseInt(in.readLine());
        network=new ArrayList[n+1];
        visit=new boolean[n+1];
        for(int i = 0; i < n+1; i++){
            network[i] = new ArrayList<>();
        }
        for (int i = 0; i < v; i++) {
            st= new StringTokenizer(in.readLine()," ");
            int v1=Integer.parseInt(st.nextToken());
            int v2=Integer.parseInt(st.nextToken());
            network[v1].add(v2);
            network[v2].add(v1);
        }
        BFS(1);
        System.out.println(cnt);
    }

}
