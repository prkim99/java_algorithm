package PS.boj.study_W3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class prob1072_게임 {

    public static void main(String[] args) throws IOException {
        long x, y;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        ;
        StringBuilder sb = new StringBuilder();
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        double cur = y * 100 / x;

        if(cur>=99){
            System.out.println(-1);
        }else {
            double a=Math.ceil(((cur+1)*x-(100*y))/(99-cur));
            System.out.println((int)a);
        }
    }
}

