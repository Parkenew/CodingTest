//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb=new StringBuilder();
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        Set<String> set1=new HashSet<String>();
        Set<String> set2=new HashSet<String>();

        for (int i = 0; i < n; i++) {
            set1.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            set2.add(br.readLine());
        }

        set1.retainAll(set2);
        ArrayList<String> arr=new ArrayList<>();
        sb.append(set1.size()).append("\n");
        for (String s : set1) {
            arr.add(s);
        }
        Collections.sort(arr);
        for (String s : arr) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);




    }


}