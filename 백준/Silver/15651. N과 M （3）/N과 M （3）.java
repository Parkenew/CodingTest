import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb=new StringBuilder();
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M;
    static boolean[] visited;
    static int[] arr;
    static int[] num;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        num=new int[N];
        for(int i=0;i<N;i++) num[i]=i+1;
        visited=new boolean[M];
        arr=new int[M];
        dfs(0);
        System.out.println(sb);
    }
    static void dfs(int depth){
        if(depth==M){
            for(int i: arr){
                sb.append(i).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 0; i < N; i++) {
                if(!visited[depth]){
                    visited[depth]=true;
                    arr[depth]=num[i];
                    dfs(depth+1);
                    visited[depth]=false;
                }
            }
        }
    }

}