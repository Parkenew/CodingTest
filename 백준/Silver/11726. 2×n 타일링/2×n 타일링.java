import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n=Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        arr[1]=1%10007;
        arr[2]=2%10007;
        arr[3]=3%10007;
        for (int i = 4; i <= n; i++) {
            arr[i]=(arr[i-1]+arr[i-2])%10007;
        }

        System.out.println(arr[n]);


    }
}