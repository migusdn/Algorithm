import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : 헌내기는친구가필요해
 * @date : 2/21/24 9:52 PM
 * @modifyed : $
 **/
public class 헌내기는친구가필요해 {
    public static final int[] dx = new int[]{0, 0, -1, 1};
    public static final int[] dy = new int[]{-1, 1, 0, 0};
    public static boolean[][] visited;
    public static int answer = 0;
    public static int[][] graph;
    public static int N, M;
    public static final int O = 0;
    public static final int X = 1;
    public static final int P = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        graph = new int[N][M];
        visited = new boolean[N][M];
        int[] dyPosition = new int[2];
        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                char current = row[j];
                switch (current) {
                    case 'O': {
                        graph[i][j] = O;
                        break;
                    }
                    case 'X': {
                        graph[i][j] = X;
                        break;
                    }
                    case 'I': {
                        graph[i][j] = O;
                        dyPosition[0] = i;
                        dyPosition[1] = j;
                        break;
                    }
                    case 'P': {
                        graph[i][j] = P;
                        break;
                    }
                }
            }
        }
        meetFriends(dyPosition[0], dyPosition[1]);
        System.out.println(answer == 0 ? "TT" : answer);
    }

    public static void meetFriends(int x, int y) {

        if (x < 0 || x >= N || y < 0 || y >= M || visited[x][y])
            return;
        visited[x][y] = true;
        if (graph[x][y] == O || graph[x][y] == P) {
            if (graph[x][y] == P) {
                answer++;
            }
            for (int i = 0; i < 4; i++) {
                meetFriends(x + dx[i], y + dy[i]);
            }
        } else if (graph[x][y] == X) {
            visited[x][y] = true;
            return;
        }
    }
}
