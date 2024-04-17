import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.lang.StringBuilder;


public class Main {
    static PriorityQueue<Integer> maxHeap;
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb=new StringBuilder();
    public static void main(String arg[])throws IOException{
        int N=Integer.parseInt(br.readLine());
        maxHeap=new PriorityQueue<>(Comparator.comparingInt(s->-s));
        int max;
        for(int i=0;i<N;i++){
            int x=Integer.parseInt(br.readLine());
            if(x==0){
                if(maxHeap.isEmpty()){
                    max=0;
                } else max=maxHeap.poll();
                sb.append(max).append("\n");
            } else maxHeap.offer(x);
        }
        System.out.println(sb);
    }
}