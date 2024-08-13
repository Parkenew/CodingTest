import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
       int k=Integer.parseInt(br.readLine());

       ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n!=0){
                stack.add(n);
            } else stack.removeLast();
        }
        int cnt=0;
        while(!stack.isEmpty()){
            cnt +=stack.removeLast();
        }
        System.out.println(cnt);
    }
}

