import java.io.*;
import java.math.BigInteger;
import java.util.*;
class Edge implements Comparable<Edge> {
    int w;
    int cost;
    public Edge(int w, int cost) {
        this.w = w;
        this.cost = cost;

    }
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Edge>[] city;
    static int N,M,t;
    static boolean[] visited;
    static PriorityQueue<Edge> pq;
    static int min;

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        t=  Integer.parseInt(st.nextToken());
        city = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            city[i]= new ArrayList<>();
        }
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            int A,B,C;
            st=new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            city[A].add(new Edge(B, C));
            city[B].add(new Edge(A, C));
        }
        pq= new PriorityQueue<>();
        pq.offer(new Edge(1, 0));
        int cnt=0;
        while (!pq.isEmpty()) {
            Edge e=pq.poll();
            int v=e.w;
            int cost=e.cost;
            if(visited[v]) continue;
            visited[v]=true;
            min += cost;
            
            for (Edge edge : city[v]) {
                if(!visited[edge.w]) {
                    pq.offer(edge);
                }
            }

        }
        System.out.println(min+(N-2)*(N-1)/2*t);
    }


}