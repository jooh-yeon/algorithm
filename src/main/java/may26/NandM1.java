package may26;

import java.util.Scanner;

public class NandM1 {
    static int n;
    static int m;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // n과 m 입력 받기
        n = scan.nextInt();
        m = scan.nextInt();

        // result 배열과 visited 배열 초기화
        result = new int[m];
        visited = new boolean[n + 1];

        // 백트래킹 시작
        backtracking(0);
    }

    static void backtracking(int depth) {
        // 종료 조건: depth가 m과 같아지면 출력 후 return
        if (depth == m) {
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        // 1부터 n까지 반복
        for (int i = 1; i <= n; i++) {
            // 아직 사용하지 않은 숫자라면
            if (!visited[i]) {
                // 사용했다고 표시
                visited[i] = true;
                // result의 depth 위치에 i값 저장
                result[depth] = i;

                // 다음 단계로 재귀 호출
                backtracking(depth + 1);

                // 사용 표시 되돌리기 (백트래킹)
                visited[i] = false;
            }
        }
    }
}
