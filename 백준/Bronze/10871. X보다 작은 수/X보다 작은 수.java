import java.io.*;
import java.util.*;

public class Main {
        static StringBuilder sb = new StringBuilder();
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;
        static int N,X;
        public static void main(String[] args) throws IOException {
                st=new StringTokenizer(br.readLine());
                N=Integer.parseInt(st.nextToken());
                X=Integer.parseInt(st.nextToken());
                st=new StringTokenizer(br.readLine());
                for (int i = 0; i < N; i++) {
                        int n=Integer.parseInt(st.nextToken());
                        if(n<X){
                                sb.append(n).append(" ");
                        }
                }
                System.out.println(sb);

        }

    }

