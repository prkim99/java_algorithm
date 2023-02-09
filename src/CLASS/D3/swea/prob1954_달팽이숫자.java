package CLASS.D3.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class prob1954_달팽이숫자 {

    public static void main(String[] args) throws IOException {
        BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
        int t= parseInt(in.readLine());
        int tt=1;
        StringBuilder sb= new StringBuilder();
        while(t>=tt){
            num=1;
            int n=Integer.parseInt(in.readLine());
            snail(n,0,0,1);

            sb.append("#"+tt+"\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(mat[i][j]);
                    sb.append(" ");
                }
                sb.append("\n");
            }

            tt++;
        }
        System.out.println(sb);
    }
    static int mat[][]=new int[10][10];
    static int num;
    private static void snail(int n,int sx,int sy,int d) {
        if(n==1){
            mat[sx][sy]=num;
            return;}
        if(n==0)
            return;

        if(d%4==1){
            for (int i = 0; i < n-1; i++) {
                mat[sx][sy++]=num++;
            }
            snail(n, sx,sy,d+1);
        }
        else if(d%4==2){
            for (int i = 0; i < n-1; i++) {
                mat[sx++][sy]=num++;
            }
            snail(n, sx,sy,d+1);
        }
        else if(d%4==3){
            for (int i = 0; i < n-1; i++) {
                mat[sx][sy--]=num++;
            }
            snail(n, sx,sy,d+1);
        }
        else{
            for (int i = 0; i < n-1; i++) {
                mat[sx--][sy]=num++;
            }
            snail(n-2, sx+1,sy+1,d+1);
        }
    }
}
