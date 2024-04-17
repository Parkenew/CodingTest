import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int V;
    static int E;
    static int[][] abj;
    static int firstNode=1;
    static ArrayList<Integer> track=new ArrayList<>();
    static boolean[] visited;


    public static void main(String arg[])throws IOException {
        V=Integer.parseInt(br.readLine());
        E=Integer.parseInt(br.readLine());

        abj=new int[V+1][V+1];
        visited=new boolean[V+1];

        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int start,end;
            start=Integer.parseInt(st.nextToken());
            end=Integer.parseInt(st.nextToken());
            abj[start][end]=1;
            abj[end][start]=1;
        }

        ArrayDeque<Integer> stack=new ArrayDeque<>(Arrays.asList(firstNode));
        while(!stack.isEmpty()){
            int current=stack.removeLast();
            if(!visited[current]){
                visited[current]=true;
                track.add(current);
            }

            for(int des=1;des<V+1;des++){
                if(!visited[des]&&abj[current][des]==1){
                    stack.addLast(des);
                }
            }

        }
        System.out.println(track.size()-1);

    }
}