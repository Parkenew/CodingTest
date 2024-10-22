import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int N, M;
    static int[] board;
    static int[] ladderSnake;
    static ArrayDeque<Integer> q;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[101];
        ladderSnake = new int[101];

        // 사다리
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ladderSnake[x] = y;
        }

        // 뱀
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ladderSnake[x] = y;
        }

        
        q = new ArrayDeque<>();
        q.addLast(1);
        board[1] = 1;  

        while (!q.isEmpty()) {
            int x = q.pollFirst();

            // 도착시 종료
            if (x == 100) {
                System.out.println(board[100] - 1); 
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = x + i;
                if (next > 100) continue;  

                
                if (ladderSnake[next] != 0) next = ladderSnake[next];
                
                if (board[next] == 0) {
                    q.addLast(next);
                    board[next] = board[x] + 1;
                }
            }
        }
    }
}
