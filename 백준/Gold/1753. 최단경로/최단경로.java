import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int nodeNum;
        int distance;
        public Node(int nodeNum, int distance) {
            this.nodeNum = nodeNum;
            this.distance = distance;
        }
        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int V,E;
    static int start;
    static ArrayList<Node>[] adj;
    static PriorityQueue<Node> pq=new PriorityQueue<>();
    static int[] dist;
    static int inf=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        V=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());
        start=Integer.parseInt(br.readLine());
        adj=new ArrayList[V+1];
        dist=new int[V+1];
        for (int i = 0; i < V+1; i++) {
            adj[i]=new ArrayList<>();
            dist[i]=inf;
        }

        for (int i = 0; i < E; i++) {
            st=new StringTokenizer(br.readLine());
            int startNode=Integer.parseInt(st.nextToken());
            int endNode=Integer.parseInt(st.nextToken());
            int distance=Integer.parseInt(st.nextToken());
            adj[startNode].add(new Node(endNode, distance));
        }
        dijkstra();
        for (int i = 1; i < V+1; i++) {
            if(dist[i]==inf){
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
    private static void dijkstra() {
        pq.offer(new Node(start,0));
        dist[start]=0;
        while(!pq.isEmpty()){
            Node cur=pq.poll();
            int nodeNum=cur.nodeNum;
            int distance=cur.distance;

            if (dist[nodeNum]<distance) continue;

            for(Node next:adj[nodeNum]){
                int nextNodeNum=next.nodeNum;
                int nextDistance=next.distance;
                int nextNodeDistance=distance+nextDistance;
                if(dist[nextNodeNum]>nextNodeDistance){
                    dist[nextNodeNum]=nextNodeDistance;
                    pq.offer(new Node(nextNodeNum,nextNodeDistance));
                }
            }

        }
    }
}

