package may15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ApartmentDFS {
    private static int n;
    private static int[][] board;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 단지 사이즈
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        // 집 존재유무 입력
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        visited = new boolean[n][n];
        List<Integer> sizes = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && (board[i][j] == 1)) {
                    sizes.add(dfs(i, j));
                    count++;
                }
            }
        }

        System.out.println(count);
        Collections.sort(sizes);
        for (int size : sizes) {
            System.out.println(size);
        }
    }

    // 단지별 size 출력
    public static int dfs(int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        visited[x][y] = true;
        int size = 1;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (!visited[nx][ny] && (board[nx][ny] == 1)) {
                    size += dfs(nx, ny);
                }
            }
        }
        return size;
    }
}
