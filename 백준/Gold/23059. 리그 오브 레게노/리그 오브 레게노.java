import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Map<String, Integer> inDegree = new HashMap<>();
    static Map<String, ArrayList<String>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            //A,B에 아무것도 안들어있으면 초기화
            map.putIfAbsent(A, new ArrayList<>());
            map.putIfAbsent(B, new ArrayList<>());

            //순서저장, 진입차수 기록
            map.get(A).add(B);
            inDegree.put(B, inDegree.getOrDefault(B, 0) + 1);
            inDegree.putIfAbsent(A, 0);
        }


        //진입차수가 0인 아이템들 따로 묶고 정렬 후 큐에 넣음
        ArrayList<String> items = new ArrayList<>();
        for (String key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                items.add(key);
            }
        }
        Collections.sort(items);
        ArrayDeque<String> q = new ArrayDeque<>();
        for (String item : items) {
            q.addLast(item);
        }


        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<String> nextItems=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                String nowItem = q.removeFirst();
                sb.append(nowItem).append("\n");

                for (String nextItem : map.get(nowItem)) {
                    inDegree.put(nextItem, inDegree.get(nextItem) - 1);
                    if (inDegree.get(nextItem) == 0) {
                        nextItems.add(nextItem);
                    }
                }
            }
            Collections.sort(nextItems);
            for (String nextItem : nextItems) {
                q.addLast(nextItem);
            }
        }


        boolean flag = true;
        for (String key : inDegree.keySet()) {
            if (inDegree.get(key) != 0) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.print(sb);
        } else {
            System.out.println("-1");
        }
    }
}
