import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb=new StringBuilder();
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        Map<String,String> map=new HashMap<>();

        while(n-- >0){
            st=new StringTokenizer(br.readLine());
            map.put(st.nextToken(),st.nextToken());
        }
        while(m-- >0){
            String id=br.readLine();
            sb.append(map.get(id)).append("\n");
        }
        System.out.println(sb);
    }

}