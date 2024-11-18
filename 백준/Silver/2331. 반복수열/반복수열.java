import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());


        HashMap<Integer, Integer> visited = new HashMap<>();
        int current = A;
        int index = 0;

        while (!visited.containsKey(current)) {
            visited.put(current, index++);
            current = getNext(current, P);
        }


        System.out.println(visited.get(current));
    }

    
    private static int getNext(int number, int power) {
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, power);
            number /= 10;
        }
        return sum;
    }
}
