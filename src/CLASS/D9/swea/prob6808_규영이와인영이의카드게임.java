package CLASS.D9.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob6808_규영이와인영이의카드게임 {

    static int cntWin, cntLose;
    static int kyu[];
    static void Permutation(int[] arr,int s, int e){
        if(s==e){
            int scorek=0,scorei=0;
            for (int i = 0; i < 9; i++) {
                if(kyu[i]>arr[i]){
                    scorek+=kyu[i]+arr[i];
                }
                else{
                    scorei+=kyu[i]+arr[i];
                }
            }
            if(scorei>scorek) cntWin++;
            else if(scorei<scorek) cntLose++;
            return;
        }
        for (int i = s; i <= e; i++) {
            arr=swap(arr,s,i);
            Permutation(arr,s+1,e);
            arr=swap(arr,s,i);
        }
    }
    static int[] swap(int[]arr,int s, int i){
        int temp=arr[s];
        arr[s]=arr[i];
        arr[i]=temp;
        return arr;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        int t=Integer.parseInt(in.readLine());
        int tt=0;
        while(t>tt){
            st=new StringTokenizer(in.readLine()," ");
            kyu=new int[9];
            boolean []nkyu= new boolean[19];
            for (int i = 0; i < 9; i++) {
                kyu[i]=Integer.parseInt(st.nextToken());
                nkyu[kyu[i]]=true;

            }
            int iny[]=new int[9];
            int k=0;
            for (int i = 1; i <=18; i++) {
                if(!nkyu[i]){
                    iny[k]=i;
                    k++;
                }
            }
            Arrays.sort(iny);
            Permutation(iny,0,8);


            sb.append("#").append(++tt).append(" ").append(cntLose).append(" ").append(cntWin).append("\n");
            cntLose=0;
            cntWin=0;
        }
        System.out.println(sb);
    }
}
