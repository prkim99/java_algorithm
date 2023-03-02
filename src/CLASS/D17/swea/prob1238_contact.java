package CLASS.D17.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;


public class prob1238_contact {

    static int n;
    static ArrayList<Integer> arr[]=new ArrayList[101];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();

        //int t=Integer.parseInt(in.readLine());
        int t=10;
        int tt=0;
        for (int i = 0; i < 101; i++) {
            arr[i]=new ArrayList<>();
        }
        while(t>tt){
            st = new StringTokenizer(in.readLine(), " ");
            n=Integer.parseInt(st.nextToken());
            int s=Integer.parseInt(st.nextToken());

            setArr();
            sb.append("#").append(++tt).append(" ");
            st=new StringTokenizer(in.readLine()," ");
            for (int i = 0; i < n/2; i++) {
                int val1=Integer.parseInt(st.nextToken());
                int val2=Integer.parseInt(st.nextToken());
                arr[val1].add(val2);
            }

           sb.append(BFS(s)).append("\n");
        }
        System.out.println(sb);
    }

    private static int BFS(int s) {
        Queue<Integer> q= new ArrayDeque<>();
        int depth[]=new int[101];
        q.offer(s);
        while(!q.isEmpty()){
            int node= q.poll();
            for (int i = 0; i < arr[node].size(); i++) {
                int cnode=arr[node].get(i);
                if(depth[cnode]==0&&cnode!=s){
                    depth[cnode]=depth[node]+1;
                    q.offer(cnode);
                }
            }
        }
        int mdepth=0,val=0;
        for (int i = 1; i < 101; i++) {
            if(mdepth<depth[i]){
                mdepth=depth[i];
                val=i;
            }
            else if(mdepth==depth[i]){
                val=i;
            }
        }
        return val;
    }

    private static void setArr() {
        for (int i = 1; i < 101; i++) {
            arr[i].clear();
        }
    }

}