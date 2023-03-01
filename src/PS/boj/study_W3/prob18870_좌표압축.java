package PS.boj.study_W3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class prob18870_좌표압축 {

    public static void main(String[] args) throws IOException {
        int m,n;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n=Integer.parseInt(in.readLine());

        ArrayList<int[]> v= new ArrayList<>();

        st=new StringTokenizer(in.readLine()," ");
        for (int i = 0; i < n; i++) {
            v.add(new int[]{Integer.parseInt(st.nextToken()),i});
        }

        Collections.sort(v, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int arr[]= new int[n];
        arr[v.get(0)[1]]=0;

        for (int i = 1; i < v.size(); ++i) {
            if (v.get(i)[0]>v.get(i-1)[0]){
                arr[v.get(i)[1]]=arr[v.get(i-1)[1]]+1;
            }
            else{
                arr[v.get(i)[1]]=arr[v.get(i-1)[1]];
            }
        }
        for (int i = 0; i < n; ++i) {
           sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);

    }
}

