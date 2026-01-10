import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb=new StringBuilder();
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M;
    static int[] num,arr;

    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        arr = new int[M];
        visited = new boolean[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        backTracking(0,0);
        System.out.println(sb);
    }


    static void backTracking(int depth,int prev){
        if(depth==M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        } else{
            for (int i = depth; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i]&&num[j]>prev){
                        visited[i]=true;
                        arr[i]=num[j];
                        backTracking(depth+1,arr[i]);
                        visited[i]=false;
                    }
                }
            }
        }
    }
}