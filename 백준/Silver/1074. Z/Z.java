//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int n;//박스 크기

    static int N,r,c;
    static int cnt=0;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        DC(N,r,c);

        System.out.println(cnt-1);


    }

    public static void DC(int N,int r, int c){
        if(N==1) {
            if (r == 0 && c == 0) {
                cnt = cnt + 1;
            } else if (r == 0 && c == 1) {
                cnt = cnt + 2;
            } else if (r == 1 && c == 0) {
                cnt = cnt + 3;
            } else if (r == 1 && c == 1) {
                cnt = cnt + 4;
            }
        } else {
            n= (int) Math.pow(2,N);
            if(r<= n/2-1 && c <= n/2-1){
                DC(N-1,r,c);
            } else if (r <= n/2-1 && c>n/2-1){
                cnt=cnt+n*n/4;
                DC(N-1, r, c-n/2);
            } else if( r > n/2-1 && c <=n/2-1){
                cnt=cnt+n*n/4*2;
                DC(N-1,r-n/2,c);
            } else if( r > n/2-1 && c>n/2-1){
                cnt=cnt+n*n/4*3;
                DC(N-1,r-n/2,c-n/2);
            }
        }
    }

}