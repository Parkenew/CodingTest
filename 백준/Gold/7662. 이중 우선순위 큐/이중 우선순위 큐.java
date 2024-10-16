import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int T,k;

    public static void main(String[] args) throws IOException {
        T=Integer.parseInt(br.readLine());
        for (int i = 0; i <T; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            k=Integer.parseInt(br.readLine());
            for (int j = 0; j < k; j++) {
                st=new StringTokenizer(br.readLine());
                String str=st.nextToken();
                int n=Integer.parseInt(st.nextToken());
                if(str.equals("I")){
                    map.put(n,map.getOrDefault(n,0)+1);
                } else {
                    if(map.isEmpty()) continue;
                    int m;
                    if(n==-1){
                        m=map.firstKey();
                    } else {
                        m=map.lastKey();
                    }
                    map.put(m,map.get(m)-1);
                    if(map.get(m)==0){
                        map.remove(m);
                    }
                }
            }
            if(map.isEmpty()){
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        System.out.println(sb);
    }

}
