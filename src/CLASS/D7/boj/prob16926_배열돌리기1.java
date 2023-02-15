package CLASS.D7.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class prob16926_배열돌리기1 {

    static int dy[]={0,1,0,-1};
    static int dx[]={1,0,-1,0};
    static int arr[][];
    static int n,m;
    static boolean isPos(int x, int y, int base){ //범위 내 있는지 확인
        if(x >= base && y < m - base && x < n-base && y >=base){
            return true;
        }
        return false;
    }
    static void rotate(int x, int y, int d, int val, int base)
    {
        int cur = arr[x][y];
        arr[x][y] = val;
        int xx = x + dx[d];
        int yy = y + dy[d];

        if (xx == base && yy == base)//한바퀴 돌아왔을 경우 종료
            return;
        if (isPos(xx,yy,base)) { //범위 내에 있으면 방향을 바꾸지 않고 rotate수행
            rotate(xx, yy, d, cur, base);
        }
        else{//범위 내에 없으면 방향을 바꿈
            yy = y + dy[d + 1];
            xx = x + dx[d + 1];
            if (xx == base && yy == base)//한바퀴 돌아왔을 경우 종료
                return;
            rotate(xx, yy, d + 1, cur, base);//바꾼 방향으로 rotate 수행
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
/*        int t=11;
        int tt=0;
        while(t>tt){*/
        StringBuilder sb= new StringBuilder();
        st= new StringTokenizer(in.readLine()," ");
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        int r=Integer.parseInt(st.nextToken());

        arr=new int[n][m];
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(in.readLine()," ");
            for (int j = 0; j < m; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int circle=(n<m)?n/2:m/2;

        for (int i = 0; i < circle; ++i) {
            for (int j = 0; j < r%((n-i*2)*2+2*(m-i*2)-4); j++) {
                rotate(i,i,0,arr[i][i+1],i);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
/*        in.readLine();
    }
        tt++;*/
    }
}