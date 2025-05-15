package may15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ApartmentBFS {
    private static int n;
    private static int[][] board;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
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
                    sizes.add(bfs(i, j));
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

    public static int bfs(int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int size = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (0 <= nx && 0 <= ny && nx < n && ny < n) {
                    if (!visited[nx][ny] && (board[nx][ny] == 1)) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        size++;
                    }
                }
            }
        }
        return size;
    }
}
