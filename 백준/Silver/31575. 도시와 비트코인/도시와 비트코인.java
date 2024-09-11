import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int m;
    static int[][] abj;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        abj = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                abj[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        visited = new boolean[m][n];

        int[] dx = {1, 0};
        int[] dy = {0, 1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] nums = q.poll();
            int x = nums[1];
            int y = nums[0];

            for (int i = 0; i < 2; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && 0 <= ny && nx < n && ny < m && !visited[ny][nx] && abj[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
            }
        }
        if (visited[m - 1][n - 1]) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}