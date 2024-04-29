import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n=Integer.parseInt(br.readLine());
        int cnt=0;
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int s=Integer.parseInt(st.nextToken());
            if(!cal(s)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    public static boolean cal(int n){
        if(n==1){
            return true;
        }
        boolean flag=false;
        for (int i = 2; i <= n-1 ; i++) {
            if(n%i==0){
                flag=true;
            }
        }

        return flag;
    }
}
