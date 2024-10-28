import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int N,M;
    static String S,P;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int cnt = 0, answer = 0;
        for (int i = 1; i < M - 1; i++) {
            if (S.charAt(i - 1) == 'I' && S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
                cnt++;
                if (cnt == N) {
                    answer++;
                    cnt--; 
                }
                i++;
            } else {
                cnt = 0;
            }
        }

        System.out.println(answer);
        br.close();

    }

}
