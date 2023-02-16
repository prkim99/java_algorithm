package CLASS.D8.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class prob1861_정사각형방 {

    static int arr[][];
    static boolean visit[][];
    static int dy[]={0,1,0,-1};
    static int dx[]={1,0,-1,0};
    static int n;
    static  int max,mx,my;
    static public class Pair<F, S>{
        F first;
        S second;

        Pair(F first, S second){
        	this.first = first;
            this.second = second;
        }
    }
    static boolean isPos(int x, int y){ //범위 내 있는지 확인
        if(x >= 0 && y < n && x < n && y >=0){
            return true;
        }
        return false;
    }
    static void dfs(int sx, int sy) {
        Stack<Pair<Integer,Integer>> s = new Stack<>();
        s.add(new Pair(sx,sy));
        visit[sx][sy]=true;
        int cnt=0;
        while(!s.isEmpty()){
            int x=s.peek().first;
            int y=s.peek().second;
            s.pop();
            cnt++;
            if(cnt>max){
                max=cnt;
                mx=sx;
                my=sy;
            }
            if(cnt==max){
                if(arr[mx][my]>arr[sx][sy]){
                    max=cnt;
                    mx=sx;
                    my=sy;
                }
            }


            for (int k = 0; k < 4; k++) {
                int nx=x+dx[k];
                int ny=y+dy[k];
                if(isPos(nx,ny)&&arr[nx][ny]==(arr[x][y]+1)){
                    visit[nx][ny]=true;
                    s.push(new Pair<>(nx,ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(in.readLine());
        int tt = 0;
        while (t > tt) {
           n = Integer.parseInt(in.readLine());
            arr=new int[n][n];
            visit=new boolean[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            max=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(!visit[i][j]){
                        dfs(i,j);
                    }
                }
            }
            sb.append("#").append(++tt).append(" ").append(arr[mx][my]).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}

