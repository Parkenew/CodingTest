import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int[] tree;
    static int n,m; //{0},{1} ... , {n} 까지 n+1개의 집합, 연산 개수 m
    static int num;
    static int a,b;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        tree=new int[n+1];
        for (int i = 0; i < n+1; i++) {
            tree[i]=i;
        }

        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            num=Integer.parseInt(st.nextToken());
            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            if(num==0){
                union(a,b);
            } else sb.append(solve(a,b)).append("\n");;
        }
        System.out.println(sb);
    }

    private static String solve(int a, int b){
        if(find(a)==find(b)){
            return "YES";
        } else return "NO";
    }

    private static int find(int x){
        if (tree[x]==x) return x;
        return find(tree[x]);
    }

    private static void union(int a, int b){
        int pa=find(a);
        int pb=find(b);

        if(pa!=pb){
            tree[pb]=pa;
        }
    }
}