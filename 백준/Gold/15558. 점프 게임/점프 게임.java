import java.io.*;
import java.util.*;

public class Main {
        static int N, K;
        static int[][] line;
        static boolean[][] visited;

        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st = new StringTokenizer(br.readLine());

                N = Integer.parseInt(st.nextToken());
                K = Integer.parseInt(st.nextToken());

                line = new int[2][N];
                visited = new boolean[2][N];

                for (int i = 0; i < 2; i++) {
                        String str = br.readLine();
                        for (int j = 0; j < N; j++) {
                                line[i][j] = str.charAt(j) - '0';
                        }
                }

                System.out.println(bfs() ? 1 : 0);
        }

        static boolean bfs() {
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{0, 0, 0});
                visited[0][0] = true;

                while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        int r = curr[0];
                        int c = curr[1];
                        int time = curr[2];

                        // 세 가지 이동 경로: 앞으로, 뒤로, 반대편 점프
                        int[][] nextPos = {{r, c + 1}, {r, c - 1}, {1 - r, c + K}};

                        for (int[] next : nextPos) {
                                int nr = next[0];
                                int nc = next[1];
                                
                                if (nc >= N) return true;
                                
                                if (nc > time && line[nr][nc] == 1 && !visited[nr][nc]) {
                                        visited[nr][nc] = true;
                                        q.add(new int[]{nr, nc, time + 1});
                                }
                        }
                }
                return false;
        }
}