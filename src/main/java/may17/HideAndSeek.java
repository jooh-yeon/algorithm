package may17;import java.util.*;
import java.io.*;

public class HideAndSeek {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈의 위치
        int K = Integer.parseInt(st.nextToken()); // 동생의 위치

        // 이미 같은 위치에 있는 경우
        if (N == K) {
            System.out.println("0");
            System.out.println("1");
            return;
        }

        // 최단 시간과 방법의 수를 저장할 변수
        int minTime = 0;
        int count = 0;

        // BFS를 위한 큐
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        // 각 위치에 도달한 시간을 저장하는 배열
        int[] time = new int[100001];
        Arrays.fill(time, -1); // 초기값 -1 (방문하지 않음)
        time[N] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 이미 최단 시간을 찾았고, 현재 위치의 시간이 최단 시간보다 크면 종료
            if (minTime != 0 && time[current] > minTime) break;

            // 동생을 찾은 경우
            if (current == K) {
                minTime = time[current];
                count++;
                continue; // 다른 경로도 확인하기 위해 continue
            }

            // 다음 위치 탐색 (X-1, X+1, 2*X)
            int[] nextPositions = {current - 1, current + 1, current * 2};

            for (int next : nextPositions) {
                // 범위를 벗어나면 스킵
                if (next < 0 || next > 100000) continue;

                // 첫 방문이거나 (time[next] == -1) 현재까지의 최단 시간과 같은 경우 (time[next] == time[current] + 1)
                if (time[next] == -1 || time[next] == time[current] + 1) {
                    time[next] = time[current] + 1;
                    queue.offer(next);
                }
            }
        }

        System.out.println(minTime);
        System.out.println(count);
    }
}