//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb=new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static boolean[] visited;
    static class Node {
        int m;
        int k;

        Node( int m, int k){
            this.m = m;
            this.k = k;
        }
    }
    static List<Node>[] graph;
    static int maxDist=0;
    static int farNode;
    public static void main(String[] args) throws IOException {

        String line;
        int maxIndex=0;
        List<int[]> edges = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            if (line.isEmpty()) continue;
            StringTokenizer st=new StringTokenizer(line);
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());
            edges.add(new int[]{n,m,k});
            maxIndex=Math.max(maxIndex,Math.max(n,m));
        }
        if (edges.isEmpty()) {
            System.out.println(0);
            return;
        }
        
        int n=maxIndex;
        graph=new ArrayList[n+1];
        visited=new boolean[n+1];
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        
        for(int[] edge:edges){
            graph[edge[0]].add(new Node(edge[1],edge[2]));
            graph[edge[1]].add(new Node(edge[0],edge[2]));
        }

        visited=new boolean[n+1];
        dfs(edges.get(0)[0]);


        visited=new boolean[n+1];
        maxDist=0;
        dfs(farNode);

        System.out.println(maxDist);
    }

    static public void dfs(int start){
        ArrayDeque<int[]> stack=new ArrayDeque<>();
        stack.push(new int[]{start,0});
        visited[start]=true;

        while(!stack.isEmpty()){
            int[] cur=stack.removeLast();
            int node=cur[0];
            int dist=cur[1];
            if (dist>maxDist){
                maxDist=dist;
                farNode=node;
            }

            for(Node next: graph[node]){
                if(!visited[next.m]){
                    visited[next.m]=true;
                    stack.push(new int[]{next.m,dist+next.k});
                }
            }
        }

    }
}