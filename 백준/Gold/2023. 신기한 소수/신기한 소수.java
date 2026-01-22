import java.io.*;
import java.util.*;

public class Main {
        static StringBuilder sb = new StringBuilder();
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;
        static int N;
        static int[] arr;
        static boolean[] visited;
        public static void main(String[] args) throws IOException {
                N = Integer.parseInt(br.readLine());
                arr = new int[N];
                visited = new boolean[N];
                backTracking(2,1);
                backTracking(3,1);
                backTracking(5,1);
                backTracking(7,1);
                System.out.println(sb);
        }

        static void backTracking(int num, int length) {
                if (length == N) {
                        sb.append(num).append("\n");
                        return;
                }

                for (int i = 1; i <= 9; i++) {
                        int nextNum = num * 10 + i;
                        if (isPrime(nextNum)) {
                                backTracking(nextNum, length + 1);
                        }
                }
        }

        static boolean isPrime(int num){
                if(num<2) return false;
                else {
                        int sqrt = (int) Math.sqrt(num);
                        for (int i = 2; i <= sqrt; i++) {
                                if(num%i==0) return false;
                        }
                        return true;
                }
        }


    }

