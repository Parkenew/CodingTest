import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb=new StringBuilder();
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static boolean visited[];
    static int[] arr;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        visited=new boolean[N];
        arr=new int[M];
        backTracking(0);
        System.out.println(sb.toString());
    }

    static void backTracking(int depth){
        if(depth==M){
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                visited[i]=true;
                arr[depth]=i+1;
                backTracking(depth+1);
                visited[i]=false;
            }
        }
    }

}