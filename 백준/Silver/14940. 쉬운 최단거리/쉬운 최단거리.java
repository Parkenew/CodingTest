import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int N,M;
    static int[][] map,count;
    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,-1,1};
    static ArrayDeque<int[]> q=new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        count=new int[N][M];

        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    q.add(new int[]{i,j});
                    count[i][j]=0;
                } else if(map[i][j]==1){
                    count[i][j]=-1;
                }
            }
        }

        while(!q.isEmpty()){
            int[] arr=q.poll();
            int r=arr[0];
            int c=arr[1];
            
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr<0||nr>=N||nc<0||nc>=M) continue;
                if(map[nr][nc]==0){
                    count[nr][nc]=0;
                    continue;
                }
                if(count[nr][nc]==-1){
                    q.add(new int[]{nr,nc});
                    count[nr][nc]=count[r][c]+1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(count[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}