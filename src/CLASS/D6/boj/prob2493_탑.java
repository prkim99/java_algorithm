package CLASS.D6.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class prob2493_탑 {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        StringTokenizer st;
        int n= Integer.parseInt(in.readLine());
        st= new StringTokenizer(in.readLine()," ");
        int tower[]= new int[n+1];
        for (int i = 1; i <= n; i++) {
            tower[i]=Integer.parseInt(st.nextToken());
        }

        int result[]=new int[n+1];
        Stack<Integer> s= new Stack<>();
        tower[0]=100000001;
        s.push(0);
        for (int i = 1; i <= n; i++) {
            while(tower[i]>tower[s.peek()]){
                s.pop();
            }
                result[i]=s.peek();
                s.push(i);
        }
        for (int i = 1; i <=n ; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}