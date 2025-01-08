import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, k;
    static int[] card;
    static int[] C;
    static Map<String, Integer> map;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        card = new int[n];
        visited = new boolean[n];
        map = new HashMap<>();
        C = new int[k];

        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(br.readLine());
        }
        backTracking(0);
        System.out.println(cnt);
    }

    private static void backTracking(int idx) {
        if (idx == k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                sb.append(C[i]);
            }

            if (!map.containsKey(sb.toString())) {
                map.put(sb.toString(), 1);
                cnt++;
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (visited[i]) continue;
                C[idx] = card[i];
                visited[i] = true;
                backTracking(idx + 1);
                visited[i] = false;
            }
        }

    }
}