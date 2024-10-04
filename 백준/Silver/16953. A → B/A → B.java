import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long A,B;
    //static int[] visited; -> 메모리 초과 발생
    static Set<Long> visited;
    static ArrayDeque<Long> q;
    static int cnt=1;

    public static void main(String[] args) throws IOException {
        st= new StringTokenizer(br.readLine());
        A=Long.parseLong(st.nextToken());
        B=Long.parseLong(st.nextToken());
        q=new ArrayDeque<>();
        q.add(A);
//        visited=new int[B+1];
//        visited[A]=1;
        visited=new HashSet<>();
        visited.add(A);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                long n=q.removeFirst();
                if(n==B){
                    System.out.println(cnt);
                    return;
                }
                long new_n=n*2;
                if(new_n<=B && !visited.contains(new_n)){
                    q.addLast(new_n);
                    visited.add(new_n);
                }
                new_n=n*10+1;
                if(new_n<=B && !visited.contains(new_n)){
                    q.addLast(new_n);
                    visited.add(new_n);
                }
            }
            cnt++;
        }
        System.out.println("-1");
    }


}