import java.util.*;

public class Main {
    static class Shortcut {
        int start, end, cost;
        Shortcut(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 지름길 개수
        int D = sc.nextInt(); // 고속도로 길이

        List<Shortcut> shortcuts = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();

            if (end > D || end - start <= cost) continue; 
            shortcuts.add(new Shortcut(start, end, cost));
        }

        int[] dist = new int[D + 1];
        for (int i = 0; i <= D; i++) {
            dist[i] = i; 
        }

        for (int i = 0; i <= D; i++) {
            if (i != 0) dist[i] = Math.min(dist[i], dist[i - 1] + 1);

            for (Shortcut s : shortcuts) {
                if (s.start == i && s.end <= D) {
                    dist[s.end] = Math.min(dist[s.end], dist[i] + s.cost);
                }
            }
        }

        System.out.println(dist[D]);
    }
}
