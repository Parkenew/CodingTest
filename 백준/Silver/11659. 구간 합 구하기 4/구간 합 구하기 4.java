import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int[] arr =new int[N];
        int[] plus=new int[N];
        int add=0;

        //리스트 초기화 및 누적합 리스트 생성
        st=new StringTokenizer(br.readLine());
        for(int k=0;k<N;k++){
            arr[k]=Integer.parseInt(st.nextToken());
            add+=arr[k];
            plus[k]=add;
        }

        for(int k=0;k<M;k++){
            st=new StringTokenizer(br.readLine());
            int i=Integer.parseInt(st.nextToken());
            int j=Integer.parseInt(st.nextToken());
            int answer;
            if(i==1){
                answer=plus[j-1];
            } else {
                answer=plus[j-1]-plus[i-2];
            }
            System.out.println(answer);
        }
    }
}

