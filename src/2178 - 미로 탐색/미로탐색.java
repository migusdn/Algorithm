import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : 미로탐색
 * @date : 3/5/24 9:12 PM
 * @modifyed : $
 **/
public class 미로탐색 {
    public static int[] dx = new int[]{1, -1, 0, 0};
    public static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        boolean[][] visited = new boolean[n][m];
        boolean[][] map = new boolean[n][m];
        int[][] result = new int[n][m];
        Queue<Integer[]> queue = new LinkedList<>();
        for (int r = 0; r < n; r++) {
            char[] row = br.readLine().toCharArray();
            for (int c = 0; c < m; c++) {
                if (row[c] == '0')
                    map[r][c] = false;
                else
                    map[r][c] = true;
            }
        }
        queue.offer(new Integer[]{0, 0});
        result[0][0] = 1;
        while (!queue.isEmpty()) {
            Integer[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            if (visited[x][y])
                continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (visited[nx][ny] || !map[nx][ny])
                    continue;
                result[nx][ny] = result[x][y] + 1;
                queue.offer(new Integer[]{nx, ny});
            }
            visited[x][y] = true;
        }
        System.out.println(result[n - 1][m - 1]);


    }
}
