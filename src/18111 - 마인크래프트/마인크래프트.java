import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : 마인크래프트
 * @date : 1/22/24 8:42 PM
 * @modifyed : $
 **/
public class 마인크래프트 {
    static int[][] map;
    static int n, m, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int level = -1;
        int cost = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                min = Math.min(min, temp);
                max = Math.max(max, temp);
            }
        }
        for (int i = min; i <= max; i++) {
            int tempCost = getCost(i);
            if (cost >= tempCost) {
                cost = tempCost;
                level = i;
            }
        }
        System.out.print(cost+" "+level);
    }

    public static int getCost(int level) {
        int remainBlock = b;
        int cost = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int currentLevel = map[i][j];
                int diff = level - currentLevel;
                if (diff == 0)
                    continue;
                else if (diff > 0) {
                    cost += diff;
                    remainBlock -= diff;
                } else {
                    cost += -2*diff;
                    remainBlock -= diff;
                }
            }
        }
        if(remainBlock<0)
            return Integer.MAX_VALUE;
        return cost;
    }
}
