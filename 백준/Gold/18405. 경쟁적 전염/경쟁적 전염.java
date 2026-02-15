import java.io.*;
import java.util.*;

public class Main {
        static StringTokenizer st;
        static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        static StringBuilder sb=new StringBuilder();
        static int[] dr = {1,-1,0,0};
        static int[] dc = {0,0,-1,1};
        static int N,K;
        static int S,X,Y;
        static int[][] adj;
        static class Node implements Comparable<Node>{
                int r;
                int c;
                int virusNum;
                int second;
                public Node(int r, int c, int virusNum, int second) {
                        this.r = r;
                        this.c = c;
                        this.virusNum = virusNum;
                        this.second = second;
                }
                @Override
                public int compareTo(Node o) {
                        return this.virusNum-o.virusNum;
                }
        }
        public static void main(String[] args) throws IOException {
                st=new StringTokenizer(br.readLine());
                N=Integer.parseInt(st.nextToken());
                K=Integer.parseInt(st.nextToken());

                adj=new int[N][N];

                List<Node> list=new ArrayList<>();
                for (int i = 0; i < N; i++) {
                        st=new StringTokenizer(br.readLine());
                        for (int j = 0; j < N; j++) {
                                adj[i][j]=Integer.parseInt(st.nextToken());
                                if(adj[i][j]!=0){
                                        list.add(new Node(i,j,adj[i][j],0));
                                }
                        }
                }
                Collections.sort(list);

                st=new StringTokenizer(br.readLine());
                S=Integer.parseInt(st.nextToken());
                X=Integer.parseInt(st.nextToken());
                Y=Integer.parseInt(st.nextToken());

                ArrayDeque<Node> q=new ArrayDeque<>(list);
                while(!q.isEmpty()){
                        Node now=q.removeFirst();
                        int now_r=now.r;
                        int now_c=now.c;
                        int now_virusNum=now.virusNum;
                        int now_second=now.second;

                        if(now_second==S) continue;

                        for (int i = 0; i < 4; i++) {
                                int next_r=now_r+dr[i];
                                int next_c=now_c+dc[i];
                                if(next_r>=N || next_c>=N || next_r<0 || next_c<0 || adj[next_r][next_c]!=0) continue;
                                adj[next_r][next_c]=now_virusNum;
                                q.addLast(new Node(next_r,next_c,now_virusNum,now_second+1));
                        }
                }

                System.out.println(adj[X-1][Y-1]);
        }










}