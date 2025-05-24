package may24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Guitarist {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] v = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] dp = new boolean[m + 1];
        dp[s] = true;

        for (int i = 0; i < n; i++) {
            boolean[] next = new boolean[m + 1];

            for (int j = 0; j <= m; j++) {
                if (dp[j]) {
                    if (j + v[i] <= m) {
                        next[j + v[i]] = true;
                    }
                    if (j - v[i] >= 0) {
                        next[j - v[i]] = true;
                    }
                }
            }
            dp = next;
        }

        int answer = -1;
        for (int i = m; i >= 0; i--) {
            if (dp[i]) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
