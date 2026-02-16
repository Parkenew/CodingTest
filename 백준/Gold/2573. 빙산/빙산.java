import java.io.*;
import java.util.*;

public class Main {
        static StringTokenizer st;
        static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        static StringBuilder sb=new StringBuilder();
        static int N,M;
        static int[][] iceberg;
        static boolean[][] visited;
        static int[] dr={1,-1,0,0};
        static int[] dc={0,0,-1,1};
        static ArrayDeque<int[]> q;
        public static void main(String[] args) throws IOException {
                st=new StringTokenizer(br.readLine());
                N=Integer.parseInt(st.nextToken());
                M=Integer.parseInt(st.nextToken());
                iceberg=new int[N][M];

                for (int i = 0; i < N; i++) {
                        st=new StringTokenizer(br.readLine());
                        for (int j = 0; j < M; j++) {
                                iceberg[i][j]=Integer.parseInt(st.nextToken());
                        }
                }
                int year=0;
                while(true){
                        int flag=check();
                        if(flag==0){
                                System.out.println(0);
                                System.exit(0);
                        } else if (flag>=2) {
                                break;
                        }
                        year++;
                }
                System.out.println(year);
        }

        static int check() {
                int cnt=0;
                visited=new boolean[N][M];
                for (int i = 0; i < N; i++) {
                        for (int j = 0; j < M; j++) {
                                if(!visited[i][j]&&iceberg[i][j]!=0) {
                                       bfs(i,j);
                                       cnt++;
                                }
                        }
                }

                for (int i = 0; i < N; i++) {
                        for (int j = 0; j < M; j++) {
                                sb.append(iceberg[i][j]).append(" ");
                        }
                        sb.append("\n");
                }

                return cnt;
        }

        static void bfs(int r, int c) {
                q=new ArrayDeque<>();
                visited[r][c]=true;
                q.addLast(new int[]{r,c});
                while(!q.isEmpty()) {
                        int[] arr=q.removeFirst();
                        int cur_r=arr[0];
                        int cur_c=arr[1];
                        int cnt=0;
                        for (int i = 0; i < 4; i++) {
                                int nr=cur_r+dr[i];
                                int nc=cur_c+dc[i];

                                if (nr<0 || nc<0 || nr>=N || nc>=M || visited[nr][nc]) continue;
                                if (iceberg[nr][nc]==0) {
                                        cnt++;
                                }
                                else {
                                        visited[nr][nc]=true;
                                        q.addLast(new int[]{nr,nc});
                                }
                        }
                        iceberg[cur_r][cur_c]=Math.max(0,iceberg[cur_r][cur_c]-cnt);
                }
        }











}