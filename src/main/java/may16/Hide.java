package may16;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Hide {
    // 위치와 시간을 함께 저장할 클래스
    static class Node {
        int pos;  // 현재 위치
        int time; // 현재까지 걸린 시간

        Node(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();  // 수빈 위치
        int k = scan.nextInt();  // 동생 위치

        boolean[] visited = new boolean[100001];
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(n, 0));  // 시작 위치, 시간 0
        visited[n] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.pos == k) {  // 도착하면 시간 출력 후 종료
                System.out.println(now.time);
                break;
            }

            int[] nextPositions = {now.pos - 1, now.pos + 1, now.pos * 2};
            for (int next : nextPositions) {
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    queue.add(new Node(next, now.time + 1));
                }
            }
        }
    }
}
