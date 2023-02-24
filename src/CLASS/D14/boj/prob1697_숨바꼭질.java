package CLASS.D14.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class prob1697_숨바꼭질 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if(k<=n){
            System.out.println(n-k);
        }
        else {
            System.out.println(bfs(n, k));
        }
    }

    private static int bfs(int s,int fin) {
        Queue<Integer> q= new ArrayDeque<>();
        int depth[]= new int[100001];
        depth[s]=1;
        q.offer(s);
        while(!q.isEmpty()){
            int node= q.poll();
            int cnode[]={node-1,node+1,node*2};
            for (int i = 0; i < 3; i++) {
                if(0>cnode[i]||cnode[i]>100000) continue;
                if(cnode[i]==fin) return depth[node];
                if(depth[cnode[i]]==0||depth[cnode[i]]>depth[node]+1){
                    depth[cnode[i]]=depth[node]+1;
                    q.offer(cnode[i]);
                }
            }
        }
        return 0;
    }


}