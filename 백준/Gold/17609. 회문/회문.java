import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            sb.append(isPalindrome(line)).append("\n");
        }
        System.out.println(sb);
    }

    private static int isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else {
                if (check(str, start, end-1)||check(str, start+1, end)){
                    return 1;
                }
                return 2;
            }
        }
        return 0;
    }

    private static boolean check(String str,int start,int end) {
        while(start < end) {
            if(str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }
}