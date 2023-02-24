package CLASS.D14.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class prob1260_DFS와BFS {
    static ArrayList<Integer>[] graph = new ArrayList[1001];
    static int x, y, h, w;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        ;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        int v1, v2;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            ;
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        sb.append(dfs(v, n));
        sb.append("\n");
        sb.append(bfs(v, n));
        System.out.println(sb);
    }

    private static StringBuilder bfs(int v, int n) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean visit[] = new boolean[n + 1];
        q.offer(v);
        visit[v] = true;
        StringBuilder sbbfs = new StringBuilder();
        while (!q.isEmpty()) {
            int node = q.poll();
            sbbfs.append(node).append(" ");
            Collections.sort(graph[node]);
            for (int i = 0; i < graph[node].size(); i++) {
                int cnode = graph[node].get(i);
                if (!visit[cnode]) {
                    q.offer(cnode);
                    visit[cnode] = true;
                }
            }
        }
        return sbbfs;
    }

    private static StringBuilder dfs(int v, int n) {
        Stack<Integer> s = new Stack<>();
        boolean visit[] = new boolean[n + 1];
        s.push(v);
        StringBuilder sbdfs = new StringBuilder();
        while (!s.isEmpty()) {
            int node = s.pop();
            if (!visit[node]) {
                sbdfs.append(node).append(" ");
                visit[node] = true;
                Collections.sort(graph[node]);
                for (int i = graph[node].size() - 1; i >= 0; i--) {
                    int cnode = graph[node].get(i);
                    if (!visit[cnode]) {
                        s.push(cnode);
                    }
                }
            }
        }
        return sbdfs;
    }


}