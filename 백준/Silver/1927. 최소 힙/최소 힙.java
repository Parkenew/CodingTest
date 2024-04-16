import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {
    static PriorityQueue<Integer> minHeap  = new PriorityQueue<>();
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb=new StringBuilder();
    public static void main(String arg[]) throws IOException {

        int N=Integer.parseInt(br.readLine());
        int min = 0;
        for(int i=0;i<N;i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if(minHeap.isEmpty()){
                    min=0;
                } else min = minHeap.poll();//힙 삭제
          
                sb.append(min).append("\n");
            } else minHeap.offer(x);

        }
        System.out.println(sb);
    }
}