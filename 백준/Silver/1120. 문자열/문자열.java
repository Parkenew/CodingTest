//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        String x=st.nextToken();
        String y=st.nextToken();

        //두 문자열의 차이
        int len=y.length()-x.length();
        int min=50;
        int cnt=0;

        //두 문자열의 길이가 다를때
        if(len>0) {
            for (int i = 0; i < len + 1; i++) {
                for (int j = 0; j < x.length(); j++) {
                    if (x.charAt(j) == y.charAt(i + j)) {
                        continue;
                    }
                    cnt++;
                }
                if (cnt < min) min = cnt;
                cnt = 0;
            }
            System.out.println(min);
        } else {
            for (int i = 0; i < x.length(); i++) {
                if (x.charAt(i) == y.charAt(i)) {
                    continue;
                }
                cnt++;
            }
            System.out.println(cnt);
        }

    }
}