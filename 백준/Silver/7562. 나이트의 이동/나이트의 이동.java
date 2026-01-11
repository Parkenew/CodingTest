import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T, I;
    // 나이트 이동 방향
    static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};
    static boolean[][] visited;
    static int startR, startC, destR, destC;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            I = Integer.parseInt(br.readLine());
            
            visited = new boolean[I][I];

            st = new StringTokenizer(br.readLine());
            startR = Integer.parseInt(st.nextToken());
            startC = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            destR = Integer.parseInt(st.nextToken());
            destC = Integer.parseInt(st.nextToken());

            bfs(startR, startC);
        }
        System.out.println(sb);
    }

    static void bfs(int r, int c) {
        if (r == destR && c == destC) {
            sb.append(0).append('\n');
            return;
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{r, c, 0});
        visited[r][c] = true; // 시작점 방문 처리

        while (!q.isEmpty()) {
            int[] p = q.pollFirst();
            int now_r = p[0];
            int now_c = p[1];
            int count = p[2];

            for (int i = 0; i < 8; i++) {
                int new_r = now_r + dr[i];
                int new_c = now_c + dc[i];
                
                if (new_r < 0 || new_r >= I || new_c < 0 || new_c >= I) continue;
                if (visited[new_r][new_c]) continue;
                if (new_r == destR && new_c == destC) {
                    sb.append(count + 1).append('\n');
                    return;
                }
                visited[new_r][new_c] = true;
                q.addLast(new int[]{new_r, new_c, count + 1});
            }
        }
    }
}