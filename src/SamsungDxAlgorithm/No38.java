package SamsungDxAlgorithm;

import java.util.Scanner;
import java.util.StringTokenizer;

public class No38 {
    static int N;
    static long M;
    static long max = 0;
    static long[] candy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            M = sc.nextLong();
            candy = new long[N];

            for (int i = 0; i < N; i++) {
                long num = sc.nextLong();
                candy[i] = num;
                max = Math.max(max, num);
            }
            sb.append("#").append(test_case).append(" ");
            if (max < M)
                sb.append(0).append("\n");
            else
                sb.append(binarySearch(1, max)).append("\n");
        }
        System.out.println(sb);
    }

    static long binarySearch(long start, long end) {
        long mid, sum;
        while (start <= end) {
            mid = (start + end) / 2;
            sum = 0;
            for (int i = 0; i < N; i++) {
                sum += candy[i] / mid;
            }
            if (sum < M) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start - 1;
    }
}
