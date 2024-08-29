import java.awt.print.Pageable;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n,k;
    static int[][] arr;
    static int num=10_007;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        arr=new int[n+1][n+1];
        int result= bc(n,k);
        System.out.println(result);
    }
    public static int bc(int N, int K) {
        if(K==0 || N==K) return 1;

        if(arr[N][K]==0) arr[N][K] = (bc(N-1, K-1) + bc(N-1, K))%num ;

        return arr[N][K];
    }


}

