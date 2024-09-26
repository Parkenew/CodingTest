
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int N,M;
    static List<Integer>[] adj;
    static int[] inDgree;
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        adj=new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            adj[i]=new ArrayList<>();
        }
        inDgree=new int[N+1];
        pq=new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            adj[a].add(b);
            inDgree[b]++;
        }
        for (int i = 1; i < N+1; i++) {
            if(inDgree[i]==0){
                pq.add(i);
            }
        }
        while (!pq.isEmpty()) {
            int v=pq.poll();
            sb.append(v).append(" ");
            for(int w:adj[v]){
                if(--inDgree[w]==0){
                    pq.add(w);
                }
            }
        }
        System.out.println(sb);

    }



}
