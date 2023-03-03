package CLASS.D18.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class prob17143_낚시왕 {

    static int r, c, m;
    static int arr[][];
    static int speed[];
    static int direction[];
    static int size[];
    static boolean isMove[];
    static List<int[]> shark = new ArrayList<>();

    static int[] par;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(in.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[r + 1][c + 1];

        speed = new int[m + 1];
        direction = new int[m + 1];
        size = new int[m + 1];
        isMove = new boolean[m + 1];

        shark.add(null);
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = i;
            shark.add(new int[]{x, y});
            speed[i] = Integer.parseInt(st.nextToken());
            direction[i] = Integer.parseInt(st.nextToken());
            size[i] = Integer.parseInt(st.nextToken());
        }
        size[0] = 0;

        int sum = 0;

        for (int i = 1; i < c; i++) {
            sum += getFish(i);
            Arrays.fill(isMove, false);
            for (int j = 1; j <= m; j++) {
                if (shark.get(j) != null) {
                    moveShark(j);
                }
            }
        }
        sum += getFish(c);

        System.out.println(sum);
    }

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    private static void moveShark(int s) {
        int len;
        int mx = shark.get(s)[0];
        int my = shark.get(s)[1];
        if(!isMove[arr[mx][my]]){
            arr[mx][my]=0;
        }
        if (direction[s] == 1 || direction[s] == 2) {
            len = speed[s] % ((r - 1) * 2);
            while (len > 0) {
                if (mx == 1) {
                    direction[s] = 2;
                } else if (mx == r) {
                    direction[s] = 1;
                }
                mx = mx + dx[direction[s] - 1];
                len--;
            }
        } else {
            len = speed[s] % ((c - 1) * 2);
            while (len > 0) {
                if (my == 1) {
                    direction[s] = 3;

                } else if (my == c) {
                    direction[s] = 4;
                }
                my = my + dy[direction[s] - 1];
                len--;
            }
        }

        isMove[s] = true;

        if (arr[mx][my] != 0 && isMove[arr[mx][my]]) {
            if (size[arr[mx][my]] > size[s]) {
                shark.set(s, null);
            } else {
                shark.set(arr[mx][my], null);
                arr[mx][my] = s;
                shark.set(s, new int[]{mx, my});
            }
        } else {
            arr[mx][my] = s;
            shark.set(s, new int[]{mx, my});
        }
    }

    private static int getFish(int loc) {
        for (int i = 1; i <= r; i++) {
            if (arr[i][loc] != 0) {
                int s = arr[i][loc];
                arr[i][loc] = 0;
                shark.set(s, null);
                return size[s];
            }
        }
        return 0;
    }

}