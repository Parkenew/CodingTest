import java.io.*;
import java.util.*;

public class Main {
        static StringTokenizer st;
        static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        static StringBuilder sb=new StringBuilder();
        static int N,M;
        static int[] arr;
        static int min=Integer.MAX_VALUE;
        public static void main(String[] args) throws IOException {
                st=new StringTokenizer(br.readLine());
                N=Integer.parseInt(st.nextToken());
                M=Integer.parseInt(st.nextToken());

                arr=new int[N];
                for(int i=0;i<N;i++){
                        arr[i]=Integer.parseInt(br.readLine());
                }
                Arrays.sort(arr);

                int left=0,right=0;

                while(right<N){
                        int diff= arr[right]-arr[left];
                        if(diff<M){
                                right++;
                        } else if (diff==M) {
                                min=M;
                                break;
                        } else {
                                min=Math.min(min,diff);
                                left++;
                                if(left>right){
                                        right=left;
                                }
                        }
                }
                System.out.println(min);
        }














}