import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String word=br.readLine();
        int answer=1;
        for(int i=0;i<=(word.length()-1)/2;i++){
            if(word.charAt(i)!=word.charAt(word.length()-1-i)){
                answer=0;
                break;
            }
        }
        System.out.println(answer);

    }
}

