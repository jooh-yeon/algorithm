package may12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFSAndBFS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        // 그래프 구하기
        ArrayList<Integer>[] graph = new ArrayList[vertex + 1];
        for (int i = 1; i <= vertex ; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 구하기
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int value1 = Integer.parseInt(st.nextToken());
            int value2 = Integer.parseInt(st.nextToken());
            graph[value1].add(value2);
            graph[value2].add(value1);
        }

        // 작은 정점부터 방문하기 위한 오름차순 정렬
        for (int i = 1; i <= vertex; i++) {
            Collections.sort(graph[i]);
        }

        boolean[] visitedDFS = new boolean[vertex + 1];
        dfs(graph, start, visitedDFS);
        System.out.println();
        boolean[] visitedBFS = new boolean[vertex + 1];
        bfs(graph, start, visitedBFS);
    }

    public static void dfs(ArrayList<Integer>[] graph, int start, boolean[] visitedDFS) {
        // dfs는 깊이 우선 탐색으로 재귀 사용
        visitedDFS[start] = true;
        System.out.print(start + " ");

        for (int next : graph[start]) {
            if (!visitedDFS[next]) {
                dfs(graph, next, visitedDFS);
            }
        }
    }

    public static void bfs(ArrayList<Integer>[] graph, int start, boolean[] visitedBFS) {
        // bfs는 너비 우선 탐색으로 Queue 사용
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visitedBFS[start] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int next : graph[node]) {
                if (!visitedBFS[next]) {
                    queue.add(next);
                    visitedBFS[next] = true;
                }
            }
        }
    }

}
