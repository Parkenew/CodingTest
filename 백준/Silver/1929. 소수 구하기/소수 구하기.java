import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int M,N;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        for (int i = M; i <= N; i++) {
            if(isPrime(i)){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean isPrime(int n){
        if (n > 3) {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }
        return n != 1;
    }

}