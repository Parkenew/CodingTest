import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int N,M;
    static int cnt=0;
    static int[] cloth;


    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        M=Integer.parseInt(br.readLine());
        cloth=new int[N];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cloth[i]=Integer.parseInt(st.nextToken());
        }
        for (int i = N-2; i >= 0; i--) {
            for (int j = i+1; j < N; j++) {
                if(cloth[i]+cloth[j]==M) cnt++;
            }
        }
        System.out.println(cnt);
    }

}
