import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] weight, value;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); 
        K = Integer.parseInt(st.nextToken()); 

        weight = new int[N + 1];
        value = new int[N + 1];
        dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int w = 0; w <= K; w++) {
                dp[i][w] = dp[i - 1][w];

                if (w >= weight[i]) {
                    dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - weight[i]] + value[i]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
