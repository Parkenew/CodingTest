import javax.xml.crypto.dsig.Transform;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr;
    static long total;
    static int line,start,end;
    static long num;
    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        st = new StringTokenizer(br.readLine());
        start=0;
        end=0;
        for (int i = 0; i < N; i++) {
            arr[i]  = Integer.parseInt(st.nextToken());
            end = Math.max(end,arr[i]);
        }
        total= Long.parseLong(br.readLine());
        /*-------------------------------------------*/



        while(start<=end){
            num=0;
            line=(end+start)/2;
            for (int i = 0; i < N; i++) {
                num += Math.min(arr[i], line);
            }
            if(num<=total){
                start=line+1;
            } else end=line-1;

        }

        System.out.println(end);
    }


}
