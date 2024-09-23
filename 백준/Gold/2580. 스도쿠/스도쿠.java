import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int[][] arr=new int[9][9];
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 9; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        BackTrack(0,0);

    }
    private static void BackTrack(int x,int y) {
        if (y==9){
            BackTrack(x+1,0);
            return;
        }
        if (x==9){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        if (arr[x][y]==0){
            for (int i = 1; i <= 9 ; i++) {
                if(check(x,y,i)){
                    arr[x][y]=i;
                    BackTrack(x,y+1);
                }

            }
            arr[x][y]=0;
            return;
        }
        BackTrack(x,y+1);
    }

    private static boolean check(int x,int y,int i){
        //가로줄 체크
        for (int j = 0; j < 9; j++) {
            if(arr[x][j]==i){
                return false;
            }
        }

        //세로줄 체크
        for (int j = 0; j < 9; j++) {
            if(arr[j][y]==i){
                return false;
            }
        }

        //3X3박스 체크
        int n_x=x/3*3;
        int n_y=y/3*3;

        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                if(arr[n_x+j][n_y+k]==i){
                    return false;
                }
            }
        }

        return true;
    }

}