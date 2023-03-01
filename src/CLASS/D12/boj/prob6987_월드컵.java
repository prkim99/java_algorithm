package CLASS.D12.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class prob6987_월드컵
{
    static int arr[][];
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();

        arr= new int[4][18];
        int win=0,lose=0,draw=0;
        for (int i = 0; i < 4; i++  ) {
            flag=false;
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < 18; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }

            backtracking(i,0,1);
            for (int j = 0; j < 6; j++) {
                if((arr[i][3*j]+arr[i][1+3*j]+arr[i][2+3*j])!=5){
                    flag=false;
                    break;
                }
            }
            if(flag){
                sb.append(1);
                sb.append(" ");
            }
            else{
                sb.append(0);
                sb.append(" ");
            }
        }
        System.out.println(sb);


    }
    static boolean isFin(int now){
        if(flag)
            return true;
        if(now==5){
            flag=true;
            return true;}
        return false;
    }
static boolean flag=false;
    private static void backtracking(int i,int m, int n) {
        if(isFin(m)){
            return;
        }

        //나승 재패
        if(arr[i][3*m]>0&&arr[i][3*n+2]>0){
            arr[i][3*m]--;
            arr[i][3*n+2]--;
            if(n==5){
                backtracking(i,m+1,m+2);
            }
            else
                backtracking(i,m,n+1);
            arr[i][3*m]++;
            arr[i][3*n+2]++;
        }
        //무승부
        if(arr[i][1+3*m]>0&&arr[i][3*n+1]>0){
            arr[i][1+3*m]--;
            arr[i][3*n+1]--;
            if(n==5){
                backtracking(i,m+1,m+2);
            }
            else
                backtracking(i,m,n+1);
            arr[i][1+3*m]++;
            arr[i][3*n+1]++;

        }
        //나패 재승
        if(arr[i][2+3*m]>0&&arr[i][3*n]>0){
            arr[i][2+3*m]--;
            arr[i][3*n]--;
            if(n==5){
                backtracking(i,m+1,m+2);
            }
            else
                backtracking(i,m,n+1);
            arr[i][3*m+2]++;
            arr[i][3*n]++;
        }

    }

}