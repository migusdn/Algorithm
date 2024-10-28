import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : 파일합치기
 * @date : 1/17/24 7:09 PM
 * @modifyed : $
 **/
public class 파일합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            int[] cost = new int[K + 1];
            int[] sum = new int[K + 1];
            int[][] dp = new int[K + 1][K + 1];
            String[] costStr = br.readLine().split(" ");
            for (int j = 1; j <= K; j++) {
                cost[j] = Integer.parseInt(costStr[j-1]);
                sum[j] = cost[j] + sum[j - 1];
            }
            //몇장씩 묶을 것인가
            for (int m = 1; m <= K; m++) {
                //묶는 시작점
                for (int s = 1; s+m <= K; s++) {
                    //묶는 마지막 점
                    int e = s + m;
                    dp[s][e] = Integer.MAX_VALUE;
                    //나누는 지점
                    for (int d = s; d < e; d++) {
                        dp[s][e] = Math.min(dp[s][e], dp[s][d]+dp[d+1][e]+sum[e]-sum[s-1]);
                    }
                }
            }
            System.out.println(dp[1][K]);
        }
    }

}
