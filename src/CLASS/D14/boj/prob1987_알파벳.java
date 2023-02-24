package CLASS.D14.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class prob1987_알파벳 {

    static boolean isSel[]= new boolean[26];
    static char arr[][];
    static int max=0,r,c;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr=new char[r][c];

        for (int i = 0; i < r; i++) {
            String str=in.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j]=str.charAt(j);
            }
        }
        isSel[arr[0][0]-'A']=true;
        search(0,0,0);
        System.out.println(max+1);
    }
    static int dx[]={0,0,1,-1};
    static int dy[]={1,-1,0,0};
    static boolean isOk(int x, int y, int dir){
        if(dir==0&&y>=c)return false;
        else if(dir==1&&y<0) return false;
        else if(dir==2&&x>=r)return false;
        else if(dir==3&&x<0)return false;
        return true;
    }
    private static void search(int x,int y,int cnt) {
        if(cnt>max){
            max=cnt;
        }
        for (int i = 0; i < 4; i++) {
            int mx=x+dx[i];
            int my=y+dy[i];
            if(isOk(mx,my,i)&&!isSel[arr[mx][my]-'A']){
                isSel[arr[mx][my]-'A']=true;
                search(mx,my,cnt+1);
                isSel[arr[mx][my]-'A']=false;
            }
        }
    }


}