import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();

    static ArrayDeque<int[]> q=new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        int t=Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                st=new StringTokenizer(br.readLine());
            }
            sb.append(n-1).append("\n");
        }
        System.out.println(sb);
    }


}

