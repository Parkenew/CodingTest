import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] adj; //인접행렬
    static StringBuilder sb;
    static boolean[] visited;
    static int last;
    static int cnt=0;
    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        adj=new int[N+1][2];
        sb=new StringBuilder();
        visited=new boolean[N+1];
        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            int parent=Integer.parseInt(st.nextToken());
            for (int j = 0; j < 2; j++) {
                int child=Integer.parseInt(st.nextToken());
                if(child!=-1){
                    adj[parent][j]=child;
                }
            }
        }

        InOrder(1);
        LikeInOrder(1);

    }

    private static void InOrder(int node){
        if(adj[node][0]!=0){
            InOrder(adj[node][0]);
        }
        last=node;
        if(adj[node][1]!=0){
            InOrder(adj[node][1]);
        }
    }

    private static void LikeInOrder(int node){

        
        sb.append(node);
        if(adj[node][0]!=0){
            cnt++;
            LikeInOrder(adj[node][0]);
            cnt++;
        }

 
        if(node==last){
            System.out.println(cnt);
            System.exit(0);
        }

        if(adj[node][1]!=0){
            cnt++;
            LikeInOrder(adj[node][1]);
            cnt++;
        }
        
    }

}
