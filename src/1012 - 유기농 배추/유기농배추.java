import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : 유기농배추
 * @date : 2/23/24 1:12 AM
 * @modifyed : $
 **/
public class 유기농배추 {
    public static boolean[][] map;
    public static boolean[][] visited;
    public static int[] dx = new int[]{0,0,1,-1};
    public static int[] dy = new int[]{-1,1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i =0; i<t; i++){
            String[] inputs = br.readLine().split(" ");
            int m = Integer.parseInt(inputs[0]);
            int n = Integer.parseInt(inputs[1]);
            int k = Integer.parseInt(inputs[2]);
            int ans=0;
            map = new boolean[m][n];
            visited = new boolean[m][n];
            Queue<int[]> queue = new LinkedList<>();
            for(int j=0; j<k; j++){
                String[] temp = br.readLine().split(" ");
                int[] position = new int[]{Integer.parseInt(temp[0]), Integer.parseInt(temp[1])};
                map[position[0]][position[1]] = true;
            }
            for(int r=0; r<m; r++){
                for(int c=0; c<n; c++){
                    if(map[r][c]&&!visited[r][c]){
                        ans++;
                        queue.offer(new int[]{r,c});
                        while(!queue.isEmpty()){
                            int[] cur = queue.poll();
                            if(visited[cur[0]][cur[1]])
                                continue;
                            visited[cur[0]][cur[1]] = true;
                            for(int p = 0; p<4; p++){
                                int x = cur[0]+dx[p];
                                int y = cur[1]+dy[p];
                                if(x<0||x>=m||y<0||y>=n)
                                    continue;
                                if(!visited[x][y]&&map[x][y]){
                                    queue.offer(new int[]{x,y});
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
