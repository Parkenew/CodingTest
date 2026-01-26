import java.io.*;
import java.util.*;

public class Main {
        static StringTokenizer st;
        static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        static int N, M;
        static int[][] region;
        static boolean[][] visited;
        static int[] dr={1,-1,0,0};
        static int[] dc={0,0,1,-1};
        public static void main(String[] args) throws IOException {
                region=new int[501][501];
                visited=new boolean[501][501];
                N=Integer.parseInt(br.readLine());

                for (int i = 0; i < N; i++) {
                        st=new StringTokenizer(br.readLine());
                        int x1=Integer.parseInt(st.nextToken());
                        int y1=Integer.parseInt(st.nextToken());

                        int x2=Integer.parseInt(st.nextToken());
                        int y2=Integer.parseInt(st.nextToken());
                        for (int j = Math.min(x1,x2); j <= Math.max(x1,x2); j++) {
                                for (int k = Math.min(y1,y2); k <= Math.max(y1,y2); k++) {
                                        region[j][k]=1;
                                }
                        }
                }
                M=Integer.parseInt(br.readLine());

                for (int i = 0; i < M; i++) {
                        st=new StringTokenizer(br.readLine());
                        int x1=Integer.parseInt(st.nextToken());
                        int y1=Integer.parseInt(st.nextToken());

                        int x2=Integer.parseInt(st.nextToken());
                        int y2=Integer.parseInt(st.nextToken());
                        for (int j = Math.min(x1,x2); j <= Math.max(x1,x2); j++) {
                                for (int k = Math.min(y1,y2); k <= Math.max(y1,y2); k++) {
                                        region[j][k]=-1;
                                }
                        }
                }
                bfs();

        }

        static void bfs(){
                ArrayDeque<int[]> queue=new ArrayDeque<>();
                visited[0][0]=true;
                queue.addLast(new int[]{0,0,0});
                while(!queue.isEmpty()){
                        int[] arr=queue.removeFirst();
                        int r=arr[0];
                        int c=arr[1];
                        int life=arr[2];

                        if (r == 500 && c == 500) {
                                System.out.println(life);
                                return;
                        }

                        for (int i = 0; i < 4; i++) {
                                int nr=r+dr[i];
                                int nc=c+dc[i];
                                if(nr>500 || nc>500 || nr<0 || nc<0 || visited[nr][nc] || region[nr][nc]==-1) continue;

                                visited[nr][nc]=true;
                                if(region[nr][nc]==1){
                                        queue.addLast(new int[]{nr,nc,life+1});
                                }
                                else queue.addFirst(new int[]{nr,nc,life});
                        }
                }
                System.out.println(-1);
        }
}