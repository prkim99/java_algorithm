package CLASS.D7.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class prob1233_사칙연산유효성검사 {

    public class Pair<F, S>{
        F first;
        S second;

        Pair(F first, S second){
        	this.first = first;
            this.second = second;
        }
    }
    //ArrayList<ArrayList<Pair<Integer,Integer>>> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        int t=10;
        int tt=0;
        while(t>tt){
            int n=Integer.parseInt(in.readLine());
            int tree[]= new int [n+1];
            boolean flag=true;
            for (int i = 0; i < n; i++) {
                st= new StringTokenizer(in.readLine()," ");
                int node=Integer.parseInt(st.nextToken());
                int cnt=st.countTokens();
                String value= st.nextToken();
                if(value.equals("-")||value.equals("+")||value.equals("/")||value.equals("*")){
                    if(cnt<=2)
                        flag=false;
                }
            }
            sb.append("#").append(++tt).append(" ");
            if(flag)
                sb.append(1);
            else
                sb.append(0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}