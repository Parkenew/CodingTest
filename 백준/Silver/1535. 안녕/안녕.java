import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb=new StringBuilder();
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        int[] health=new int[N+1];
        int[] joy=new int[N+1];
        st=new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            health[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            joy[i]=Integer.parseInt(st.nextToken());
        }
        int[][] dp=new int[N+1][100];
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < 100; j++) {
                if(j>=health[i]){
                    dp[i][j]=Math.max(dp[i-1][j-health[i]]+joy[i],dp[i-1][j]);
                }
                else dp[i][j]=dp[i-1][j];
            }
        }
        System.out.println(dp[N][99]);

    }




}