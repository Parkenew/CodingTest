import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int N,M;
    static int[] arr;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr=new int[N];
        answer=new int[M];
        for (int i = 0; i < N; i++) {
            arr[i]=i+1;
        }

        BackTracking(0,0);
        System.out.println(sb);
    }
    private static void BackTracking(int idx,int startIdx){
        if (idx == M) {
            for (int i = 0; i < M; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = startIdx; i < N; i++) {
                answer[idx]=arr[i];
                BackTracking(idx+1,i+1);
            }
        }

    }
}