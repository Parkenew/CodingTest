//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        int[] arr=new int[9];
        int sum=0;
        for (int i = 0; i < 9; i++) {
            arr[i]=Integer.parseInt(br.readLine());
            sum+=arr[i];
        }
        int n=0;
        int m=0;

        List<Integer> list;
        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                if(sum-arr[i]-arr[j]==100){
                    n=arr[i];
                    m=arr[j];
                }
            }
        }
        Arrays.sort(arr);
        for(int k=0; k<9; k++){
            if(arr[k]==n || arr[k]==m){
                continue;
            }
            System.out.println(arr[k]);
        }
    }
}