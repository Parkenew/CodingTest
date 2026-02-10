import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
        static StringTokenizer st;
        static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        static StringBuilder sb;
        static int N,M;
        static int[][] adj;
        static boolean[][] visited;
        static ArrayDeque<int[]> q;
        static int[] dr={1,-1,0,0};
        static int[] dc={0,0,-1,1};

        public static void main(String[] args) throws IOException {
                st=new StringTokenizer(br.readLine());
                M=Integer.parseInt(st.nextToken());
                N=Integer.parseInt(st.nextToken());
                
                adj=new int[N][M];
                visited=new boolean[N][M];

                for (int i = 0; i < N; i++) {
                        String str=br.readLine();
                        for (int j = 0; j < M; j++) {
                                adj[i][j]=Integer.parseInt(str.charAt(j)+"");
                        }
                }
                bfs(0,0);
        }
        static void bfs(int i, int j) {
                q=new ArrayDeque<>();
                visited[i][j]=true;
                q.addLast(new int[]{i,j,0});
                while (!q.isEmpty()) {
                        int[] arr=q.removeFirst();
                        int r=arr[0];
                        int c=arr[1];
                        int cnt=arr[2];
                        if (r==N-1 && c==M-1) {
                                System.out.println(cnt);
                                break;
                        }
                        for (int k = 0; k < 4; k++) {
                                int nr=r+dr[k];
                                int nc=c+dc[k];
                                if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
                                if(!visited[nr][nc]) {
                                        visited[nr][nc]=true;
                                        if(adj[nr][nc]==1) {
                                                q.addLast(new int[]{nr,nc,cnt+1});
                                        } else {
                                                q.addFirst(new int[]{nr,nc,cnt});
                                        }
                                }
                        }
                }

        }





}