package PS.boj.study_W1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class prob1931_회의실배정 {

    public static class Pair<F, S> {
        F first;
        S second;

        Pair(F first, S second){
        	this.first = first;
            this.second = second;
        }
    }
    static ArrayList<Pair<Integer,Integer>> meeting=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(in.readLine());


        for (int i = 0; i < n; i++) {
            StringTokenizer st= new StringTokenizer(in.readLine(), " ");
            meeting.add(new Pair<>(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }


        Collections.sort(meeting, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                if(o1.second==o2.second){
                    return o1.first-o2.first;
                }
                return o1.second-o2.second;
            }
        });
        int cnt = 1;
        int time = meeting.get(0).second;
        for (int i = 1; i < n; i++) {
            if (time <= meeting.get(i).first) {
                time = meeting.get(i).second;
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
