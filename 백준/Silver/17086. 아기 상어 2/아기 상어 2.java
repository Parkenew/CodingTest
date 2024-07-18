//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m;
    static int[][] adj;

    static int[] dr= {1,0,-1,0,1,1,-1,-1};
    static int[] dc= {0,1,0,-1,1,-1,1,-1};
    static int[][] cnts;
    static int[] arr;
    static ArrayDeque<int[]> queue= new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        adj=new int[n][m];
        cnts=new int[n][m];
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                adj[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(adj[i][j]==1){
                    arr= new int[2];
                    arr[0]=i;
                    arr[1]=j;
                    queue.addFirst(arr);
                    
                }
            }
        }
        bfs();
        int max=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cnts[i][j]>=max){
                    max=cnts[i][j];
                }
            }
        }
        System.out.println(max);
    }

    public static void bfs(){
        while(!queue.isEmpty()){
            int[] now=queue.removeFirst();
            for (int i = 0; i < 8; i++) {
                int nr= now[0]+dr[i];
                int nc= now[1]+dc[i];
                if(nr>= n || nc>=m || nr<0 || nc<0 || adj[nr][nc]==1) continue;
                adj[nr][nc]=1;
                cnts[nr][nc]=cnts[now[0]][now[1]]+1;
                queue.addLast(new int[]{nr,nc});
            }
        }
    }
}