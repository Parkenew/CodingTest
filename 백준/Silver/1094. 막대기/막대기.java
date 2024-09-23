import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int x;
    static int[] arr;
    public static void main(String[] args) throws IOException {
               x=Integer.parseInt(br.readLine());
        int cnt=0;
        int answer=0;
        while (x > 0) {
            if ((x & 1) == 1) {
                answer++;
            }
            x = x >> 1;
        }

        System.out.println(answer);

    }
    // 2. 32 32
    // 3. 32
    // 4. 16 16
    // 5. 16 8 8
    // 6. 16 8
    // 7. 16 4 4
    // 8. 16 4 2 1




}