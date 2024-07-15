//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int cnt=0;


    public static void main(String[] args) throws IOException {
        int n =Integer.parseInt(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n ; i++) {
            queue.addLast(i);
        }
        int answer;
        while (queue.size() != 1) {
            queue.removeFirst();
            int temp=queue.removeFirst();
            queue.addLast(temp);
        }
        answer = queue.removeFirst();
        System.out.println(answer);
    }

}