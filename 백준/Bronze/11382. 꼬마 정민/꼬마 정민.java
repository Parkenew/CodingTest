import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long A,B,C;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        A=Long.parseLong(st.nextToken());
        B=Long.parseLong(st.nextToken());
        C=Long.parseLong(st.nextToken());

        System.out.println(A+B+C);

    }

}