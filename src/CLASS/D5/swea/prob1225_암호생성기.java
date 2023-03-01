package CLASS.D5.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class prob1225_암호생성기 {
    public static void main(String[] args) throws IOException {
        BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        int t=10;
        int tt=0;
        while (t>tt) {
            int n = Integer.parseInt(in.readLine());
            st = new StringTokenizer(in.readLine(), " ");
            ArrayDeque<Integer> deq = new ArrayDeque<>();
            for (int i = 0; i < 8; i++) {
                deq.offerLast(Integer.parseInt(st.nextToken()));
            }

            boolean flag = true;
            int temp;
            while (flag) {
                for (int i = 1; i <= 5; i++) {
                    temp = deq.getFirst();
                    deq.removeFirst();
                    if (temp > i) {
                        deq.offerLast(temp - i);
                    } else {
                        flag = false;
                        deq.offerLast(0);
                        break;
                    }
                }

            }
            Iterator iter = deq.iterator();

            sb.append("#");
            sb.append( ++tt);
            sb.append(" ");
            while (iter.hasNext()) {
                sb.append(iter.next());
                sb.append(" ");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}
