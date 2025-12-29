import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb=new StringBuilder();
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M;
    static int[][] city;
    static boolean[] visited;
    static int[] dr=new int[]{-1,1,0,0};
    static int[] dc=new int[]{0,0,-1,1};
    static List<int[]> chickens;
    static List<int[]> houses;
    static int minCityDistance = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        city=new int[N][N];
        chickens=new ArrayList<>();
        houses=new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j]=Integer.parseInt(st.nextToken());
                if(city[i][j]==2) chickens.add(new int[]{i,j});
                else if (city[i][j]==1) houses.add(new int[]{i,j});
            }
        }

        visited=new boolean[chickens.size()];
        dfs(0,0);
        System.out.println(minCityDistance);
    }
    static void dfs(int start,int depth){
        if(depth==M){
            calculate();
            return;
        } else {
            for (int i = start; i < chickens.size(); i++) {
                visited[i]=true;
                dfs(i+1,depth+1);
                visited[i]=false;
            }
        }
    }
    
    static void calculate(){
        int total=0;
        for(int[] house: houses){
            int minDist=Integer.MAX_VALUE;
            for (int i = 0; i < chickens.size(); i++) {
                if(visited[i]) {
                    int[] arr = chickens.get(i);
                    int dist = Math.abs(house[0] - arr[0]) + Math.abs(house[1] - arr[1]);
                    minDist = Math.min(minDist, dist);
                }
            }
            total+=minDist;
            if(total>minCityDistance)return;
        }
        minCityDistance=Math.min(minCityDistance,total);
    }
}