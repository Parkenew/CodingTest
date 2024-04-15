import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        

        int maxr = 0;
        int maxc = 0;
        int max=0;

        for(int r=0;r<9;r++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int c=0;c<9;c++){
                int num=Integer.parseInt(st.nextToken());
                if(num>max){
                    max=num;
                    maxr=r;
                    maxc=c;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        sb.append(max).append("\n")
                .append(maxr+1).append(" ").append(maxc+1);
        System.out.println(sb.toString());
    }

}
