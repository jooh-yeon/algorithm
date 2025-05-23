package may23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quit {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n+2];

            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int t = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                dp[i] = Math.max(dp[i], dp[i-1]);

                if ((i + t) <= (n + 1)) {
                    dp[i+t] = Math.max(dp[i+t], dp[i] + p);
                }
            }

            dp[n+1] = Math.max(dp[n+1], dp[n]);
            System.out.println(dp[n+1]);
        }
    }
