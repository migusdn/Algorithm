package SamsungDxAlgorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No14 {
    static int n;
    static int count;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static boolean[][] visited;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            map = new char[n][n];
            count = 0;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                String str = sc.next();
                for (int j = 0; j < n; j++) {
                    map[i][j] = str.charAt(j);
                }
            }
            findMine();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == '0' && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] != '*' && !visited[i][j]) {
                        count++;
                    }
                }
            }
            sb.append("#").append(test_case).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Queue<Mine> queue = new LinkedList<>();
        queue.offer(new Mine(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Mine p = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < n && !visited[nx][ny] && map[nx][ny] != '*') {
                    visited[nx][ny] = true;
                    if (map[nx][ny] == '0') {
                        queue.offer(new Mine(nx, ny));
                    }
                }
            }
        }
    }

    static void findMine() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '.') {
                    int mineCnt = 0;
                    for (int k = 0; k < 8; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (0 <= nx && nx < n && 0 <= ny && ny < n && map[nx][ny] == '*') {
                            mineCnt++;
                        }
                    }
                    map[i][j] = (char) (mineCnt + '0');
                }
            }
        }
    }
}

class Mine {
    int x, y;

    public Mine(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

}
