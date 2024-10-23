import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int N,M;
    static int[] inDgree;
    static ArrayList<Integer>[] adj;
    static ArrayDeque<Integer> queue;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        inDgree=new int[N+1];
        answer=new int[N+1];
        adj=new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            adj[i]=new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            adj[a].add(b);
            inDgree[b]++;
        }
        queue=new ArrayDeque<>();
        for (int i = 1; i < N+1; i++) {
            if(inDgree[i]==0){
                queue.addLast(i);
            }
        }
        int cnt=1;
        while (!queue.isEmpty()) {
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                int a=queue.removeFirst();
                answer[a]=cnt;
                for (int b : adj[a]) {
                    if(--inDgree[b]==0){
                        queue.addLast(b);
                    }
                }
            }
            cnt++;
        }

        for (int i = 1; i < N+1; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}

