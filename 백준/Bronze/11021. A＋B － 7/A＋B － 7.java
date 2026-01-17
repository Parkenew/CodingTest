import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            sb.append("Case #").append(i+1).append(": ").append(a+b).append("\n");
        }
        System.out.println(sb);
    }

}