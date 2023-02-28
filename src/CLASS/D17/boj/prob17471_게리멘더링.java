package CLASS.D17.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;


public class prob17471_게리멘더링 {

    static ArrayList<Integer> arr[];
    static int pop[];
    static int totalsum ;
static int n;
    static int[] par;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();

        n= Integer.parseInt(in.readLine());
       arr=new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            arr[i]= new ArrayList<>();
        }

       pop= new int[n+1];
       st=new StringTokenizer(in.readLine()," ");
        for (int i = 1; i <=n; i++) {
            pop[i]=Integer.parseInt(st.nextToken());
            totalsum+=pop[i];
        }

        for (int i = 1; i <= n; i++) {
            st=new StringTokenizer(in.readLine()," ");
            int m=Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                arr[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        selec=new int [pop.length];
        for (int i = 1; i <= n/2; i++) {
            Comb(i,0,1,0);
        }
        if(min==1000000000)min=-1;
        System.out.println(min);
    }
    static int selec[];
    private static void Comb(int size,int cnt, int now, int sum) {
        if(cnt==size){
            int sum2=totalsum-sum;
            if(Math.abs(sum-sum2)<min){
                if(Chk(size,1,now-1)){
                    for (int i = 1; i < now; i++) {
                        if(selec[i]==0){
                            now=i;
                            break;
                        }
                    }
                    if(Chk(pop.length-size-1,0,now) ){
                        min=Math.abs(sum-sum2);}
                }
            }
            return;
        }
        for (int i = now; i < pop.length; i++) {
            selec[i]=1;
            Comb(size,cnt+1,i+1,sum+pop[i]);
            selec[i]=0;
        }

    }


    private static boolean Chk(int size,int team,int start) {
        boolean[] visit=new boolean[n+1];
        Queue <Integer> q= new ArrayDeque<>();
        int nod=start;
        int cnt1=1;
        visit[start]=true;
        q.offer(nod);
        while(!q.isEmpty()){
            nod=q.remove();
            for (int i = 0; i < arr[nod].size(); i++) {
                int cn=arr[nod].get(i);
                if(selec[cn]==team&&!visit[cn]){
                    visit[cn]=true;
                    cnt1++;
                    q.offer(cn);
                }
            }
        }
        if(cnt1!=size) return false;
        return true;
    }

    static int min=1000000000;


}