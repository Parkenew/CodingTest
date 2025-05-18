import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb=new StringBuilder();
    static int n;
    static int[][] adj;
    static int[][] visited;
    static ArrayDeque<int[]> stack;
    static int type=0;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,1,-1};
    public static void main(String[] args) throws IOException {
        n=Integer.parseInt(br.readLine());
        adj=new int[n][n];
        visited=new int[n][n];

        for (int i = 0; i < n; i++) {
            String str=br.readLine();
            for (int j = 0; j < n; j++) {
                adj[i][j]=str.charAt(j)-'0';
                visited[i][j]=-1;
            }
        }

        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(adj[i][j]==1 && visited[i][j]==-1){
                    ++type;
                    int cnt=dfs(i,j);
                    list.add(cnt);
                    
                }
            }
        }
        sb.append(type).append("\n");
        Collections.sort(list);
        for (int i: list){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
    private static int dfs(int r, int c){
        int cnt=0;
        stack=new ArrayDeque<>();
        stack.addLast(new int[]{r,c});
        visited[r][c]=type;
        cnt++;
        while (!stack.isEmpty()){
            int[] arr=stack.removeLast();
            int cur_r=arr[0];
            int cur_c=arr[1];
            for (int i = 0; i < 4; i++) {
                int nr=cur_r+dr[i];
                int nc=cur_c+dc[i];
                if (nr<0||nr>=n||nc<0||nc>=n) continue;
                if(visited[nr][nc]!=-1||adj[nr][nc]==0) continue;
                stack.addLast(new int[]{nr,nc});
                visited[nr][nc]=type;
                cnt++;
            }
        }
        return cnt;
    }

}
