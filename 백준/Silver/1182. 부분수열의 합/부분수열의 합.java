import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String arg[]) throws IOException {

        st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int S=Integer.parseInt(st.nextToken());

        //배열초기화
        int[] arr= new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int cnt=0;
        //부분집합
        for(int i=0;i<1<<arr.length;i++){

            int sum=0;
            for(int j=0;j<arr.length;j++){
                if((i&(1<<j))!=0) {
                    sum+=arr[j];
                }
            }

            if(sum==S) cnt++;

        }
        if(S==0){
            cnt--;
        }
        System.out.println(cnt);

    }
}
