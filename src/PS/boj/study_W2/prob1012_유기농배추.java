package PS.boj.study_W2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class prob1012_유기농배추 {
    static int field[][];
    static boolean visit[][];


    static int m,n;
    static int xd[]={0,0,1,-1};
    static int yd[]={1,-1,0,0};
    static boolean isPos(int i,int j){
        if(i<0||i>=n||j<0||j>=m){
            return false;
        }
        return true;
    }

    static void DFS(int i, int j){
        Stack<int[]> s=new Stack<>();
        s.push(new int[]{i,j});
        visit[i][j]=true;
        while(!s.empty()){
            i=s.peek()[0];
            j=s.peek()[1];
            s.pop();
            for (int k = 0; k < 4; ++k) {
                if(isPos(i+xd[k],j+yd[k])){
                    if(field[i+xd[k]][j+yd[k]]==1&&!visit[i+xd[k]][j+yd[k]]){
                        visit[i+xd[k]][j+yd[k]]=true;
                        s.push(new int[]{i+xd[k],j+yd[k]});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t=Integer.parseInt(in.readLine());
        int tt=0;
        while(t>tt){
            st= new StringTokenizer(in.readLine()," ");
            m=Integer.parseInt(st.nextToken());
            n=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());
            field=new int [n][m];
            visit=new boolean[n][m];
            ArrayList<int[]> cab=new ArrayList<>();
            for (int i = 0; i < k; i++) {
                st=new StringTokenizer(in.readLine()," ");
                int v1=Integer.parseInt(st.nextToken());
                int v2=Integer.parseInt(st.nextToken());
                field[v2][v1]=1;
                cab.add(new int[]{v2,v1});
            }
            int cnt=0;
            for (int i = 0; i < cab.size(); i++) {
                if(!visit[cab.get(i)[0]][cab.get(i)[1]]){
                    DFS(cab.get(i)[0],cab.get(i)[1]);
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
            tt++;
        }
        System.out.println(sb);
    }

}
