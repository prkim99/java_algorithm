package CLASS.D8.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob2563_색종이 {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n= Integer.parseInt(in.readLine());
        int arr[][]= new int [100][100];
        int total=0,x,y;
        for (int i = 0; i < n; i++) {
            st= new StringTokenizer(in.readLine()," ");
            x=Integer.parseInt(st.nextToken());
            y=Integer.parseInt(st.nextToken());
            for (int j = 0; j < 10; j++) {
                Arrays.fill(arr[y+j-1],x-1,x+9,1);
            }
        }
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                total+=arr[i][j];
            }
        }
        System.out.println(total);
    }
}

