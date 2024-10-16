import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int M,N,K;
    static int[][] paper;
    static boolean[][] visited;
    static int cnt;
    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};
    static ArrayList<Integer> arrayList;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        paper=new int[M][N];
        visited=new boolean[M][N];
        arrayList=new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st=new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    visited[j][k]=true;
                }
            }
        }
        int range=0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                cnt=0;
                if(!visited[i][j]) {
                    range++;
                    dfs(i,j);
                    arrayList.add(cnt);
                }
            }
        }
        Collections.sort(arrayList);
        sb.append(range).append("\n");
        for (int i:arrayList) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
    private static void dfs(int i, int j) {
        if(!visited[i][j]) {
            visited[i][j]=true;
            cnt++;
        }
        for (int k = 0; k < 4; k++) {
            int nr=i+dr[k];
            int nc=j+dc[k];
            if(nr>=0 && nc>=0 && nr<M && nc<N && !visited[nr][nc]) {
                dfs(nr,nc);
            }
        }
    }


}
