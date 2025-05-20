package may20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StairUp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] step = new int[n+1];

        for (int i = 1; i <= n; i++) {
            int score = Integer.parseInt(br.readLine());
            step[i] = score;
        }

        if (n == 1) {
            System.out.println(step[1]);
        } else if (n == 2) {
            System.out.println(step[1] + step[2]);
        } else if (n == 3) {
            System.out.println(Math.max(step[1] + step[3], step[2] + step[3]));
        }

        int[] dp = new int[n+1];
        dp[1] = step[1];
        dp[2] = step[1] + step[2];
        dp[3] = Math.max(step[1] + step[3], step[2] + step[3]);
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i-2] + step[i], dp[i-3] + step[i-1] + step[i]);
        }
        System.out.println(dp[n]);
    }
}
