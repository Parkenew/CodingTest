
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int N;
    static int[][] paper;
    static Map<Integer,Integer> map=new HashMap<>();
    static int[] count;
    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        paper=new int[N][N];
        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        count=new int[3];
        DQ(0,0,N);

        for (int i = 0; i < 3; i++) {
            sb.append(count[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void DQ(int x,int y,int paperSize){
        if(check(x,y,paperSize)) {
            int idx=paper[y][x]+1;
            count[idx]++;
        } else {
                int newSize=paperSize/3;
                DQ(x,y, newSize);
                DQ(x+ newSize,y, newSize);
                DQ(x+2*newSize,y, newSize);

                DQ(x,y+ newSize, newSize);
                DQ(x+ newSize,y+ newSize, newSize);
                DQ(x+2* newSize,y+ newSize, newSize);

                DQ(x,y+2*newSize, newSize);
                DQ(x+ newSize,y+2*paperSize/3, newSize);
                DQ(x+2*newSize,y+2*paperSize/3,paperSize/3);
            }
    }

    private static boolean check(int x,int y, int paperSize){
        int temp=paper[y][x];
        for (int i = y; i < y+paperSize; i++) {
            for (int j = x; j < x+paperSize; j++) {
                if(temp!=paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


}
