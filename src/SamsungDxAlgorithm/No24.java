package SamsungDxAlgorithm;

import java.util.PriorityQueue;
import java.util.Scanner;

public class No24 {
    static int N;
    static int minT;
    static int map[][];
    static boolean visited[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static PriorityQueue<Node> priorityQueue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            map = new int[N][N];
            visited = new boolean[N][N];
            priorityQueue = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                String str = sc.next();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }
            minT = Integer.MAX_VALUE;
            bfs();
            sb.append("#").append(test_case).append(" ").append(minT).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        visited[0][0] = true;
        priorityQueue.offer(new Node(0, 0, 0));
        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            int x = node.x;
            int y = node.y;
            int t = node.t;
            if (x == N - 1 && y == N - 1) {
                minT = Math.min(minT, t);
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])
                    continue;
                visited[nx][ny] = true;
                priorityQueue.offer(new Node(nx, ny, t + map[nx][ny]));
            }
        }
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int t;

        public Node(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }

        public int compareTo(Node o) {
            return this.t - o.t;
        }
    }
}