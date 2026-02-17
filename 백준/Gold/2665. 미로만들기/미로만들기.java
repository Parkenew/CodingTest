import java.io.*;
import java.util.*;

public class Main {
        static StringTokenizer st;
        static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        static StringBuilder sb=new StringBuilder();
        static int n;
        static int[][] adj;
        static int[][] dist;
        static ArrayDeque<int[]> q;
        static int[] dr={1,-1,0,0};
        static int[] dc={0,0,-1,1};

        public static void main(String[] args) throws IOException {
                n=Integer.parseInt(br.readLine());
                adj=new int[n][n];
                dist=new int[n][n];
                for (int i = 0; i < n; i++) {
                        String str=br.readLine();
                        for (int j = 0; j < str.length(); j++) {
                                adj[i][j]=str.charAt(j)-'0';
                                dist[i][j]=Integer.MAX_VALUE;
                        }
                }
                bfs();
                System.out.println(dist[n-1][n-1]);
        }

        private static void bfs(){
                q=new ArrayDeque<>();
                q.addLast(new int[]{0,0});
                dist[0][0]=0;
                while(!q.isEmpty()){
                        int[] arr=q.removeFirst();
                        int cur_r=arr[0];
                        int cur_c=arr[1];

                        for (int i = 0; i < 4; i++) {
                                int nr=cur_r+dr[i];
                                int nc=cur_c+dc[i];
                                if(nr<0||nc<0||nr>=n||nc>=n) continue;
                                int cost;
                                if(adj[nr][nc]==1){
                                        cost=0;
                                } else {
                                        cost=1;
                                }

                                if(dist[nr][nc]>cost+dist[cur_r][cur_c]){
                                        dist[nr][nc]=cost+dist[cur_r][cur_c];
                                        if(cost==0){
                                                q.addFirst(new int[]{nr,nc});
                                        } else {
                                                q.addLast(new int[]{nr,nc});
                                        }
                                }

                        }
                }
        }














}