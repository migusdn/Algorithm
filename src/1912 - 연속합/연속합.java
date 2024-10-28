import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : 연속합
 * @date : 2/6/24 9:11 PM
 * @modifyed : $
 **/
public class 연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = Integer.MIN_VALUE;
        dp[0] = Integer.parseInt(st.nextToken());
        for(int i=1; i<n; i++){
            int temp = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i-1]+temp, temp);
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
