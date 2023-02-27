package CLASS.D15.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class prob1303_ABCDE {


static ArrayList<Integer>[] arr;
static int depth[];
//static boolean flag=false;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        arr=new ArrayList[n];

        for (int i = 0; i < n; i++) {
            arr[i]=new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(in.readLine()," ");
            int v1=Integer.parseInt(st.nextToken());
            int v2=Integer.parseInt(st.nextToken());
            arr[v1].add(v2);
            arr[v2].add(v1);
        }

        for (int i = 0; i < n; i++) {
            depth=new int[n];
            depth[i]=1;
            Search(i);
            if(flag){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);

    }

    static boolean flag;
    private static void Search(int n ) {
        if(flag) return;
        if(depth[n]>=5) flag=true;
        else{
            for (int i = 0; i < arr[n].size(); i++) {
              int cnode=arr[n].get(i);
              if(depth[cnode]==0){
                  depth[cnode]=depth[n]+1;
                  Search(cnode);
                  depth[cnode]=0;
                }
            }
        }
    }
    }