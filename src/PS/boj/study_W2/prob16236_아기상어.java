package PS.boj.study_W2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class prob16236_아기상어 {



    static ArrayList<int[]> fish= new ArrayList<>();
    static int sea[][];

    static int baby,n,moveCnt;
    static int cnt, minsize;
    static int dx[]={0,0,1,-1};
    static int dy[]={1,-1,0,0};
    static boolean isPos(int x, int y){
        if(x<0||x>=n||y<0||y>=n){
            return false;
        }return true;
    }

    static void eat(int sx, int sy){
        Queue<int[]> q= new ArrayDeque<>();
        q.add(new int[]{sx,sy});
        int dist[][]=new int[n][n];
        while (!q.isEmpty()){
            int x=q.peek()[0];
            int y=q.peek()[1];
            q.remove();
            for(int i=0;i<4;i++){
                int xx=x+dx[i],yy=y+dy[i];
                if(isPos(xx,yy)&&dist[xx][yy]==0&&sea[xx][yy]<=baby&&!(xx==sx&&yy==sy)){
                    dist[xx][yy]=dist[x][y]+1;
                    if(dist[xx][yy]>minsize){
                        break;
                    }
                    if(sea[xx][yy]<baby&&sea[xx][yy]!=0){
                        fish.add(new int[]{xx,yy});
                        minsize=dist[xx][yy];
                    }
                    q.add(new int[]{xx,yy});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int shark1 = 0, shark2 = 0;
        n=Integer.parseInt(in.readLine());
        sea=new int [n][n];
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(in.readLine()," ");
            for (int j = 0; j < n; j++) {
                sea[i][j]=Integer.parseInt(st.nextToken());
                if(sea[i][j]==9){
                    shark1=i;
                    shark2=j;
                    sea[i][j]=0;
                }
            }
        }
        baby=2;
        minsize=400;

        eat(shark1, shark2);
        while (!fish.isEmpty()) {
            Collections.sort(fish, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0]==o2[0])
                        return o1[1]-o2[1];
                    else
                        return o1[0]-o2[0];
                }
            });
            shark1=fish.get(0)[0];
            shark2=fish.get(0)[1];
            fish.clear();
            sea[shark1][shark2]=0;
            cnt++;
            moveCnt+=minsize;
            minsize=400;
            if(baby==cnt){
                baby++;
                cnt=0;
            }
            eat(shark1, shark2);
        }
        System.out.println(moveCnt);
    }

}
