package CLASS.D24;

import java.util.Scanner;

public class KnapsackTest {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int w=sc.nextInt();

        int [] weights= new int[n+1];
        int [] profits=new int[n+1];

        for (int i = 0; i <=n; i++) {
            weights[i]= sc.nextInt();
            profits[i]=sc.nextInt();
        }
        int[][]d= new int[n+1][w+1];

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n; j++) {
                if(weights[i]>j){
                    d[i][j]=d[i-1][j];
                }
                else{
                    d[i][j]=Math.max(d[i-1][j], profits[i]+d[i-1][j-weights[i]]);
                }
            }
        }
        System.out.println(d[n][w]);

    }
}
