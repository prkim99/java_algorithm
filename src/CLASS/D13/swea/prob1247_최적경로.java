package CLASS.D13.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class prob1247_최적경로 {
    static int arr[][];
    static int min;

    static int[] swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
        return ar;
    }

    private static void backTracking(int cnt, int dist, int[] route, int finx, int finy) {
        if (dist > min) {
            return;
        }
        if (cnt == arr.length) {
            dist += Math.abs(arr[route[cnt - 1]][0] - finx) + Math.abs(arr[route[cnt - 1]][1] - finy);
            if (dist < min)
                min = dist;
            return;
        }
        for (int i = cnt; i < arr.length; i++) {
            route = swap(route, cnt, i);
            backTracking(cnt + 1,dist + Math.abs(arr[route[cnt]][0] - arr[route[cnt - 1]][0])
                    + Math.abs(arr[route[cnt]][1] - arr[route[cnt - 1]][1]), route, finx, finy);
            route=swap(route,cnt,i);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(in.readLine());
        int tt = 0;
        while (t > tt) {
            int n = Integer.parseInt(in.readLine());
            st = new StringTokenizer(in.readLine(), " ");
            int cx = Integer.parseInt(st.nextToken());
            int cy = Integer.parseInt(st.nextToken());
            int hx = Integer.parseInt(st.nextToken());
            int hy = Integer.parseInt(st.nextToken());
            arr = new int[n + 1][2];
            arr[0][0] = cx;
            arr[0][1] = cy;int route[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                route[i]=i;
            }

            route[0] = 0;
            min=100000;
            backTracking(1, 0, route, hx, hy);
            sb.append("#").append(++tt).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }




}