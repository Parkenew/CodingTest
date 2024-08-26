import java.awt.print.Pageable;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] arr=new int[n];
        st= new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        int lastIdx;
        int cnt=0;
        for (int firstIdx = 0; firstIdx < n; firstIdx++) {
            lastIdx=n-1;
            while(lastIdx>firstIdx){
                if(arr[firstIdx]+arr[lastIdx]==x){
                    cnt++;
                    break;
                }
                lastIdx--;
            }
        }
        System.out.println(cnt);
    }


}

