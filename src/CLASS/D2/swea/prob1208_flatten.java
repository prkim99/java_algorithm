package CLASS.D2.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob1208_flatten {
    static int diff=0;
    public static void main(String[] args) throws IOException {

      int boxAsc[]=new int [100];

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t= 10;
        int tt=1;
        while(t>=tt){
            int n=Integer.parseInt(in.readLine());
            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            for(int i=0;i<100;i++){
                boxAsc[i]=Integer.parseInt(st.nextToken());
                if(i==98){
                    int a=0;
                }
            }

            //Arrays.sort(boxAsc,Collections.reverseOrder());

            dump(boxAsc,n);
            System.out.println("#"+tt+" "+diff);
            tt++;
        }

    }
    private static void dump(int[] box, int cnt) {
        Arrays.sort(box);

        if(box[0]==box[box.length-1]||cnt==0){
            diff=box[box.length-1]-box[0];
            return;
        }

        box[0]++;
        box[99]--;

        dump(box, cnt-1);
        }

    }
