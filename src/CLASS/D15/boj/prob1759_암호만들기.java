package CLASS.D15.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class prob1759_암호만들기 {

    static StringBuilder sb = new StringBuilder();
    static List<Character>aeiou;
    static char al[], selec[];
    //static boolean flag=false;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");


        int L = Integer.parseInt(st.nextToken());
        int C=Integer.parseInt(st.nextToken());

        al=in.readLine().replaceAll(" ","").toCharArray();
        Arrays.sort(al);

        String ae="aeiou";
        aeiou=new ArrayList<>();
        selec=new char[L];
        for (int i = 0; i < ae.length(); i++) {
            aeiou.add(ae.charAt(i));
        }

        Comb(0,0,0,0,L);
        System.out.println(sb);
    }

    private static void Comb(int start, int cnt, int v, int c, int n) {
        if(cnt == n) {
            if(v >= 1 && c >= 2) {
                for (int i = 0; i < selec.length; i++) {
                    sb.append(selec[i]);
                }
                sb.append('\n');
            }
            return;
        }

        for (int i = start; i < al.length; i++) {
            selec[cnt] = al[i];

            if(aeiou.contains(al[i]))
                Comb(i + 1, cnt + 1, v + 1, c,n);
            else
                Comb(i + 1, cnt + 1, v , c + 1,n);
        }
    }
}