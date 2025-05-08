package may6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MiracleTrading {
    public static int jun(int money, int[] prices) {
        int stock = 0;
        for (int price : prices) {
            if(money >= price) {
                int canBuy = money / price;
                stock += canBuy;
                money -= price * canBuy;
            }
        }
        return stock * prices[13] + money;
    }

    public static int sung(int money, int[] prices) {
        int stock = 0;
        for (int i = 3; i < 14; i++) {
            if ((prices[i - 3] < prices[i - 2]) && (prices[i - 2] < prices[i - 1])) {
                money += stock * prices[i];
            } else if ((prices[i - 3] > prices[i - 2]) && (prices[i - 2] > prices[i - 1])) {
                int canBuy = money / prices[i];
                stock += canBuy;
                money -= canBuy * prices[i];
            }
        }
        return stock * prices[13] + money;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // 보유 금액
        int money = Integer.parseInt(bufferedReader.readLine());
        // 주가
        String[] stock = bufferedReader.readLine().split(" ");
        int[] prices = new int[14];

        for (int i = 0; i < 14; i++) {
            prices[i] = Integer.parseInt(stock[i]);
        }

        if (jun(money, prices) == sung(money, prices)) {
            System.out.println("SAMESAME");
        } else {
            String result = jun(money, prices) > sung(money, prices) ? "BNP" : "TIMING";
            System.out.println(result);
        }
    }
}
