import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
       int t = Integer.parseInt(br.readLine());
       int[][] dp=new int[15][15];
        for (int i = 0; i < 15; i++) {
            dp[0][i]=i+1;
        }
        for(int i=1;i<15;i++){
            for (int j = 0; j < 15; j++) {
                int cnt=0;
                for (int k = 0; k < j+1; k++) {
                    cnt +=dp[i-1][k];
                }
                dp[i][j]=cnt;
            }
        }

       while (t-- > 0) {
           int k=Integer.parseInt(br.readLine());
           int n=Integer.parseInt(br.readLine());
           System.out.println(dp[k][n-1]);
       }
    }


}

