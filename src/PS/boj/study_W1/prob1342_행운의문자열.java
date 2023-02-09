package PS.boj.study_W1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class prob1342_행운의문자열 {

    static String str;
    static int [] avail= new int[26];
    static int cntS;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        str=in.readLine();
        for (int i = 0; i < str.length(); i++) {
            avail[str.charAt(i)-'a']++;
        }
        countString(0,0);
        System.out.println(cntS);
    }

    private static void countString(int cnt,int last) {
        if(cnt==str.length()){
            cntS++;
            return;
        }
        for (int j = 0; j < 26; j++) {
            if (avail[j]>0&&(cnt==0||last!=j)) {
                avail[j]--;
                countString(cnt + 1,j);
                avail[j]++;
            }
        }
    }


}
