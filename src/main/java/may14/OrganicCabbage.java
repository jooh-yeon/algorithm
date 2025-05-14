package may14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OrganicCabbage {
    private static int m;
    private static int n;
    private static int[][] graph;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        while (t > 0) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // 밭 생성
            graph = new int[n][m];
            // 배추 -> 1
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[y][x] = 1;
            }

            visited = new boolean[n][m];
            int count = 0;
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (!visited[a][b] && graph[a][b] == 1) {
                        dfs(a, b);
                        count++;
                    }
                }
            }
            System.out.println(count);
            t--;
        }
    }

    public static void dfs(int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        visited[x][y] = true;

        // 상하좌우 4칸 이동 => 범위: 0, 1, 2, 3
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 범위를 벗어나지 않고, 배추가 있으며, 아직 방문하지 않은 경우
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (!visited[nx][ny] && graph[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
