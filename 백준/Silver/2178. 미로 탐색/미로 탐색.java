import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,1,-1};
    static boolean[][] visited;
    static int[][] adj;
    static ArrayDeque<int[]> q;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        adj=new int[N][M];
        q=new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                adj[i][j] = line.charAt(j)-48;
            }
        }
        q.add(new int[]{0,0});
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int r=arr[0];
            int c=arr[1];
            for (int i = 0; i < 4; i++) {
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr<0||nc<0||nr>=N||nc>=M||adj[nr][nc]==0) continue;
                if(!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    adj[nr][nc]=adj[r][c]+1;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        System.out.println(adj[N-1][M-1]);
    }


}