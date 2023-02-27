package CLASS.D15.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;


public class prob10026_적록색약 {

    static boolean isSel[][];
    static char arr[][];
    static int n, cnt, cnt_b;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(in.readLine());
        arr=new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = in.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        isSel = new boolean[n][n];
        while (!q.isEmpty()) {
            if (isSel[q.peek()[0]][q.peek()[1]]) {
                q.remove();
            } else {
                q = BFS(q, q.remove());
                cnt++;
            }
        }
        q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        isSel = new boolean[n][n];
        while (!q.isEmpty()) {
            if (isSel[q.peek()[0]][q.peek()[1]]) {
                q.remove();
            } else {
                q = BFS_b(q, q.remove());
                cnt_b++;
            }
        }
        sb.append(cnt).append(" ").append(cnt_b);
        System.out.println(sb);
    }

    private static Queue<int[]> BFS_b(Queue<int[]> result, int[] loc) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(loc);
        char color = arr[loc[0]][loc[1]];
        char color2=color;
        if (color=='R')color2='G';
        else if(color=='G')color2='R';

        while (!q.isEmpty()) {
            int node[] = q.remove();
            if(!isSel[node[0]][node[1]]) {
                isSel[node[0]][node[1]]=true;
                for (int i = 0; i < 4; i++) {
                    int mx = node[0] + dx[i];
                    int my = node[1] + dy[i];
                    if (isOk(mx, my, i) && !isSel[mx][my]) {
                        if (arr[mx][my] == color || arr[mx][my] == color2) {
                            q.offer(new int[]{mx, my});
                        } else {
                            result.offer(new int[]{mx, my});
                        }
                    }
                }
            }
        }
        return result;
    }

    private static Queue<int[]> BFS(Queue<int[]> result, int[] loc) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(loc);
        char color = arr[loc[0]][loc[1]];
        while (!q.isEmpty()) {
            int node[] = q.remove();
            if(!isSel[node[0]][node[1]]) {
                isSel[node[0]][node[1]]=true;
            for (int i = 0; i < 4; i++) {
                int mx = node[0] + dx[i];
                int my = node[1] + dy[i];
                if (isOk(mx, my, i) && !isSel[mx][my]) {
                    if (arr[mx][my] == color) {
                        q.offer(new int[]{mx, my});
                    } else {
                        result.offer(new int[]{mx, my});
                    }
                }
            }}
        }
        return result;
    }


        static int dx[] = {0, 0, 1, -1};
        static int dy[] = {1, -1, 0, 0};
        static boolean isOk ( int x, int y, int dir){
            if (dir == 0 && y >= n) return false;
            else if (dir == 1 && y < 0) return false;
            else if (dir == 2 && x >= n) return false;
            else if (dir == 3 && x < 0) return false;
            return true;
        }


    }