import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int cnt=0;
            boolean flag=false;
            String s = br.readLine();
            int len=s.length();

            //처음,마지막 이상하면 NO
            if(s.charAt(0)==')'||s.charAt(len-1)=='(' ){
                sb.append("NO").append("\n");
            //아니면
            } else {
                for (int j = 0; j < len; j++) {
                    if(s.charAt(j)=='('){
                        cnt++;
                    } else {
                        cnt--;
                    }
                    if(cnt<0){
                        break;
                    }

                }
                if(cnt != 0){
                    sb.append("NO").append("\n");
                } else sb.append("YES").append("\n");

            }

        }
        System.out.println(sb);
    }

}