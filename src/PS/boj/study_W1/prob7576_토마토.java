package PS.boj.study_W1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class prob7576_토마토 {
    public static class Pair<F, S>{
        F first;
        S second;

        Pair(F first, S second){
        	this.first = first;
            this.second = second;
        }
    }
static int box[][]= new int [1000][1000];
static boolean visit[][]=new boolean[1000][1000];
static ArrayList<Pair<Integer,Integer>> ripen=new ArrayList<>();
static ArrayList<Pair<Integer,Integer>> new_ripen=new ArrayList<>();
static int n, m,tomato;

static boolean isFin(int cnt){
    if(tomato==cnt)return false;
    return true;
}
    static void oneDay(int i, int j) {
        if (i > 0 &&!visit[i-1][j]) {
            if (box[i - 1][j] == 0) {
                box[i - 1][j] = 1;
                new_ripen.add(new Pair<>(i-1,j));
            }
        }
        if ( j < m - 1 && !visit[i][j + 1]) {
            if (box[i][j+1] == 0) {
                box[i][j+1] = 1;
                new_ripen.add(new Pair<>(i,j+1));
            }
        }
        if (i < n-1 && !visit[i + 1][j]) {
            if (box[i + 1][j] == 0) {
                box[i + 1][j] = 1;
                new_ripen.add(new Pair<>(i+1,j));
            }
        }
        if (j >0 && !visit[i][j - 1]) {
            if (box[i ][j-1] == 0) {
                box[i ][j-1] = 1;
                new_ripen.add(new Pair(i,j-1));
            }
        }
        visit[i][j] = true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in= new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(in.readLine()," ");
        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++)
        {
            st=new StringTokenizer(in.readLine()," ");
            for (int j = 0; j < m; j++)
            {
                box[i][j]=Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    ripen.add(new Pair<>(i,j));
                }
                if (box[i][j] != -1) {
                    tomato++;
                }
            }
        }
        int cnt = 0;
        int last_day = ripen.size();
        while (isFin(last_day)) {

            for (int i = 0; i < ripen.size(); i++)
            {
                if (!visit[ripen.get(i).first][ripen.get(i).second]) {
                    oneDay(ripen.get(i).first, ripen.get(i).second);
                }
            }
            ripen=new ArrayList<>(new_ripen);
            new_ripen.clear();
            cnt++;
            if (ripen.size()==0) {
                System.out.println(-1);
                return ;
            }
            last_day += ripen.size();
        }
        System.out.println(cnt);
        return;
    }
}
