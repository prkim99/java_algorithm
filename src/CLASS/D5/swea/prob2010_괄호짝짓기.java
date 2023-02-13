package CLASS.D5.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class prob2010_괄호짝짓기 {

    static ArrayList<Character> left=new ArrayList<>();
    static ArrayList<Character> right=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        int t=10;
        int tt=0;
        left.add('{'); left.add('[');left.add('(');left.add('<');
        right.add('}'); right.add(']');right.add(')');right.add('>');
        while(t>tt){
            int n= Integer.parseInt(in.readLine());
            String str=in.readLine();
            Stack<Character> s=new Stack<>();

            boolean flag=true;
            for (int i = 0; i < str.length(); i++) {
                if(left.contains(str.charAt(i))){
                    s.push(str.charAt(i));
                }
                else{
                    if(left.get(right.indexOf(str.charAt(i)))==s.peek()){
                        s.pop();
                    }
                    else{
                        flag=false;
                        break;
                    }
                }
            }

            sb.append("#");
            sb.append( ++tt);
            sb.append(" ");
            if(!flag){
                sb.append(0);
            }
            else{
                sb.append(1);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
