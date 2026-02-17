import java.io.*;
import java.util.*;

public class Main {
        static StringTokenizer st;
        static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        static StringBuilder sb=new StringBuilder();
        static long G;
        public static void main(String[] args) throws IOException {
                G=Long.parseLong(br.readLine());

                int realtime=2,imagination=1;
                long diff=0;
                boolean flag=false;

                while(true){
                        long realX2= (long)Math.pow(realtime,2);
                        long imageX2= (long)Math.pow(imagination,2);
                        diff= realX2-imageX2;

                        if (realtime-imagination==1 && diff>G) break;

                        if(diff<G){
                                realtime++;
                        } else if(diff>G){
                                imagination++;
                        } else {
                                flag=true;
                                sb.append(realtime).append("\n");
                                realtime++;
                        }
                }

                if(flag){
                        System.out.println(sb);
                } else System.out.println(-1);


        }














}