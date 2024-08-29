import java.awt.print.Pageable;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n,x;
    static int[] arr;
    static StringBuilder sb;
    static int cnt,max;
    public static void main(String[] args) throws IOException {
        st= new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        x=Integer.parseInt(st.nextToken());
        arr=new int[n];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        cnt=1;
        // 7 5
        // 1 1 1 1 1 5 1
        // 0 1 2
        int sum = 0;
        for (int i = 0; i < x; i++) {
            sum+=arr[i];
        }
        max=sum;

        for (int i = x; i < n ; i++) {
            sum += arr[i] - arr[i-x];
            if(sum>max){
                max=sum;
                cnt=1;
            } else if(sum==max) cnt++;
        }
        sb=new StringBuilder();
        if(max==0){
            System.out.println("SAD");
        } else {
            sb.append(max).append("\n").append(cnt);
            System.out.println(sb);
        }
        br.close();
    }


}

