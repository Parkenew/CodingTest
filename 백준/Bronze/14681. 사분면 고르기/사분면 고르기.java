import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int x,y;

    public static void main(String[] args) throws IOException {
        x=Integer.parseInt(br.readLine());
        y=Integer.parseInt(br.readLine());

        if(x>0 && y>0) {
            sb.append("1");
        } else if (x>0 && y<0) {
            sb.append("4");
        } else if ( x<0 && y>0) {
            sb.append("2");
        } else if ( x<0 && y<0) {
            sb.append("3");
        }
        System.out.println(sb);
    }
}
