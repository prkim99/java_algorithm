package CLASS.D5.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class prob2164_카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        if(n==1){
            System.out.println(1);
            return ;
        }
        Queue<Integer> queue= new ArrayDeque<>();
        for (int i = 1; i <=n ; i++) {
            queue.add(i);
        }
        queue.remove();
        while(queue.size()>1){
            queue.add(queue.peek());
            queue.remove();
            queue.remove();
        }
        System.out.println(queue.peek());
    }
}
