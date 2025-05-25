import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[][] adj,prefix;

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        adj=new int[n+1][n+1];
        prefix=new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                adj[i][j]=Integer.parseInt(st.nextToken());
                prefix[i][j]=adj[i][j]+prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1];

            }
        }
        sb=new StringBuilder();
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());

            int result=prefix[x2][y2]-prefix[x2][y1-1]-prefix[x1-1][y2]+prefix[x1-1][y1-1];
            sb.append(result).append("\n");
        }
        System.out.println(sb);

    }
}
