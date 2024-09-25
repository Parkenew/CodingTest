import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int N;
    static String seat;
    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        seat=br.readLine();
        int answer=0;
        int cnt=0;
        for (int i = 0; i < N; i++) {
            if(seat.charAt(i)=='S'){
                answer++;
            } else if(seat.charAt(i)=='L'){
                cnt++;
            }

            if(cnt==2){
                cnt=0;
                answer++;
            }
        }
        answer++;
        if(answer>=N){
            answer=N;
        }
        System.out.println(answer);
    }


}