import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static PriorityQueue<Node> pq=new PriorityQueue<>();
    static ArrayDeque<int[]> q=new ArrayDeque<>();
    static int n,m;
    static ArrayList<Node>[] adj;
    static boolean[] visited;
    static long[] dist;
    static long inf=Long.MAX_VALUE;
    static int startNode;
    static int endNode;
    static class Node implements Comparable<Node>{
        long distance;
        int nodeNum;
        public Node(int nodeNum, long distance) {
            this.distance = distance;
            this.nodeNum = nodeNum;
        }
        @Override
        public int compareTo(Node o) {
            return Long.compare(distance, o.distance);
        }
    }
    public static void main(String[] args) throws IOException {
        n=Integer.parseInt(br.readLine());
        m=Integer.parseInt(br.readLine());
        adj=new ArrayList[n+1];
        visited=new boolean[n+1];
        dist=new long[n+1];
        for (int i = 0; i < n+1; i++) {
            adj[i]=new ArrayList<>();
            dist[i]=inf;
        }

        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            long price=Integer.parseInt(st.nextToken());
            adj[start].add(new Node(end, price));
        }
        st=new StringTokenizer(br.readLine());
        startNode=Integer.parseInt(st.nextToken());
        endNode=Integer.parseInt(st.nextToken());
        dijkstra();
        System.out.println(dist[endNode]);

    }
    private static void dijkstra() {
        pq.offer(new Node(startNode, 0));
        dist[startNode]=0;
        while (!pq.isEmpty()) {
            Node cur=pq.poll();
            long distance=cur.distance;
            int nodeNum=cur.nodeNum;
            
            if(dist[nodeNum]<distance){
                continue;
            }
            for (Node next : adj[nodeNum]) {
                int nextNodeNum=next.nodeNum;
                long nextDistance=next.distance;
                if(dist[nextNodeNum]>nextDistance+distance){
                    dist[nextNodeNum]=nextDistance+distance;
                    pq.offer(new Node(nextNodeNum, dist[nextNodeNum]));
                }
            }
        }
    }
}

