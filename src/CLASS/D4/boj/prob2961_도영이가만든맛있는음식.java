package CLASS.D4.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob2961_도영이가만든맛있는음식 {

    static int bitter[]=new int[10];
    static int sour[]=new int[10];
    static int t, diff=1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t=Integer.parseInt(in.readLine());

 int       tt=0;
        while(t>tt){
            st= new StringTokenizer(in.readLine()," ");
            sour[tt]=Integer.parseInt(st.nextToken());
            bitter[tt]=Integer.parseInt(st.nextToken());
            tt++;
        }
        boolean subset[]= new boolean[10];
        getSubset(0,subset);

        System.out.println(diff);
    }

    private static void getSubset(int i, boolean[] subset) {
        if (i==t){
            int b=calBitter(subset);
            int s=calSour(subset);
            if(b!=0&&diff>Math.abs(b-s)){
                diff=Math.abs(b-s);
            }
        }
        else{
            subset[i]=true;
            getSubset(i+1,subset);
            subset[i]=false;
            getSubset(i+1,subset);
        }
    }

    private static int calSour(boolean[] subset) {
        int total=1;
        for (int i = 0; i < 10; i++) {
            if(subset[i]){
                total*=sour[i];
            }
        }
        return total;
    }

    private static int calBitter(boolean[] subset) {
        int total=0;
        for (int i = 0; i < 10; i++) {
            if(subset[i]){
                total+=bitter[i];
            }
        }
        return total;
    }

}
