package SamsungDxAlgorithm;

import java.io.IOException;
import java.util.Scanner;

public class No36 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int p = sc.nextInt();

            int[] sum = new int[1000000 + 1];
            int state = 0;
            int idx = 0;
            for (int i = 0; i < n; i++) {
                int day = sc.nextInt();
                while (idx != day) {
                    sum[idx++] = state;
                }
                state++;
            }
            while (idx < sum.length) {
                sum[idx++] = state;
            }
            int left = 2;
            int right = n + p;
            int mid = 0;
            int ans = -1;
            while (true) {
                if (left > right) break;

                int max = -1;
                mid = (left + right) / 2;

                for (int i = 0; i < sum.length - (mid - 1); i++) {
                    max = Math.max(max, sum[i + (mid - 1)] - (i == 0 ? 0 : sum[i - 1]));
                }
                if (max + p > mid) {
                    left = mid + 1;
                } else if (max + p < mid) {
                    right = mid - 1;
                } else {
                    ans = mid;
                    left = mid + 1;
                }

            }

            sb.append("#").append(test_case).append(" ").append(ans);
        }
        System.out.println(sb);
    }
}