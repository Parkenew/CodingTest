import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static List<Node>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine()); 

        graph = new ArrayList[N + 1]; 
        visited = new boolean[N + 1];

      
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>(); 
        }

      
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            graph[A].add(new Node(B, val));
            graph[B].add(new Node(A, val));
        }

        // 초기화
        Queue<Node> q = new PriorityQueue<>();
        for (int i = 0; i < graph[1].size(); i++) {
            q.offer(graph[1].get(i));
        }
        visited[1] = true;

        int sum = 0;

        
        while (!q.isEmpty()) {
            Node a = q.poll();

            if (visited[a.B]) {
                continue;
            }

            visited[a.B] = true;
            sum += a.val;

            for (Node b : graph[a.B]) {
                if (!visited[b.B]) {
                    q.add(b);
                }
            }
        }

        System.out.println(sum);
    }
}


class Node implements Comparable<Node> {
    int B, val;

    Node(int B, int val) {
        this.B = B;
        this.val = val;
    }

    @Override
    public int compareTo(Node a) {
        return val - a.val;
    }
}
