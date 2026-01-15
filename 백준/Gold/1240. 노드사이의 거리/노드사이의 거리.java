import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static class node {
        int b;
        int dist;
        public node(int b, int dist) {
            this.b = b;
            this.dist = dist;
        }
    }
    static List<node>[] tree;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        tree=new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int dist=Integer.parseInt(st.nextToken());
            tree[a].add(new node(b,dist));
            tree[b].add(new node(a,dist));
        }
        for (int i = 0; i < M; i++) {
            visited=new boolean[N+1]; 
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            sb.append(dfs(a,b,0));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int dfs(int start,int end, int dist) {
        ArrayDeque<int[]> stack=new ArrayDeque<>();
        stack.addLast(new int[]{start,dist});
        visited[start]=true;
        while (!stack.isEmpty()) {
            int[] curNode=stack.removeLast();
            int curStart=curNode[0];
            int curDist=curNode[1];
            for(node nextNode : tree[curStart]){
                int nextStart=nextNode.b;
                int nextDist=nextNode.dist;
                if(!visited[nextStart]){
                    visited[nextStart]=true;
                    int sum=nextDist+curDist;
                    if(nextStart==end) return sum;
                    stack.addLast(new int[]{nextStart,sum});
                }
            }
        }
        return 0;
    }





}