import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String order;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            order=st.nextToken();
            if (order.equals("push")){
                int a = Integer.parseInt(st.nextToken());
                stack.addLast(a);
            } else if (order.equals("pop")){
                sb.append(stack.isEmpty() ? "-1" : stack.removeLast()).append("\n");
            } else if (order.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if (order.equals("empty")) {
                sb.append(stack.isEmpty()? "1":"0").append("\n");
            } else if (order.equals("top")) {
                sb.append(stack.isEmpty() ? "-1"  : stack.getLast()).append("\n");
            }

        }
        System.out.println(sb);
    }
}