import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        S = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, 0); 
        System.out.println(min);
    }

    static void comb(int depth, int start) {
        if (depth == N / 2) {
            calcDiff();
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            comb(depth + 1, i + 1);
            visited[i] = false;
        }
    }

    static void calcDiff() {
        int startSum = 0;
        int linkSum = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startSum += S[i][j] + S[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkSum += S[i][j] + S[j][i];
                }
            }
        }

        int diff = Math.abs(startSum - linkSum);
        if (diff == 0) {
            System.out.println(0);
            System.exit(0);  // 
        }
        min = Math.min(min, diff);
    }
}
