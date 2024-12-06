import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] check;
    static int[] sel;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        check=new int[N];
        sel=new int[N];
        for (int i = 0; i < N; i++) arr[i]=i+1;
        BackTracking(0);
        System.out.println(sb);

    }
    public static void BackTracking(int depth){
        if(depth==N){
            for(int i=0;i<N;i++){
                sb.append(sel[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (check[i] == 0) { // 만약 그 자리가 비워져있고 쓸 수 있으면?
                 check[i] = 1;
                 sel[depth] = arr[i];
                 BackTracking(depth+1);
                 check[i] = 0;
            }
        }
    }
}
