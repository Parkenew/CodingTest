import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int n,m;
    static int[][] drawing;
    static boolean[][] visited;
    static int max=0,count=0,draw_count=0;
    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};
    static ArrayDeque<int[]> q=new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        drawing=new int[n][m];
        visited=new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                drawing[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(drawing[i][j]==1 && !visited[i][j]){
                    draw_count++;
                    bfs(i,j);
                    max=Math.max(max,count);
                }
            }
        }
        sb.append(draw_count).append("\n").append(max);
        System.out.println(sb);
    }

    private static void bfs(int r, int c){
        visited[r][c]=true;
        count=0;
        q.addLast(new int[]{r,c});
        while(!q.isEmpty()){
            count++;
            int[] a=q.removeFirst();
            int cur_r=a[0];
            int cur_c=a[1];
            for (int i = 0; i < 4; i++) {
                int new_r=cur_r+dr[i];
                int new_c=cur_c+dc[i];
                if (new_r<0||new_r>=n||new_c<0||new_c>=m) continue;
                if (visited[new_r][new_c]||drawing[new_r][new_c]==0) continue;
                q.addLast(new int[]{new_r,new_c});
                visited[new_r][new_c]=true;
            }
        }
    }
}

