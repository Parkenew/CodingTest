import java.io.*;
import java.util.*;

public class Main {
        static StringTokenizer st;
        static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        static StringBuilder sb=new StringBuilder();
        static int K;
        static int V,E;
        static int u,v;
        static List<Integer>[] graph;
        static HashSet<Integer>[] visited;
        static ArrayDeque<int[]> stack;
        public static void main(String[] args) throws IOException {
                K=Integer.parseInt(br.readLine());
                for (int i = 0; i < K; i++) {
                        st=new StringTokenizer(br.readLine());
                        V=Integer.parseInt(st.nextToken());
                        E=Integer.parseInt(st.nextToken());
                        graph=new ArrayList[V+1];
                        for (int j = 0; j < V+1; j++) {
                                graph[j]=new ArrayList<>();
                        }
                        visited=new HashSet[2];
                        for (int j = 0; j < 2; j++) {
                                visited[j]=new HashSet<>();
                        }
                        for (int j = 0; j < E; j++) {
                                st=new StringTokenizer(br.readLine());
                                u=Integer.parseInt(st.nextToken());
                                v=Integer.parseInt(st.nextToken());
                                graph[u].add(v);
                                graph[v].add(u);

                        }
                        boolean flag=true;
                        for (int j = 1; j < V+1; j++) {
                                if(!visited[0].contains(j)&&!visited[1].contains(j)){
                                        if(!dfs(j)){
                                                flag=false;
                                                break;
                                        }
                                }
                        }
                        if(flag){
                                sb.append("YES\n");
                        }else sb.append("NO\n");
                }
                System.out.println(sb);
        }

        static boolean dfs(int startNode) {
                stack=new ArrayDeque<>();
                visited[0].add(startNode);
                stack.addLast(new int[]{startNode, 0});
                while(!stack.isEmpty()){
                        int[] arr=stack.removeLast();
                        int curNode=arr[0];
                        int curSet=arr[1];
                        int nextSet=(curSet+1)%2;
                        for(int next:graph[curNode]){
                                if(visited[curSet].contains(next)){
                                    return false;
                                }
                                if(!visited[nextSet].contains(next)){
                                        visited[nextSet].add(next);
                                        stack.addLast(new int[]{next,nextSet});
                                }
                        }
                }
                return true;
        }







}