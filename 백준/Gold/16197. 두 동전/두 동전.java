import java.io.*;
import java.util.*;
class State {
    int x1, y1, x2, y2, moves;

    State(int x1, int y1, int x2, int y2, int moves) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.moves = moves;
    }
}
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static char[][] board;
    static ArrayDeque<State> q = new ArrayDeque<>();


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];

        List<int[]> coins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'o') {
                    coins.add(new int[]{i, j});
                }
            }
        }

        int result = bfs(coins.get(0), coins.get(1));
        System.out.println(result);
    }

    static int bfs(int[] coin1, int[] coin2) {
        Set<String> visited = new HashSet<>();

        q.addLast(new State(coin1[0], coin1[1], coin2[0], coin2[1], 0));
        visited.add(coin1[0] + "," + coin1[1] + "," + coin2[0] + "," + coin2[1]);

        while (!q.isEmpty()) {
            State current = q.removeFirst();

            if (current.moves >= 10) return -1;

            for (int i = 0; i < 4; i++) {
                int nx1 = current.x1 + dx[i];
                int ny1 = current.y1 + dy[i];
                int nx2 = current.x2 + dx[i];
                int ny2 = current.y2 + dy[i];

                boolean out1 = isOut(nx1, ny1);
                boolean out2 = isOut(nx2, ny2);

                //하나가 아웃되면 즉시 리턴
                if (out1 && !out2 || !out1 && out2) {
                    return current.moves + 1;
                }


                if (out1 && out2) {
                    continue;
                }

                //이동칸이 벽이면
                if (!out1 && board[nx1][ny1] == '#') {
                    nx1 = current.x1;
                    ny1 = current.y1;
                }
                if (!out2 && board[nx2][ny2] == '#') {
                    nx2 = current.x2;
                    ny2 = current.y2;
                }

                String state = nx1 + "," + ny1 + "," + nx2 + "," + ny2;
                if (!visited.contains(state)) {
                    visited.add(state);
                    q.add(new State(nx1, ny1, nx2, ny2, current.moves + 1));
                }
            }
        }

        return -1;
    }

    static boolean isOut(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }
}
