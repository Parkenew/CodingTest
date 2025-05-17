import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int idx;
        long cost;

        Node(int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    static int N, M;
    static boolean[] sight;
    static List<Node>[] graph;
    static long[] dist;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sight = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sight[i] = st.nextToken().equals("1");
        }
        sight[N - 1] = false; // 도착 노드는 예외 처리

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        // 출발 노드가 시야에 있다면 -1 출력
        if (sight[0]) {
            System.out.println(-1);
            return;
        }

        // 다익스트라 알고리즘 실행
        dist = new long[N];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.idx;
            long cost = current.cost;

            if (dist[u] < cost) continue;

            for (Node next : graph[u]) {
                int v = next.idx;
                long nextCost = cost + next.cost;

                if (sight[v]) continue; // 시야에 있는 노드는 건너뜀

                if (dist[v] > nextCost) {
                    dist[v] = nextCost;
                    pq.offer(new Node(v, nextCost));
                }
            }
        }

        System.out.println(dist[N - 1] == INF ? -1 : dist[N - 1]);
    }
}
