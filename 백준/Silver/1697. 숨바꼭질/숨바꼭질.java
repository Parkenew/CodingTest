import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,k;
    static int[] visited;
    static ArrayDeque<Integer> q;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new int[100_001];
        
        if(n==k){
            System.out.println("0");
        } else bfs();

    }
    public static void bfs() {
        q= new ArrayDeque<>();
        q.add(n);
        while (!q.isEmpty()) {
            int cur = q.removeFirst();
            for (int i = 0; i < 3; i++) {
                int next;
                if(i==0){
                    next=cur+1;
                } else if(i==1){
                    next=cur-1;
                } else next=cur*2;
                
                if(next >=0 && next < visited.length && visited[next]==0){
                    q.add(next);
                    visited[next]=visited[cur]+1;
                }
                
                if(next==k){
                    System.out.println(visited[k]);
                    return;
                }
            }
        }
    }

}