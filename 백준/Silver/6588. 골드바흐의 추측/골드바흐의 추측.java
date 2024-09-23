import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int  n;
    static boolean[] visited;
    static boolean check;
    public static void main(String[] args) throws IOException {
        visited=new boolean[1_000_000];
        visited[0] = visited[1] = true; // 소수는 false
        check=false;
        for (int i = 2; i < visited.length; i++) {
            if (!visited[i]) {
                for (int j = i + i; j < visited.length; j += i) {
                    visited[j] = true;
                }
            }

        }
        while(true){
            n=Integer.parseInt(br.readLine());
            if(n==0) break;
            for (int i = 2; i <= n/2; i++) {
                if(!visited[i]&&!visited[n-i]) {
                    sb.append(n).append(" = ").append(i).append(" + ").append(n-i).append("\n");
                    check=true;
                    break;
                }
            }
            if(!check) {
                sb.append("Goldbach's conjecture is wrong.");
            }




        }
        System.out.println(sb);
    }





}