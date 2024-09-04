import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    public static void main(String[] args) throws IOException {
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == -1) break;


            boolean flag = false;


            for (int people = n - 1; people > 1; people--) {
                int coconuts = n;
                boolean possible = true;

                //사람 수만큼 반복
                for (int i = 0; i < people; i++) {
                    if (coconuts % people != 1) {
                        possible = false;
                        break;
                    }
                    coconuts = coconuts - 1 - (coconuts - 1) / people;
                }

                // 마지막에 나누어 떨어지는지 확인
                if (possible && coconuts % people == 0) {
                    System.out.println(n + " coconuts, " + people + " people and 1 monkey");
                    flag = true;
                    break;
                }
            }


            if (!flag) {
                System.out.println(n + " coconuts, no solution");
            }
        }
    }
}
