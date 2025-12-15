import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb=new StringBuilder();
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M;
    static int[] output;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N];
        output=new int[M];
        visited=new boolean[N];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0);
        System.out.println(sb);

    }
    static void dfs(int depth){
        if (depth==M){
            for (int i=0;i<M;i++){
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int prev=0;
        for (int i = 0; i < N; i++) {
            if(visited[i])continue;
            if(prev==arr[i]) continue;
            prev=arr[i];
            visited[i]=true;
            output[depth]=arr[i];
            dfs(depth+1);
            visited[i]=false;
        }

    }


}