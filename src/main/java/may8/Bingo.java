package may8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bingo {
    public static int condition(boolean[][] check) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (check[i][0] && check[i][1] && check[i][2] && check[i][3] && check[i][4]) {
                count++;
            }
            if (check[0][i] && check[1][i] && check[2][i] && check[3][i] && check[4][i]) {
                count++;
            }
        }
        if (check[0][0] && check[1][1] && check[2][2] && check[3][3] && check[4][4]) {
            count++;
        }
        if (check[0][4] && check[1][3] && check[2][2] && check[3][1] && check[4][0]) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[5][5];
        boolean[][] check = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        outer:
        for (int i = 0; i < 5; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                int mc = Integer.parseInt(line[j]);
                for (int x = 0; x < 5; x++) {
                    for (int y = 0; y < 5; y++) {
                        if (board[x][y] == mc) {
                            check[x][y] = true;
                        }
                    }
                }
                if (condition(check) >= 3) {
                    System.out.println(5 * i + j + 1);
                    break outer;
                }
            }
        }
    }
}
