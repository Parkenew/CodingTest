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
    static PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            for (int i = 0; i < M; i++) {
                if(o1[i]!=o2[i]){
                    return o1[i]-o2[i];
                }
            }
            return 0;
        }
    });
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        num=new int[N];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i]=Integer.parseInt(st.nextToken());
        }
        visited=new boolean[M];
        arr=new int[M];
        dfs(0,0);
        while(!pq.isEmpty()){
            int[] a=pq.poll();
            for(int i:a){
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int depth,int prev){
        if(depth==M){
            pq.add(arr.clone());
        }else {
            for (int i = depth; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i]){
                        if(prev<=num[j]){
                            visited[i]=true;
                            arr[i]=num[j];
                            dfs(depth+1,num[j]);
                            visited[i]=false;
                        }
                    }
                }
            }
        }
    }

}