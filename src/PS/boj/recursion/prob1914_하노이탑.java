package PS.boj.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class prob1914_하노이탑 {

    static void hanoii(int n, int from, int via, int to) {
        if(n==0)
            return;
        hanoii(n-1,from,to,via);
        System.out.println(from+" "+to);
        hanoii(n-1,via,from,to);
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        BigInteger num = new BigInteger("2");
        System.out.println(num.pow(n).subtract(new BigInteger("1")));
        if (n <= 20){
            hanoii(n,1,2,3);
        }
    }
}
