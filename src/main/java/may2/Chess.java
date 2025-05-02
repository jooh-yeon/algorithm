package may2;

import java.util.Scanner;

public class Chess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기

        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = scanner.nextLine().toCharArray();
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                result = Math.min(result, count(board, i, j));
            }
        }
        System.out.println(result);
    }

    public static int count(char[][] board, int x, int y) {
        int count1 = 0; // W로 시작
        int count2 = 0; // B로 시작

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char expected1 = ((i + j) % 2 == 0) ? 'W' : 'B';
                char expected2 = ((i + j) % 2 == 0) ? 'B' : 'W';

                if (board[x + i][y + j] != expected1) count1++;
                if (board[x + i][y + j] != expected2) count2++;
            }
        }
        return Math.min(count1, count2);
    }
}