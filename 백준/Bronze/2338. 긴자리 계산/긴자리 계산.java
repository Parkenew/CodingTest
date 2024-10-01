import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {
        BigInteger A=new BigInteger(br.readLine());
        BigInteger B=new BigInteger(br.readLine());
        sb.append(A.add(B)).append("\n");
        sb.append(A.subtract(B)).append("\n");
        sb.append(A.multiply(B)).append("\n");
        System.out.println(sb);
    }


}