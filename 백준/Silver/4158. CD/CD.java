import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb=new StringBuilder();
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M;
    static Set<Integer> SG;
    static List<Integer> common;
    public static void main(String[] args) throws IOException {

        while (true){
            st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            if (N==0 || M==0) break;
            common=new ArrayList<>();
            SG=new HashSet<>();
            for (int i = 0; i < N; i++) {
                int cd_num=Integer.parseInt(br.readLine());
                SG.add(cd_num);
            }
            for (int i = 0; i < M; i++) {
                int cd_num=Integer.parseInt(br.readLine());
                if(SG.contains(cd_num)){
                    common.add(cd_num);
                }
            }
            sb.append(common.size()).append("\n");
        }
        System.out.println(sb);
    }


}