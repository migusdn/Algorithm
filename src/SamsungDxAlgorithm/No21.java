package SamsungDxAlgorithm;
import java.util.Scanner;

public class No21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] v;
        int[] c;
        int[][] dp;
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase <= T; testCase++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            v = new int[n+1];
            c = new int[n+1];
            dp = new int[n+1][k+1];

            for (int i = 1; i <= n; i++) {
                v[i] = sc.nextInt();
                c[i] = sc.nextInt();
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    if (j < v[i]) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-v[i]] + c[i]);
                    }
                }
            }

            sb.append("#").append(testCase).append(" ").append(dp[n][k]).append("\n");
        }
        System.out.print(sb);
    }
}
