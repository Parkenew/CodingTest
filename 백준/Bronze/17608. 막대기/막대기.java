import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n=Integer.parseInt(br.readLine());
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int bar=Integer.parseInt(br.readLine());
            stack.addLast(bar);
        }
        int cnt=1;
        int last=stack.removeLast();
        while(!stack.isEmpty()){
            int next=stack.removeLast();
            if(last<next) {
                cnt++;
                last=next;
            }
        }
        System.out.println(cnt);
    }
}
