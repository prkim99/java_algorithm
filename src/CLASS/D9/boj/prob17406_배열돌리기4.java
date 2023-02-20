package CLASS.D9.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob17406_배열돌리기4 {

    static int dy[] = {1, 0, -1, 0};
    static int dx[] = {0, 1, 0, -1};
    static int arr[][];
    static int seq[][];
    static int n, m, r, c;

    static boolean isPos(int x, int y, int s) { //범위 내 있는지 확인
        if (x >= r - s && y <= c + s && x <= r + s && y >= c - s) {
            return true;
        }
        return false;
    }

    static void rotate(int x, int y, int d, int val, int s) {
        int cur = arr[x][y];
        arr[x][y] = val;
        int xx = x + dx[d];
        int yy = y + dy[d];

        if (xx == r - s && yy == c - s)//한바퀴 돌아왔을 경우 종료
            return;
        if (isPos(xx, yy, s)) { //범위 내에 있으면 방향을 바꾸지 않고 rotate수행
            rotate(xx, yy, d, cur, s);
        } else {//범위 내에 없으면 방향을 바꿈
            yy = y + dy[d + 1];
            xx = x + dx[d + 1];
            if (xx == r - s && yy == c - s)//한바퀴 돌아왔을 경우 종료
                return;
            rotate(xx, yy, d + 1, cur, s);//바꾼 방향으로 rotate 수행
        }
    }

    static int cnt;
    static void setSeq(int k, int ar[], int s) {
        if (s == k-1) {
            seq[cnt] =Arrays.copyOf(ar,ar.length);
            cnt++;
            return;
        }
        for (int i = s; i < k; i++) {
            ar=swap(ar,s,i);
            setSeq(k,ar,s+1);
            ar=swap(ar,s,i);
        }
    }
    static int[] swap(int[]ar,int i,int j){
        int temp=ar[i];
        ar[i]=ar[j];
        ar[j]=temp;
        return ar;
    }
    static void arraySet(int[][] temp){
        for (int i = 0; i < temp.length; i++) {
            arr[i]=Arrays.copyOf(temp[i],temp[i].length);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(in.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][m + 1];
        int[][]temp_arr=new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                temp_arr[i][j]=arr[i][j];
            }
        }

        int op[][] = new int[k][3];
        int ar[] = new int[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            op[i][0] = Integer.parseInt(st.nextToken());
            op[i][1] = Integer.parseInt(st.nextToken());
            op[i][2] = Integer.parseInt(st.nextToken());
            ar[i]=i;
        }

        int total = 1;
        for (int i = 1; i <= k; i++) {
            total *= i;
        }


        int min = 50000;
        seq = new int[total][k];
        setSeq(k, ar, 0);
        int tt = 0;
        int ttt = 0;
        while (total > ttt) {
            arraySet(temp_arr);
            tt=0;
            while (k > tt) {
                r = op[seq[ttt][tt]][0];
                c = op[seq[ttt][tt]][1];
                int s = op[seq[ttt][tt]][2];

                for (int i = 1; i <= s; ++i) {
                    rotate(r - i, c - i, 0, arr[r - i + 1][c - i], i);
                }
                tt++;
            }
            for (int i = 1; i <= n; i++) {
                //int sum=Arraysarr[i]
                //IntStream.of(arr[i]).sum();
                int sum = Arrays.stream(arr[i]).sum();
                if (sum < min)
                    min = sum;
            }
            ttt++;
        }
        System.out.println(min);

    }
}
