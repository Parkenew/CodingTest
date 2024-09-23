import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int N,M;
    static int[] arr, com;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N];

        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        visited=new boolean[N];
        //조합크기
        com=new int[M];
        BackTrack(0);

        System.out.println(sb);


    }
    private static void BackTrack(int depth){
        if(depth==M){
            for (int i = 0; i < depth; i++) {
                sb.append(com[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 0; i < N; i++) {
                if(!visited[i]){
                    visited[i]=true;
                    com[depth]=arr[i];
                    BackTrack(depth+1);
                    visited[i]=false;
                }
            }
        }
    }

}