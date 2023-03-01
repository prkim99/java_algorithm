package PS.boj.study_W3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob2343_기타레슨 {

    public static void main(String[] args) throws IOException {
        int m,n;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st=new StringTokenizer(in.readLine()," ");
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
int s=0,e=0;
        int []arr= new int[n];
        st=new StringTokenizer(in.readLine()," ");
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
            e+=arr[i];
            if(s<arr[i]) {
            s=arr[i];
            }
        }


        while (s < e) {
            int mid = (s + e) / 2;

            int sum = 0, cnt = 0;
            for (int i = 0; i < n; i++) {
                if (sum + arr[i] > mid) {
                    sum = 0;
                    cnt++;
                }
                sum += arr[i];
            }
            if (sum != 0) cnt++;

            if (cnt > m) {
                s = mid + 1;
            }
            else {
                e = mid;
            }
        }
        System.out.println(s);

    }
}

