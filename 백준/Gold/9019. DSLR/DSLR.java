import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int T;
    static int[] A,B;
    static String[] visited;
    static String[] DSLR={"D","S","L","R"};
    public static void main(String[] args) throws IOException {
        T=Integer.parseInt(br.readLine());
        A=new int[T];
        B=new int[T];

        for (int i = 0; i < T; i++) {
            st=new StringTokenizer(br.readLine());
            A[i]=Integer.parseInt(st.nextToken());
            B[i]=Integer.parseInt(st.nextToken());
            visited=new String[10_000];
            visited[A[i]]="";
            bfs(A[i],B[i]);
            sb.append(visited[B[i]]).append("\n");
        }
        System.out.println(sb);
    }
    private static void bfs(int a,int b){
        ArrayDeque<Integer> q=new ArrayDeque<>();
        q.add(a);
        while(!q.isEmpty()){
            int x=q.poll();

            //DSLR 연산
            for (int i = 0; i < 4; i++) {
                int n;
                if(i==0){
                    n=D(x);
                } else if(i==1){
                    n=S(x);
                } else if(i==2){
                    n=LR(x,i);
                } else {
                    n=LR(x,i);
                }

                //한번도 나온적 없는 수만 연산
                if(visited[n]==null){
                    visited[n]=visited[x]+DSLR[i];
                    q.add(n);
                }

                if(n==b) return;
            }
        }
    }

    private static int D(int n){
        n=n*2;
        if(n>9999){
             return n%10000;
        } else return n;
    }

    private static int S(int n){
        if(n==0){
            return 9999;
        } else return n-1;
    }

    private static int LR(int n,int lr){
        if(n==0){
            return 0;
        } else {
            int num_1000=n/1000;
            n=n-num_1000*1000;
            int num_100=n/100;
            n=n-num_100*100;
            int num_10=(n/10);
            n=n-num_10*10;
            int num_1=(n%10);

            if(lr==2){
                return num_100*1000+num_10*100+num_1*10+num_1000;
            } else return num_1*1000+num_1000*100+num_100*10+num_10;
        }
    }
}