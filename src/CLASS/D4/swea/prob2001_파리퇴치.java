package CLASS.D4.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob2001_파리퇴치 {

    static int mat[][];
    static int temp[][];
    public static void main(String[] args)  throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(in.readLine());
        int tt=0;
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        while(t>tt) {
            st= new StringTokenizer(in.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            mat=new int[n][n];
            temp=new int[n-m+1][n-m+1];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    mat[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    temp[0][0] += mat[i][j];
                }
            }
            moving_window(n, m);
            sb.append("#");
            sb.append(tt+1);
            sb.append(" ");
            sb.append(max);
            sb.append("\n");
            tt++;
            max=0;
        }
        System.out.println(sb);
    }
static int max=0;
    private static int moving_window(int n,int size) {
        max=temp[0][0];
        for (int i = 0; i <= n-size; i++) {
            if(i!=0)
                newLineWindow(i,0,size);
            for (int j = 1; j <= n-size; j++) {
                sumWindow(i,j,size);

            }
        }
        return max;
    }

    private static void newLineWindow(int si, int sj,int size) {
        temp[si][sj]=temp[si-1][sj];
        for (int i = 0; i < size; i++) {
            temp[si][sj]+=-mat[si-1][sj+i]+mat[si+size-1][sj+i];
        }
        if(temp[si][sj]>max){
            max=temp[si][sj];
        }
    }

    private static void sumWindow(int si,int sj,int size) {
        temp[si][sj]=temp[si][sj-1];
        for (int i = 0; i < size; i++) {
            temp[si][sj]+=-mat[si+i][sj-1]+mat[si+i][sj+size-1];
        }
        if(temp[si][sj]>max){
            max=temp[si][sj];
        }
    }
}