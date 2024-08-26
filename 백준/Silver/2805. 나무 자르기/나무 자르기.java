import java.awt.print.Pageable;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n,m;
    static int[] tree;
    static int MIN,MAX;
    static int half;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //나무 개수
        m = Integer.parseInt(st.nextToken()); //필요한 나무

        tree=new int[n];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i]=Integer.parseInt(st.nextToken());
            MAX=Math.max(MAX,tree[i]);
        }


        while(MAX>=MIN){
            long sum=0;
            half=(MAX+MIN)/2;
            for (int i = 0; i < n; i++) {
                if(tree[i]>half) sum+=tree[i]-half;
            }

            if (sum<m){
                MAX=half-1;
            } else
                MIN=half+1;
            
        }
        System.out.println(MAX);
    }


}

