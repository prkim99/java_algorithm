package CLASS.D13.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class prob1873_상호의배틀필드 {
    static char arr[][];
    static int x,y,h,w;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(in.readLine());
        int tt = 0;
        while (t > tt) {
            st = new StringTokenizer(in.readLine(), " ");
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            arr=new char[h][w];

            for (int i = 0; i <h; i++) {
                String str=in.readLine();
                for (int j = 0; j < w; j++) {
                    arr[i][j]=str.charAt(j);
                    if(arr[i][j]=='^'||arr[i][j]=='v'||arr[i][j]=='<'||arr[i][j]=='>'){
                        x=i;
                        y=j;
                    }
                }
            }
            Arrays.sort(dir);
            in.readLine();
            String op=in.readLine();
            for (int i = 0; i < op.length(); i++) {
                move(op.charAt(i));
            }
            sb.append("#").append(++tt).append(" ");
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    sb.append(arr[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

   static char dir[]={'<','>','^','v'};
    static int dx[]={0,0,-1,1};
    static int dy[]={-1,1,0,0};

    private static void move(char c) {
        if(c=='U'){
            if(x>0&&arr[x-1][y]=='.'){
                arr[x][y]='.';
                x--;
            }
            arr[x][y]='^';
        }
        else if(c=='D'){
            if(x<h-1&&arr[x+1][y]=='.'){
                arr[x][y]='.';
                x++;
            }
            arr[x][y]='v';
        }
        else if (c=='L') {
            if(y>0&&arr[x][y-1]=='.'){
                arr[x][y]='.';
                y--;
            }
            arr[x][y]='<';
        }
        else if(c=='R'){
            if(y<w-1&&arr[x][y+1]=='.'){
                arr[x][y]='.';
                y++;
            }
            arr[x][y]='>';
        }else{
            shoot(Arrays.binarySearch(dir,arr[x][y]));
        }
    }

    private static void shoot(int i) {
        int sx=x,sy=y;
        while(true){
            sx+=dx[i];
            sy+=dy[i];
            if(sx<0||sx>=h||sy<0||sy>=w||arr[sx][sy]=='#'){
                break;
            }
            if(arr[sx][sy]=='*'){
                arr[sx][sy]='.';
                break;
            }
        }
    }

}