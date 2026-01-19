import java.io.*;
import java.util.*;

public class Main {
        static StringBuilder sb = new StringBuilder();
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;
        static int N;
        static Map<Integer,Integer> map;
        static int v;
        public static void main(String[] args) throws IOException {
            N=Integer.parseInt(br.readLine());
            map=new HashMap<>();
            st=new StringTokenizer(br.readLine());
            for (int i = 0; i <N; i++) {
                int a=Integer.parseInt(st.nextToken());
                map.put(a,map.getOrDefault(a,0)+1);
            }
            v=Integer.parseInt(br.readLine());
            if(map.containsKey(v)){
                System.out.println(map.get(v));
            }else System.out.println("0");
            
        }

    }

