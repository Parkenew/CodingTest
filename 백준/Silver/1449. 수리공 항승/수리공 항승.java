import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int placeCnt,tapeLength;
    static int tapeCnt=0;
    static int cur=0;
    static int[] places;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());

        //물이 새는 곳 개수
        placeCnt=Integer.parseInt(st.nextToken());
        //테이프 길이
        tapeLength=Integer.parseInt(st.nextToken());

        //물이 새는 장소
        places=new int[placeCnt];

        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < placeCnt; i++) {
            places[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(places);
        
        
        for (int i = 0; i < placeCnt; i++) {
            if(places[i]>cur){
                tapeCnt++;
                cur=places[i]+tapeLength-1;
            }
        }
        System.out.println(tapeCnt);
    }
}

