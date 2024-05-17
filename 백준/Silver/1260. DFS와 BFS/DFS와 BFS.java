import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb=new StringBuilder();
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    //정점의 개수
    static int N;
    //간선의 개수
    static int M;
    //시작할 정점 번호
    static int V;

    //인접리스트
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static boolean[] visitedb;
    static ArrayList<Integer> track=new ArrayList<>();
    static ArrayList<Integer> trackb=new ArrayList<>();

    public static void main(String[] args)throws IOException {
        st=new StringTokenizer(br.readLine());
        //변수 초기화
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        V=Integer.parseInt(st.nextToken());

        adj= new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            adj[i]= new ArrayList<>();
        }
        visited=new boolean[N+1];
        visitedb=new boolean[N+1];

        //안접리스트
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int start,end;
            start=Integer.parseInt(st.nextToken());
            end=Integer.parseInt(st.nextToken());
            adj[start].add(end);
            adj[end].add(start);
        }

        ArrayDeque<Integer> stack=new ArrayDeque<>(Arrays.asList(V));
        while(!stack.isEmpty()){
            //로직1
            int current=stack.removeLast();
            if(!visited[current]){
                visited[current]=true;
                track.add(current);
            }
            Collections.sort(adj[current]);

            // 로직 2
            // 인접행렬을 하나씩 돌면서! (0번 포도알 없음에 주의)
            Collections.reverse(adj[current]);
            for(int ints: adj[current]){
                if(!visited[ints]){
                    stack.addLast(ints);
                }
            }
        }


        ArrayDeque<Integer> Queue=new ArrayDeque<>(Arrays.asList(V));
        while(!Queue.isEmpty()){

            //로직1
            int current=Queue.removeFirst();
            if(!visitedb[current]){
                visitedb[current]=true;
                trackb.add(current);
            }

            // 로직 2
            // 인접행렬을 하나씩 돌면서! (0번 포도알 없음에 주의)
            Collections.sort(adj[current]);
            for(int ints: adj[current]){
                if(!visitedb[ints]){
                    Queue.addLast(ints);
                }
            }
        }

        for (int ints : track) {
            sb.append(ints).append(" ");
        }
        sb.append("\n");
        for (int ints:trackb){
            sb.append(ints).append(" ");
        }
        System.out.println(sb);
    }
}