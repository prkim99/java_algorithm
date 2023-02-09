package PS.boj.study_W1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class prob10971_외판원순회2 {
    static  int n;
    static int fee=-1;
    static ArrayList<ArrayList<Integer>> road=new ArrayList<>();
    //static ArrayList<Stack<Integer>> ss= new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st ;
        n=Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(in.readLine()," ");
            road.add(new ArrayList<Integer>());
            for (int j = 0; j < n; j++) {
                road.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 0; i < n; i++) {
            int visit[]=new int[n];
            visit[i]=1;
            Backtracking(i,i,2,0,visit);
        }
        System.out.println(fee);
    }

    static void Backtracking(int st, int node, int cnt, int cost, int visit[]) {
        if(cnt==n+1){
            if(road.get(node).get(st)!=0){
                if (fee==-1||cost+road.get(node).get(st)<fee){
                    fee=cost+road.get(node).get(st);
                }
            }
            return;
        }
        for (int i = 0; i < road.get(node).size(); ++i) {
            if(road.get(node).get(i)!=0){
                if (visit[i]==0){
                    visit[i]=cnt;
                    Backtracking(st,i,cnt+1,cost+road.get(node).get(i),visit);
                    visit[i]=0;
                }}
        }
    }
}
