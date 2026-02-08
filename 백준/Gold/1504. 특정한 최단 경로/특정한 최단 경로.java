import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
        static StringTokenizer st;
        static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        static StringBuilder sb;
        static int N,E;
        static List<Node>[] adj;
        static boolean[] visited;
        static int[] dist;
        static int startNode,endNode;
        static int INF = 200000000;
        static class Node implements Comparable<Node>{
                int nodeNum;
                int dist;
                public Node(int nodeNum, int dist) {
                        this.nodeNum = nodeNum;
                        this.dist = dist;
                }

                @Override
                public int compareTo(Node o) {
                        return this.dist-o.dist;
                }
        }
        public static void main(String[] args) throws IOException {
                st=new StringTokenizer(br.readLine());
                N=Integer.parseInt(st.nextToken());
                E=Integer.parseInt(st.nextToken());
                adj=new ArrayList[N+1];
                for (int i = 0; i < N+1; i++) {
                        adj[i]=new ArrayList<>();
                }

                for (int i = 0; i < E; i++) {
                        st=new StringTokenizer(br.readLine());
                        int a=Integer.parseInt(st.nextToken());
                        int b=Integer.parseInt(st.nextToken());
                        int dist=Integer.parseInt(st.nextToken());
                        adj[a].add(new Node(b,dist));
                        adj[b].add(new Node(a,dist));
                }
                st=new StringTokenizer(br.readLine());
                int must1=Integer.parseInt(st.nextToken());
                int must2=Integer.parseInt(st.nextToken());
                startNode=1;
                endNode=N;
                int dist1=dijkstra(startNode,must1)+dijkstra(must1,must2)+dijkstra(must2,endNode);
                int dist2=dijkstra(startNode,must2)+dijkstra(must2,must1)+dijkstra(must1,endNode);
                if(Math.min(dist1,dist2)>=INF){
                        System.out.println(-1);
                }
                else System.out.println(Math.min(dist1,dist2));
        }



        static int dijkstra(int start,int end) {
                PriorityQueue<Node> pq=new PriorityQueue<>();
                visited=new boolean[N+1];
                dist=new int[N+1];
                Arrays.fill(dist,INF);
                dist[start]=0;
                pq.add(new Node(start,0));
                while (!pq.isEmpty()) {
                        Node cur=pq.poll();
                        int curDist=cur.dist;
                        int curNodeNum=cur.nodeNum;

                        if(dist[curNodeNum]>curDist) continue;

                        for(Node next:adj[curNodeNum]) {
                                int nextNode=next.nodeNum;
                                int nextDist=next.dist;
                                if(dist[nextNode]>nextDist+curDist){
                                        dist[nextNode]=nextDist+curDist;
                                        pq.add(new Node(nextNode,dist[nextNode]));
                                }
                        }
                }
                return dist[end];
        }


}