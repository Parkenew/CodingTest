import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int N;
    static int[][] place;
    static int sharkSize=2;
    static int eatCount=0;
    static int secondCount=0;
    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};
    static int[][] visited;
    static ArrayDeque<int[]> q=new ArrayDeque<>();
    static PriorityQueue<int[]> pq=new PriorityQueue<>((o1, o2) -> {
        if(o1[2]==o2[2]){
            if (o1[0]==o2[0]){
                return o1[1]-o2[1];
            } else return o1[0]-o2[0];
        } else return o1[2]-o2[2];

    });
    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        place=new int[N][N];
        visited=new int[N][N];
        int[] cur_rc=new int[2];

        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                place[i][j]=Integer.parseInt(st.nextToken());
                if(place[i][j]==9){
                    cur_rc[0]=i;
                    cur_rc[1]=j;
                    place[i][j]=0;
                }
            }
        }
        bfs(cur_rc[0],cur_rc[1]);
        while(!pq.isEmpty()){

            int[] cur=pq.poll();
            int r=cur[0];
            int c=cur[1];
            int second=cur[2];
            secondCount+=second;
            eatCount++;
            if(eatCount==sharkSize){
                sharkSize++;
                eatCount=0;
            }
            place[r][c]=0;
            while(!pq.isEmpty()){
                pq.poll();
            }
            bfs(r,c);
        }
        System.out.println(secondCount);
    }
    private static void bfs(int r, int c){
        q.addLast(new int[]{r,c});
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j]=-1;
            }
        }
        visited[r][c]=0;
        while(!q.isEmpty()){
            int[] cur=q.removeFirst();
            int cur_r=cur[0];
            int cur_c=cur[1];
            for (int i = 0; i < 4; i++) {
                int nr=cur_r+dr[i];
                int nc=cur_c+dc[i];
                if(nr<0||nr>=N||nc<0||nc>=N||visited[nr][nc]!=-1) continue;
                if(place[nr][nc]<=sharkSize){
                    q.addLast(new int[]{nr,nc});
                    visited[nr][nc]=visited[cur_r][cur_c]+1;
                    if(place[nr][nc]<sharkSize && place[nr][nc]>0){
                        pq.add(new int[]{nr,nc,visited[nr][nc]});
                    }
                }
            }
        }
    }


}
