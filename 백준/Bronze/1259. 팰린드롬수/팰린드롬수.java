import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        String s;
        boolean flag=false;
        while(!(( s=br.readLine()).equals("0"))){
            int len = s.length();
            for (int i = 0; i < len; i++) {
                if(s.charAt(i)!=s.charAt(len-1-i)){
                    flag=true;
                    break;
                }
            }
            if (flag){
                sb.append("no").append("\n");
            } else sb.append("yes").append("\n");
            flag=false;
        }

        System.out.println(sb);

    }
}