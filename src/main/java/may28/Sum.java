package may28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sum {
    static int[] arr;
    static int s;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 시작 인덱스, 누적합
        backtrack(0, 0);
        System.out.println(count);
    }

    static void backtrack(int depth, int sum) {
        // 기저 조건 : 끝까지 왔을 때
        if (depth == arr.length) {
            return ;
        }

        int newSum = sum + arr[depth];
        if (newSum == s) {
            count++;
        }
        // 현재 값을 포함하는 경우
        backtrack(depth + 1, newSum);

        // 현재 값을 포함하지 않는 경우
        backtrack(depth + 1, sum);
    }
}
