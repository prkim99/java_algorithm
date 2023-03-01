package CLASS.D6.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class prob1158_요세푸스문제 {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader( System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");

        int n=Integer.parseInt(st.nextToken());
        int s= Integer.parseInt(st.nextToken());

        int arr[]=new int[n];
        List<Integer> list= new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        Queue queue = new ArrayDeque();
        int size=n;
        int curr=0;
        StringBuilder sb=new StringBuilder();
        sb.append("<");
        while(queue.size()<n){
            curr=(curr+s-1)%list.size();
            queue.add(list.get(curr));
            list.remove(curr);
        }

        for (int i = 0; i < n-1; i++) {
            sb.append(queue.poll());
            sb.append(", ");
        }
        sb.append(queue.peek());
        sb.append(">");
        System.out.println(sb);
    }
}