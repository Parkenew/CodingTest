//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    //테스트 케이스 개수
    static int T;
    //가로
    static int M;
    //세로
    static int N;
    //배추 개수
    static int K;

    //방문체크
    static boolean[][] visited;
    static int[][] adj;

    static int now_x;
    static int now_y;

    //사방탐색 방향
    static int dirX[] = {0, 0, -1, 1};
    static int dirY[] = {-1, 1, 0, 0};

    static void print(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        T=Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            //테스트 케이스 세팅
            st=new StringTokenizer(br.readLine());
            M=Integer.parseInt(st.nextToken());
            N=Integer.parseInt(st.nextToken());
            K=Integer.parseInt(st.nextToken());


            visited=new boolean[M][N]; //방문 체크
            adj=new int[M][N]; // 2차원 인접행렬

            for(int i=0;i<K;i++){
                st=new StringTokenizer(br.readLine());
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
                adj[x][y]=1;
            }
            int count = 0;

            //열 우선순회
            for(int j=0; j<M; j++) {
                for(int k=0; k<N; k++) {
                    if(adj[j][k] == 1 && !visited[j][k]) {
                        count++;
                        bfs(j,k);
                    }
                }
            }
            System.out.println(count);
        }
    }
    static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Node now = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = now.x + dirX[i];
                int ny = now.y + dirY[i];

                if(nx>=M || ny>=N || nx<0 || ny<0) continue;
                if(visited[nx][ny] || adj[nx][ny] != 1) continue;

                queue.add(new Node(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}