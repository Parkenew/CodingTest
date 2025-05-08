import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static PriorityQueue<Integer> pq=new PriorityQueue<>();

    static ArrayDeque<int[]> q=new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());//도시의 개수
        int m=Integer.parseInt(st.nextToken());//도로의 개수
        int k=Integer.parseInt(st.nextToken());//거리 정보
        int x=Integer.parseInt(st.nextToken());//출발 도시 번호


        List<List<Integer>> list=new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist,-1);

        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken()); //출발
            int b=Integer.parseInt(st.nextToken()); //도착
            list.get(a).add(b);
        }


        ArrayDeque<Integer> q=new ArrayDeque<>();
        q.addLast(x);
        dist[x]=0;

        while (!q.isEmpty()) {
            int cur=q.removeFirst(); //실수를 하지 말자
            for (int node: list.get(cur)) {
                if(dist[node]==-1){
                    dist[node]=dist[cur]+1;
                    q.addLast(node);
                }
            }
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (dist[i] == k) {
                pq.add(i);
            }
        }
        if (pq.isEmpty()) {
            sb.append("-1\n");
        } else {
            while (!pq.isEmpty()) {
                sb.append(pq.poll()).append("\n");
            }
        }

        System.out.print(sb);
    }


}

