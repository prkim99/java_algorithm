package CLASS.D11.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob1074_Z {


    static int  dnc(int n, int r, int c, int res) {
        if (n == 1) {
            return res;
        }
        if (c < n / 2 && r < n / 2) {
            return dnc(n / 2, r, c, res);
        } else if (r < n / 2) {
            return dnc(n / 2, r, c - n / 2, n /2* n / 2 + res);
        } else if (c < n / 2) {
            return dnc(n / 2, r - n / 2,c,  n * n / 2 + res);
        } else {
            return dnc(n / 2, r - n / 2, c - n / 2, res + n/2 *n/2*3);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int result = dnc((int) Math.pow(2, n), r, c, 0);
        System.out.println(result);
    }
}
