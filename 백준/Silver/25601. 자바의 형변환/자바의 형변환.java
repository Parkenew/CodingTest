import javax.xml.crypto.dsig.Transform;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static Map<String,ArrayList<String>> tree = new HashMap<>();
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        tree = new HashMap<>();
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            if (!tree.containsKey(a)) {
                tree.put(a, new ArrayList<>());
            }
            tree.get(a).add(b);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        if(Transform(a,b)||Transform(b,a)){
            System.out.println("1");
        } else System.out.println("0");
    }
    private static boolean Transform(String Question, String Answer){
        if(Question.equals(Answer)){
            return true;
        }
        if(tree.containsKey(Question)){
            for(String s : tree.get(Question)){
                if(Transform(s,Answer)){
                    return true;
                }
            }
        }

        return false;
    }

}
