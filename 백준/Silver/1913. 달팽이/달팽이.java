import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] snail;
    static int r=0,c=0,d=0;
    public static void main(String[] args) throws IOException {
        int n=Integer.parseInt(br.readLine());
        int target=Integer.parseInt(br.readLine());
        snail = new int[n][n];

        for (int i = n*n; i > 0 ; i--) {
            snail[r][c] = i;
            int nr=r+dr[d];
            int nc=c+dc[d];

            if(nr<0 || nc<0 || nr>=n || nc>=n || snail[nr][nc]!=0) {
                d=(d+1)%4;
                nr=r+dr[d];
                nc=c+dc[d];
            }
            r=nr;
            c=nc;
        }

        int tr=0,tc=0;
        for (int i = 0; i < snail.length; i++) {
            for (int j = 0; j < snail.length; j++) {
                if(target==snail[i][j]) {
                    tr=i+1;
                    tc=j+1;
                }
                sb.append(snail[i][j]+" ");
            }
            sb.append("\n");
        }
        sb.append(tr+" "+tc);
        System.out.println(sb);
    }

}
