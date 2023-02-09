package CLASS.D4.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class prob12891_DNA비밀번호 {

    static int dna[]=new int[4];

    static int cnt;
    static int []f= new int [4];


    public static void main(String[] args) throws IOException {
        BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(in.readLine()," ");
        int s=Integer.parseInt(st.nextToken());
        int p=Integer.parseInt(st.nextToken());
        String str= in.readLine();


        int n=0,val;
        st= new StringTokenizer(in.readLine()," ");

        for (int i = 0; i < 4; i++) {
            dna[i]=Integer.parseInt(st.nextToken());
            n+=dna[i];
        }

        for (int i = 0; i < p; i++) {
            char ch=str.charAt(i);
            if(ch=='A'){
                f[0]++;
            }
            else if(ch=='C'){
                f[1]++;
            }
            else if(ch=='G'){
                f[2]++;
            }
            else if(ch=='T'){
                f[3]++;
            }
        }
        boolean flag=true;
        for (int i = 0; i < 4; i++) {
            if(dna[i]>f[i]){
                flag=false;
                break;
            }
        }
        if(flag)
            cnt++;

        for (int i = p; i <str.length() ; i++) {
            sliding_window(str,i-p,i);
        }

        System.out.println(cnt);
    }

    private static void sliding_window(String str, int remove, int add) {
        char ch=str.charAt(remove);
        if(ch=='A'){
            f[0]--;
        }
        else if(ch=='C'){
            f[1]--;
        }
        else if(ch=='G'){
            f[2]--;
        }
        else if(ch=='T'){
            f[3]--;
        }

        ch=str.charAt(add);
        if(ch=='A'){
            f[0]++;
        }
        else if(ch=='C'){
            f[1]++;
        }
        else if(ch=='G'){
            f[2]++;
        }
        else if(ch=='T'){
            f[3]++;
        }
        boolean flag=true;
        for (int i = 0; i < 4; i++) {
            if(dna[i]>f[i]){
                flag=false;
                break;
            }
        }
        if(flag)
            cnt++;
    }

}
