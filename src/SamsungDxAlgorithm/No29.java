package SamsungDxAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No29 {
    static int[] P;
    static char[] B;
    static char[] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            B = br.readLine().toCharArray();
            S = br.readLine().toCharArray();
            P = new int[S.length];
            getPi();
            int ans = 0;
            int i = 0, cnt = 0;
            while (i < B.length) {
                if (B[i] == S[cnt]) {
                    if (cnt == S.length - 1) {
                        ans++;
                        cnt = P[cnt];
                    } else cnt++;
                    i++;
                } else if (cnt > 0) cnt = P[cnt - 1];
                else i++;
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }

    private static void getPi() {
        P[0] = 0;
        for (int i = 1; i < S.length; i++) {
            int j = P[i - 1];
            while (j > 0) {
                if (S[i] == S[j]) break;
                j = P[j - 1];
            }
            if (S[i] == S[j]) P[i] = j + 1;
            else P[i] = 0;
        }
    }
}