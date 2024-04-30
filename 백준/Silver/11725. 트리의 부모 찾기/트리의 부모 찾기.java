import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb=new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer>[] adj;
    static int[] visited;
    static int startNode=1;
    public static void main(String[] args) throws IOException {
        int V = Integer.parseInt(br.readLine());
        visited=new int[V+1];
        visited[1]=1;
        adj=new ArrayList[V+1];

        for(int i=1;i<V+1;i++){
            adj[i]=new ArrayList<>();
        }

        for (int i = 0; i < V-1; i++) {
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            adj[start].add(end);
            adj[end].add(start);
        }

        ArrayDeque<Integer> Q=new ArrayDeque<>(Arrays.asList(startNode));
        while(!Q.isEmpty()){
            int cur=Q.removeFirst();
            for (int ints: adj[cur]){
                if(visited[ints]==0){
                    Q.addLast(ints);
                } else visited[cur]=ints;
            }
        }
        for (int i = 2; i < V+1; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

}