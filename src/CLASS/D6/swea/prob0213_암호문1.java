package CLASS.D6.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class prob0213_암호문1 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        StringTokenizer st;
        int t=10;
        int tt=0;
        while(t>tt){

        List<Integer> list= new LinkedList<>();

        int n= Integer.parseInt(in.readLine());
        st= new StringTokenizer(in.readLine()," ");
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int k= Integer.parseInt(in.readLine());
        st= new StringTokenizer(in.readLine()," ");
        int idx;
        int len;
        for (int i = 0; i < k; i++) {
            st.nextToken();
            idx=Integer.parseInt(st.nextToken());
            len=Integer.parseInt(st.nextToken());
            for (int j = 0; j < len; j++) {
                if(idx>9){
                    Integer.parseInt(st.nextToken());
                    continue;
                }
                list.add(idx,Integer.parseInt(st.nextToken()));
                idx++;
            }
        }
        sb.append("#");
        sb.append(++tt);
        sb.append(" ");
            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i));
                sb.append(" ");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}