import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static ArrayList<Node> student = new ArrayList<>();
    static int n;
    static char[][] map;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if(map[i][j] == 'S'){
                    student.add(new Node(i, j));
                }
            }
        }
        backTracking(0);

        System.out.println("NO");

    }

    static void backTracking(int wall) {
        if (wall == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = 'O';
                    backTracking(wall + 1);
                    map[i][j] = 'X';
                }
            }
        }
    }

    private static void bfs() {

        ArrayDeque<Node> q = new ArrayDeque<>();
        char[][] copyMap = new char[n][n];
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (copyMap[i][j] == 'T') {
                    q.addLast(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Node now = q.removeFirst();
            int r = now.r;
            int c = now.c;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                while(0 <= nr && nr < n && 0 <= nc && nc < n) {
                    if (copyMap[nr][nc] != 'O') {
                        visited[nr][nc] = true;
                        nr += dr[k];
                        nc += dc[k];
                    }else{
                        break;
                    }
                }
            }
        }
        if(catchStudent(visited)){
            System.out.println("YES");
            System.exit(0);
        }
    }

    private static boolean catchStudent(boolean[][] visited) {

        for (Node node : student) {
            if (visited[node.r][node.c]) {
                return false;
            }
        }
        return true;
    }

}
