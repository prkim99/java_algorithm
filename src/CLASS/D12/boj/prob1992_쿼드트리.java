package CLASS.D12.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class prob1992_쿼드트리
{
    static String arr[][];
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st;
        StringBuilder sb= new StringBuilder();

        int n=Integer.parseInt(in.readLine());
        arr=new String[n][n];

        for (int i = 0; i < n; i++) {
            String[] st=in.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j]= st[j];
            }
        }

        System.out.println(dnc(n,0,0));

    }

    static Stack<Integer> s= new Stack<>();
    private static String dnc(int n, int x,int y) {
        if(n==1){
            return  arr[x][y];
        }
        String a1,a2,a3,a4;
        a1=dnc(n/2,x,y);
        a2=dnc(n/2,x,n/2+y);
        a3=dnc(n/2,n/2+x,y);
        a4=dnc(n/2,n/2+x,n/2+y);

        if(a1.equals("1")&&a2.equals("1")&&a3.equals("1")&&a4.equals("1")){
            return "1";
        }
        else if(a1.equals("0")&&a2.equals("0")&&a3.equals("0")&&a4.equals("0")){
            return "0";
        }
        else{
            return new StringBuilder("(").append(a1).append(a2).append(a3).append(a4).append(")").toString();
        }
    }


}