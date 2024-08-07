import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int initialCash, bnpCash, timingCash;
    static int bnpStock = 0, timingStock = 0;
    static int consecutiveDecrease = 0, consecutiveIncrease = 0;
    static int previousPrice;

    public static void main(String[] args) throws IOException {
        initialCash = Integer.parseInt(br.readLine());
        bnpCash = initialCash;
        timingCash = initialCash;

        st = new StringTokenizer(br.readLine());
        int[] prices = new int[14];
        for (int i = 0; i < 14; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        previousPrice = prices[0];
        for (int i = 0; i < 14; i++) {
            int currentPrice = prices[i];
            BNP(currentPrice);
            TIMING(currentPrice);
            previousPrice = currentPrice;
        }

        int finalPrice = prices[13];
        int bnpTotal = calculateTotal(finalPrice, bnpCash, bnpStock);
        int timingTotal = calculateTotal(finalPrice, timingCash, timingStock);

        if (bnpTotal > timingTotal) {
            System.out.println("BNP");
        } else if (bnpTotal < timingTotal) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }

    public static void BNP(int currentPrice) {
        if (bnpCash >= currentPrice) {
            int stocksBought = bnpCash / currentPrice;
            bnpStock += stocksBought;
            bnpCash -= stocksBought * currentPrice;
        }
    }

    public static void TIMING(int currentPrice) {
        if (currentPrice < previousPrice) {
            consecutiveDecrease++;
            consecutiveIncrease = 0;
            if (consecutiveDecrease >= 3 && timingCash >= currentPrice) {
                int stocksBought = timingCash / currentPrice;
                timingStock += stocksBought;
                timingCash -= stocksBought * currentPrice;
            }
        } else if (currentPrice > previousPrice) {
            consecutiveIncrease++;
            consecutiveDecrease = 0;
            if (consecutiveIncrease >= 3) {
                timingCash += timingStock * currentPrice;
                timingStock = 0;
            }
        } else {
            consecutiveIncrease = 0;
            consecutiveDecrease = 0;
        }
    }

    public static int calculateTotal(int finalPrice, int cash, int stocks) {
        return cash + stocks * finalPrice;
    }
}
