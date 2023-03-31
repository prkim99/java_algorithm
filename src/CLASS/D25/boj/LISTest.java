package CLASS.D25.boj;

import java.util.Scanner;

public class LISTest {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int []arr=new int[n];
        int []lis=new int[n];

        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }

        int max=0;
        for (int i = 0; i < n; i++) {
            lis[i]=1;
            for (int j = 0; j < i; j++) {
                if(arr[j]<arr[i]&&lis[i]<lis[j]+1){
                    lis[i]=lis[j]+1;
                }
            }
            if(max<lis[i]) max=lis[i];
        }
        System.out.println(max);
    }
}
