import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        StringBuilder sb=new StringBuilder();
        st=new StringTokenizer(br.readLine());
        int size_A = Integer.parseInt(st.nextToken());
        int size_B = Integer.parseInt(st.nextToken());
        List<Integer> arr = new ArrayList<>();

        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < size_A; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < size_B; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i)).append(" ");
        }
        System.out.println(sb);
    }


}

