import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M,K;
    static int[][] map;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,1,-1};
    static boolean[][] visited;
    static ArrayDeque<int[]> stack=new ArrayDeque<>();
    static int max=Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        visited=new boolean[N][M];
        for (int i = 0; i < K; i++) {
            st=new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            map[r-1][c-1]=1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==1){
                    max=Math.max(max,dfs(i,j));
                }
            }
        }
        System.out.println(max);
    }
    static int dfs(int r,int c){
        if(visited[r][c]) return 0;
        stack.addLast(new int[]{r,c});
        visited[r][c]=true;
        int cnt=1;
        while(!stack.isEmpty()){
            int[] cur=stack.removeLast();
            int nowR=cur[0];
            int nowC=cur[1];
            for (int i = 0; i < 4; i++) {
                int newR=nowR+dr[i];
                int newC=nowC+dc[i];
                if(newR<0||newR>=N||newC<0||newC>=M) continue;
                if(!visited[newR][newC]&&map[newR][newC]==1){
                    stack.addLast(new int[]{newR,newC});
                    visited[newR][newC]=true;
                    cnt++;
                }
            }
        }
        return cnt;
    }



}