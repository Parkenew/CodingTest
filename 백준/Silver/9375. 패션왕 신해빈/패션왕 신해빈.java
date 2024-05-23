import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb=new StringBuilder();
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        int n  = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            int m=Integer.parseInt(br.readLine());
            Map<String,Integer> map=new HashMap<>();
            ArrayList<String> keys=new ArrayList<>();

            for (int j = 0; j < m; j++) {
                String[] arr= new String[2];
                arr=br.readLine().split(" ");
                if(map.containsKey(arr[1])){
                    map.put(arr[1], map.get(arr[1])+1);
                } else {
                    map.put(arr[1], 1);
                    keys.add(arr[1]);
                }
            }
            int size=map.size();
            int anwwer;
            if(size==1) {
                System.out.println(m);
            } else {
                int answer = 1;
                for (int j = 0; j < size; j++) {
                    answer *= map.get(keys.get(j))+1;
                }
                answer = answer-1;
                System.out.println(answer);
            }
        }

    }


}