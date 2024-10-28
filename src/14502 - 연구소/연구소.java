import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : 연구소
 * @date : 3/6/24 8:21 PM
 * @modifyed : $
 **/
public class 연구소 {
    public static int[] dx = new int[]{0, 0, -1, 1};
    public static int[] dy = new int[]{-1, 1, 0, 0};
    public static int maxSafeAreaCnt = 0;
    public static int[][] map;
    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }
        dfs(0,0);
        System.out.println(maxSafeAreaCnt);

    }

    public static void dfs(int idx, int count) {
        if (count == 3) {
            int[][] copiedMap = new int[n][];
            for(int i=0; i<n; i++){
                copiedMap[i] = map[i].clone();
            }
            bfs(copiedMap);
            return;
        }
        for (int i = idx; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            if (map[r][c] == 0) {
                map[r][c] = 1;
                dfs(idx + 1, count + 1);
                map[r][c] = 0;
            }
        }
        dfs(0,0);
    }
    public static void bfs(int[][] copiedMap){
        boolean[][] visited = new boolean[n][m];
        Queue<Integer[]> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(copiedMap[i][j]==2){
                    queue.offer(new Integer[]{i,j});
                }
            }
        }
        while (!queue.isEmpty()){
            Integer[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            if(visited[x][y]){
                continue;
            }
            visited[x][y] = true;
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0||ny<0||nx>=n||ny>=m)
                    continue;
                if(copiedMap[nx][ny]==0&&!visited[nx][ny])
                    queue.offer(new Integer[]{nx,ny});
            }
        }
        calculateSafeAreaCount(copiedMap);
    }
    public static void calculateSafeAreaCount(int[][] copiedMap){
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++)
                if(copiedMap[i][j]==0)
                    cnt++;
        }
        maxSafeAreaCnt = Math.max(maxSafeAreaCnt, cnt);
    }
}
