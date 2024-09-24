import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int N,M;
    static ArrayDeque<Integer> q;
    static int[] inDegree;
    static List<Integer>[] adj;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj=new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            adj[i]=new ArrayList<>();
        }
        inDegree=new int[N+1];
        answer=new int[N];

        for (int i = 0; i < M; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            adj[a].add(b);
            inDegree[b]++;
        }
        q=new ArrayDeque<>();
        for (int i = 1; i < N+1; i++) {
            if(inDegree[i]==0){
                q.addLast(i);
            }
        }
        while(!q.isEmpty()){
            int u=q.poll();
            sb.append(u).append(" ");
            for(int v:adj[u]){
                inDegree[v]--;
                if(inDegree[v]==0){
                    q.addLast(v);
                }
            }
        }
        System.out.println(sb);


    }





}