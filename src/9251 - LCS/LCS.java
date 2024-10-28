import java.io.*;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : LCS
 * @date : 1/22/24 7:04 PM
 * @modifyed : $
 **/
public class LCS {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] string1 = br.readLine().toCharArray();
        char[] string2 = br.readLine().toCharArray();
        int[][] dp = new int[string1.length+1][string2.length+1];
        for(int i =1; i<string1.length+1; i++){
            for(int j=1; j<string2.length+1; j++){
                if(string1[i-1]==string2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[string1.length][string2.length]);

    }
}
