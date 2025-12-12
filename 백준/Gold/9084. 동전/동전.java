import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb=new StringBuilder();
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;
    public static void main(String[] args) throws IOException {
        T=Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N=Integer.parseInt(br.readLine());
            int[] coins=new int[N];
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                coins[j]=Integer.parseInt(st.nextToken());
            }
            int M=Integer.parseInt(br.readLine());
            int[] dp=new int[M+1];
            dp[0]=1;
            for(int coin:coins){
                for (int j=coin;j<=M;j++){
                    dp[j]+=dp[j-coin];
                }
            }
            sb.append(dp[M]).append("\n");
        }
        System.out.println(sb);
    }



}