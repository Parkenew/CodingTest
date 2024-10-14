import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] adj; //인접행렬
    static StringBuilder sb;
    static ArrayDeque<Integer> AD;
    static int num;
    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        adj=new int[N+1][2];
        sb=new StringBuilder();
        num = 'A' - 1;
        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            int parent;
            String str=st.nextToken();
            parent=str.charAt(0) - num;
            for(int j=0;j<2;j++){
                str=st.nextToken();
                if(str.equals(".")){
                    continue;
                }
                int child=str.charAt(0) - num;
                adj[parent][j]=child;
            }

        }
        PreOrder(1);
        sb.append("\n");
        InOrder(1);
        sb.append("\n");
        PostOrder(1);
        System.out.println(sb);
    }
    private static void PreOrder(int node){
        char alpha= (char) (node+num);
        sb.append(alpha);
        if(adj[node][0]!=0){
            PreOrder(adj[node][0]);
        }
        if(adj[node][1]!=0){
            PreOrder(adj[node][1]);
        }
    }
    private static void InOrder(int node){
        if(adj[node][0]!=0){
            InOrder(adj[node][0]);
        }
        char alpha= (char) (node+num);
        sb.append(alpha);
        if(adj[node][1]!=0){
            InOrder(adj[node][1]);
        }
    }
    private static void PostOrder(int node){
        if(adj[node][0]!=0){
            PostOrder(adj[node][0]);
        }
        if(adj[node][1]!=0){
            PostOrder(adj[node][1]);
        }
        char alpha= (char) (node+num);
        sb.append(alpha);
    }
}
