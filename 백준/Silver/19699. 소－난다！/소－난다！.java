import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int N,M;
    static int[] H;
    static int[] arr;
    static boolean[] visited;
    static ArrayList<Integer> prime;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        H=new int[N];
        arr=new int[M];
        prime=new ArrayList<>();
        visited=new boolean[9001];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            H[i]=Integer.parseInt(st.nextToken());
        }


        BackTracking(arr,0,0);
        if(prime.isEmpty()){
            System.out.println("-1");
        } else {
            Collections.sort(prime);
            for (int a: prime){
                sb.append(a).append(" ");
            }
            System.out.println(sb);
        }
    }
    private static void BackTracking(int[] arr,int depth, int startIdx){
        if(depth==arr.length){
            int sum=0;
            for (int i = 0; i < depth; i++) {
                sum+=arr[i];
            }
            if(isPrime(sum)&&!visited[sum]){
                prime.add(sum);
                visited[sum]=true;
            }
        } else {
            for (int i = startIdx; i < H.length; i++) {
                arr[depth]=H[i];
                BackTracking(arr,depth+1,i+1);
            }
        }
    }

    private static boolean isPrime(int num){
        for(int i=2;i<=Math.sqrt(num);i++) {
            if(num%i==0) return false;
        }
        return true;
    }

}