import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(br.readLine());
        long answer=factorial(n);
        System.out.println(answer);
    }

    private static long factorial(long n) {
        if(n>0) {
            return n*factorial(n-1);
        } else return 1;
    }
}
