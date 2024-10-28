import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : 가장긴증가하는부분수열
 * @date : 1/22/24 6:25 PM
 * @modifyed : $
 **/
public class 가장긴증가하는부분수열 {
    public static int[] dp;
    public static int[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n];
        values = new int[n];
        String[] inputs = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            values[i] = Integer.parseInt(inputs[i]);
        }
        for(int i=0; i<n; i++){
            findLength(i);
        }
        int max=0;
        for(int i=0 ;i<n;i++){
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }

    public static int findLength(int n) {
        if (dp[n] == 0) {
            dp[n] = 1;
            for(int i = n-1; i>=0; i--){
                if(values[i]<values[n]){
                    dp[n] = Math.max(dp[n], findLength(i)+1);
                }
            }
        }
        return dp[n];
    }

}
