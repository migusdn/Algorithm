import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : 계단오르기
 * @date : 1/22/24 5:46 PM
 * @modifyed : $
 **/
public class 계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp;
        int[] cost;
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 4];
        cost = new int[n + 4];
        for (int i = 1; i < n + 1; i++) {
            int temp = Integer.parseInt(br.readLine());
            cost[i] = temp;
        }
        dp[1] = cost[1];
        dp[2] = cost[1] + cost[2];
        dp[3] = Math.max(cost[1], cost[2]) + cost[3];
        for (int i = 4; i < n + 1; i++) {
            dp[i] = Math.max(dp[i - 3] + cost[i - 1], dp[i - 2]) + cost[i];
        }
        System.out.println(dp[n]);


    }
}
