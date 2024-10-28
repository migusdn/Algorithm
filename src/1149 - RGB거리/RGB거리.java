import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : RGB거리
 * @date : 1/18/24 6:46 PM
 * @modifyed : $
 **/
public class RGB거리 {
    public static final int R = 0;
    public static final int G = 1;
    public static final int B = 2;
    public static int[][] cost;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        cost = new int[n][3];
        dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<3; c++){
                cost[i][c] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][R] = cost[0][R];
        dp[0][G] = cost[0][G];
        dp[0][B] = cost[0][B];
        System.out.println(Math.min(getCost(n-1,0),Math.min(getCost(n-1,1), getCost(n-1,2))));
    }

    public static int getCost(int n, int color) {
        if (dp[n][color] == 0) {
            switch (color) {
                case R: {
                    dp[n][color] = cost[n][0] + Math.min(getCost(n - 1, 1), getCost(n - 1, 2));
                    break;
                }
                case G: {
                    dp[n][color] = cost[n][1] + Math.min(getCost(n - 1, 0), getCost(n - 1, 2));
                    break;
                }
                case B: {
                    dp[n][color] = cost[n][2] + Math.min(getCost(n - 1, 0), getCost(n - 1, 1));
                    break;
                }
            }
        }
        return dp[n][color];
    }
}
