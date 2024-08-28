import java.awt.print.Pageable;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[][] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr=new int[n][2];
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            arr[i][0]=x;
            arr[i][1]=y;
        }
        sb=new StringBuilder();
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]!=o2[1]){
                    return o1[1]-o2[1];
                } else{
                    return o1[0]-o2[0];
                }
            }
        });
        for (int i = 0; i < n; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]);
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();

    }


}

