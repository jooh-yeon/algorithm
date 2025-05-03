package may3;

import java.util.Scanner;

public class DigitSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] square = new int[n][m];

        // 2차원 배열 생성
        for (int i = 0; i < n; i++) {
            String line = scanner.next();
            for (int j = 0; j < m; j++) {
                square[i][j] = line.charAt(j) - '0';
            }
        }

        // 꼭짓점의 수가 같은 정사각형의 크기
        int maxSize = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int size = 1; size + i < n && size + j < m; size++) {
                    int val = square[i][j];
                    if (square[i][size + j] == val && square[i + size][j] == val
                    && square[i + size][j + size] == val) {
                        int area = (size + 1) * (size + 1);
                        maxSize = Math.max(maxSize, area);
                    }
                }
            }
        }
        System.out.println(maxSize);
    }
}
