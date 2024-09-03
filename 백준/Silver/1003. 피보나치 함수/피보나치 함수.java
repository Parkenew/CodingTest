import java.awt.print.Pageable;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int t;
    static int[][] arr= new int[41][2];;
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {
        arr[0][0]=1;
        arr[0][1]=0;
        arr[1][0]=0;
        arr[1][1]=1;
        arr[2][0]=1;
        arr[2][1]=1;

        for (int i = 3; i < 41; i++) {
            arr[i][0]=arr[i-1][0]+arr[i-2][0];
            arr[i][1]=arr[i-1][1]+arr[i-2][1];

        }


        t= Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n][0]).append(" ").append(arr[n][1]).append("\n");
        }
        System.out.println(sb);
    }

}

