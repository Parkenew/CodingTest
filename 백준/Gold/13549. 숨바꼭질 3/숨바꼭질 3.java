import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static int cnt;
    static int[] visited;
    static ArrayDeque<Integer> q=new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[100_001];
        Arrays.fill(visited,100000);
        q.addLast(N);
        visited[N] = 0;
        while(!q.isEmpty()){
            int n= q.removeFirst();
            
            if(n*2< 100001 && (visited[n*2]>visited[n])){
                visited[n*2]=visited[n];
                q.addFirst(n*2);
            }

            if(n+1 < 100001 && (visited[n]+1<visited[n+1]) ){
                visited[n+1]=visited[n]+1;
                q.addLast(n+1);
            }

            if(n-1 >= 0 && (visited[n]+1<visited[n-1]) ){
                visited[n-1]=visited[n]+1;
                q.addLast(n-1);
            }

        }
        System.out.println(visited[K]);
    }



}