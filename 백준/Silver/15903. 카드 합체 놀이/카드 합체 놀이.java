//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder stringBuilder=new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));;
    static long N,M;
    static long[] arr;
    static PriorityQueue<Long> pq;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Long.parseLong(st.nextToken());
        M=Long.parseLong(st.nextToken());
        pq=new PriorityQueue<>();
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }
        while(M>0){
            long first=pq.poll();
            long second=pq.poll();
            long sum=first+second;
            first=sum;
            second=sum;
            pq.offer(first);
            pq.offer(second);
            M--;
        }

        long result=0;
        while(!pq.isEmpty()){
            result+=pq.poll();
        }
        System.out.println(result);

    }
}