import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, r, c, d;
    static int[][] adj;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dc = {0, 1, 0, -1};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r, c, d);
        System.out.println(cnt);
    }

    private static void clean(int row, int col, int dir) {
        if (!visited[row][col]) {
            visited[row][col] = true;
            cnt++;
        }

        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4;
            int nr = row + dr[dir];
            int nc = col + dc[dir];

            if (nr >= 0 && nr < N && nc >= 0 && nc < M && adj[nr][nc] == 0 && !visited[nr][nc]) {
                clean(nr, nc, dir); 
                return;
            }
        }


        int backDir = (dir + 2) % 4;
        int backRow = row + dr[backDir];
        int backCol = col + dc[backDir];

        if (backRow >= 0 && backRow < N && backCol >= 0 && backCol < M && adj[backRow][backCol] == 0) {
            clean(backRow, backCol, dir);
        }
    }
}
