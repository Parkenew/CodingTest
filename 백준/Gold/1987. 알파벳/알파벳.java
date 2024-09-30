import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int R,C;
    static int[][] board;
    static int[] dr= {-1,1,0,0};
    static int[] dc= {0,0,1,-1};
    static boolean[] visited;
    static int cnt=0;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        visited=new boolean[26];
        board=new int[R][C];
        for(int i=0;i<R;i++){
            String line=br.readLine();
            for(int j=0;j<C;j++){
                board[i][j]=line.charAt(j)-'A';
            }
        }

        dfs(0,0,1);
        System.out.println(cnt);
    }

    private static void dfs(int r,int c,int length){
        visited[board[r][c]]=true;
        cnt=Math.max(cnt,length);
        for (int i = 0; i < 4; i++) {
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(nr<0||nr>=R||nc<0||nc>=C) continue;
            if(!visited[board[nr][nc]]){
                dfs(nr,nc,length+1);
            }
        }
        visited[board[r][c]]=false;
    }
}