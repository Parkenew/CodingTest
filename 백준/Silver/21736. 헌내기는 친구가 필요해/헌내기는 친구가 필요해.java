import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int N,M;
    static char[][] campus;
    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,-1,1};
    static int cnt;
    static ArrayDeque<int[]> queue=new ArrayDeque<>();
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        campus=new char[N][M];
        visited=new boolean[N][M];
        cnt=0;
        for (int i = 0; i < N; i++) {
            String str=br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j]=str.charAt(j);
                if(campus[i][j]=='I'){
                    queue.add(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] arr=queue.poll();
            int r=arr[0];
            int c=arr[1];
            visited[r][c]=true;
            if(campus[r][c]=='P'){cnt++;}
            
            for (int i = 0; i < 4; i++) {
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr<0||nr>=N||nc<0||nc>=M||campus[nr][nc]=='X')continue;
                if(!visited[nr][nc]){
                    visited[nr][nc]=true;
                    queue.add(new int[]{nr,nc});
                }
            }
        }

        if(cnt==0){
            System.out.println("TT");
        } else System.out.println(cnt);

    }

}