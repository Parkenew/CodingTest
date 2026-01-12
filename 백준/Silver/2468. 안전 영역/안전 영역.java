import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] region;
    static boolean[][] visited;
    static int h=Integer.MIN_VALUE;
    static int max=1;
    static ArrayDeque<int[]> stack;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,1,-1};
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        region = new int[N][N];
        for (int i = 0; i < N; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                region[i][j] = Integer.parseInt(st.nextToken());
                h=Math.max(h,region[i][j]);
            }
        }
        for (int rain = 1; rain < h; rain++) {
            visited = new boolean[N][N];
            stack = new ArrayDeque<>();
            int cnt=0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(dfs(rain,j,k)) cnt++;
                }
            }
            max=Math.max(max,cnt);
        }

        System.out.println(max);
    }

    static boolean dfs(int rain, int r, int c){
        if(visited[r][c] || region[r][c]-rain<=0) return false;
        stack.addLast(new int[]{r,c});
        visited[r][c] = true;
        while(!stack.isEmpty()){
            int[] now= stack.removeLast();
            int nowR=now[0];
            int nowC=now[1];

            for (int i = 0; i < 4; i++) {
                int nr=nowR+dr[i];
                int nc=nowC+dc[i];
                if(nr>N-1 || nr<0 || nc>N-1 || nc<0 ) continue;
                if(!visited[nr][nc] && region[nr][nc]-rain>0) {
                    stack.addLast(new int[]{nr,nc});
                    visited[nr][nc] = true;
                }
            }
        }
        return true;
    }

}