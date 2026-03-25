import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] adj;
    static boolean[] visited;
    static int[] counts; // 각 노드별 해킹 가능한 컴퓨터 수를 저장할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adj[B].add(A);
        }

        counts = new int[N + 1];
        int maxHack = 0;


        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            int count = bfs(i);
            counts[i] = count;
            maxHack = Math.max(maxHack, count); 
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (counts[i] == maxHack) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    static int bfs(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.addLast(start);
        visited[start] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int cur = q.removeFirst();
            for (int next : adj[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.addLast(next);
                    count++;
                }
            }
        }
        return count;
    }
}