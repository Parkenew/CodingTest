import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static PriorityQueue<Integer> pq=new PriorityQueue<>();

    static ArrayDeque<int[]> q=new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        int n=Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num=Integer.parseInt(st.nextToken());
                pq.offer(num);
                if(pq.size()>n) pq.poll();
            }
        }

        System.out.println(pq.poll());
        // 11 12 13 15 19
        // 5 7 8
        // -> 제일 큰 수 5개만 남음
    }


}

