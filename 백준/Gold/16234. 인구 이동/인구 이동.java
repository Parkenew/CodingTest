import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,L,R;
    static int[][] countries;
    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};
    static int day=0;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {


        // N,L,R 초기화
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        countries=new int[N][N];

        // 각 나라 인구 수 입력
        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                countries[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        //인구 이동이 없을때 까지 진행
        while (true){
            boolean flag=false;
            visited=new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]){
                        if(dfs(i,j)){
                            flag=true;
                        };
                    }
                }
            }
            if(flag) day++;
            else break;
        }
        System.out.println(day);
    }
    static boolean dfs(int r,int c){
        ArrayDeque<int[]> stack=new ArrayDeque<>();
        List<int[]> united=new ArrayList<>();
        united.add(new int[]{r,c});
        int sum=countries[r][c];
        stack.addLast(new int[]{r,c,countries[r][c]});
        visited[r][c]=true;
        while(!stack.isEmpty()){
            int[] p=stack.removeLast();
            int nowR=p[0];
            int nowC=p[1];
            int nowCount=countries[nowR][nowC];
            for (int i = 0; i < 4; i++) {
                int nextR=nowR+dr[i];
                int nextC=nowC+dc[i];
                if(nextR<0 || nextR>=N || nextC<0 || nextC>=N) continue;
                int nextCount=countries[nextR][nextC];
                int diff=Math.abs(nowCount-nextCount);
                if (!visited[nextR][nextC]&&diff>=L&&diff<=R){
                    stack.addLast(new int[]{nextR,nextC,countries[nextR][nextC]});
                    visited[nextR][nextC]=true;
                    united.add(new int[]{nextR,nextC});
                    sum+=countries[nextR][nextC];
                }
            }
        }

        if(united.size()>1){
            int avg=sum/united.size();
            for (int i = 0; i < united.size(); i++) {
                for(int[] arr:united){
                    int arrR=arr[0];
                    int arrC=arr[1];
                    countries[arrR][arrC]=avg;
                }
            }
            return true;
        }
        return false;
    }
}