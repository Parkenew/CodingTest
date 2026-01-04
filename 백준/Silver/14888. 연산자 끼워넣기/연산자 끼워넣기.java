import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb=new StringBuilder();
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr;
    static int[] cal;
    static int max=Integer.MIN_VALUE;
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        cal=new int[4];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cal[i]=Integer.parseInt(st.nextToken());
        }
        dfs(0,arr[0]);
        sb.append(max).append("\n").append(min);
        System.out.println(sb);
    }
    static void dfs(int depth,int result){
        if (depth == N-1) {
            max=Math.max(max,result);
            min=Math.min(min,result);
        } else {
            for (int i = 0; i < 4; i++) {
                if (cal[i]>0){
                    cal[i]--;
                    int x=0;
                    if(i==0) x=result+arr[depth+1];
                    else if(i==1) x=result-arr[depth+1];
                    else if(i==2) x=result*arr[depth+1];
                    else x=result/arr[depth+1];
                    dfs(depth+1,x);
                    cal[i]++;
                }
            }
        }

    }
    
}