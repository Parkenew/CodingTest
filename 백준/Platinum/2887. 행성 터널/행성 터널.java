import java.io.*;
import java.util.*;
class Star {
    int num;
    int x;
    int y;
    int z;
    Star(int num,int x, int y, int z) {
        this.num = num;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int cost;
    public Edge(int start,int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;

    }
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int N;
    static Star[] stars;
    static int[] parent;
    static ArrayList<Edge> edges;
    static int minCost=0;
    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        stars=new Star[N];
        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int z=Integer.parseInt(st.nextToken());

            stars[i]=new Star(i,x,y,z);
        }

        edges=new ArrayList<>();

        Arrays.sort(stars,(s1,s2) -> s1.x-s2.x);
        for (int i = 0; i < N-1; i++) {
            int cost=Math.abs(stars[i].x-stars[i+1].x);
            edges.add(new Edge(stars[i].num,stars[i+1].num,cost));
        }

        Arrays.sort(stars,(s1,s2) -> s1.y-s2.y);
        for (int i = 0; i < N-1; i++) {
            int cost=Math.abs(stars[i].y-stars[i+1].y);
            edges.add(new Edge(stars[i].num,stars[i+1].num,cost));
        }

        Arrays.sort(stars,(s1,s2) -> s1.z-s2.z);
        for (int i = 0; i < N-1; i++) {
            int cost=Math.abs(stars[i].z-stars[i+1].z);
            edges.add(new Edge(stars[i].num,stars[i+1].num,cost));
        }

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i]=i;
        }

        Collections.sort(edges);

        for (Edge e:edges) {
            if(find(e.start)!=find(e.end)){
                minCost+=e.cost;
                union(e.start,e.end);
            }
        }
        System.out.println(minCost);
    }

    private static int find(int x){
        if(parent[x]==x) return x;

        return parent[x]=find(parent[x]);
    }

    private static void union(int x, int y){
        x=find(x);
        y=find(y);
        if(x!=y) parent[y]=x;
    }


}
