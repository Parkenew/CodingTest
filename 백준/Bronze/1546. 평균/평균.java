import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int n = Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        st=new StringTokenizer(br.readLine());
        int max=0;
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
            if(arr[i]>max) max=arr[i];
        }
        
        double sum=0;
        double a;
        for (int ints:arr){
            a=ints;
            a=a/(double)max*100;
            sum += a;
        }
        System.out.println(sum/n);

    }
}