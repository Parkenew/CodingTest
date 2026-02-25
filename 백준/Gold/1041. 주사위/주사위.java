import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static long N;
    static long[] arr;
    static long max=Long.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        N = Long.parseLong(br.readLine());
        arr = new long[6];
        st= new StringTokenizer(br.readLine());
        int total=0;
        for (int i = 0; i < 6; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            max=Math.max(max,arr[i]);
            total+=arr[i];
        }
        
        if(N==1){
            System.out.println(total-max);
            return;
        }
        long a = Math.min(arr[0],arr[5]);
        long b = Math.min(arr[1],arr[4]);
        long c = Math.min(arr[2],arr[3]);
        long min1=Math.min(a,b);
        min1=Math.min(min1,c);

        long min2=Math.min(a+b,a+c);
        min2=Math.min(min2,b+c);

        long sum = 0;
        sum += 4*(a+b+c);
        sum += ((N-1)*4+(N-2)*4)*min2;
        sum += 4*(N-2)*(N-1)*min1+(N-2)*(N-2)*min1;
        System.out.println(sum);
    }

}