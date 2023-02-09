package CLASS.D4.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class prob2023_신기한소수 {


    static int n;

    static int availNum[]= new int []{1,3,7,9};
    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(in.readLine());

        int first[]=new int[]{2,3,5,7};

        for (int i = 0; i <4 ; i++) {
            prime(first[i],1);
        }
        System.out.println(sb);
    }

    private static void prime(int add, int cnt) {
        if(cnt==n){
            sb.append(add);
            sb.append("\n");
            return;
        }
        for (int i = 0; i < 4; i++) {
            add=add*10+availNum[i];
            if(isPrime(add)){
                prime(add,cnt+1);
            }
            add/=10;
        }
    }
    static boolean isPrime(int n){
        double a=Math.sqrt(n);

        if(n%2==0) return false;

        for (int i = 3; i < a; i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}
