import java.awt.print.Pageable;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[][] arr;
    static StringBuilder sb=new StringBuilder();
    static boolean flag=true;
    public static void main(String[] args) throws IOException {
       int n = Integer.parseInt(br.readLine());
       arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s=br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }

        }
        DC(0,0,n);
        System.out.println(sb);
        br.close();
    }

    // 행: x 열: y
    public static void DC(int x,int y,int n) {
        flag=true;
        int temp=arr[x][y];
        for (int i = x; i < x + n; i++){
            for (int j = y; j < y + n; j++) {
                if(temp!=arr[i][j]){
                    flag=false;
                    break;
                }
            }
        }

        if(flag){
            sb.append(temp);
        } else {
            sb.append("(");
            int num=n/2;
            DC(x,y,num);
            DC(x,y+num,num);
            DC(x+num,y,num);
            DC(x+num,y+num,num);
            sb.append(")");
        }
    }

}

