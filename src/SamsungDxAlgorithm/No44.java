package SamsungDxAlgorithm;

import java.util.Scanner;

public class No44 {
    static int N, Q, sq;
    static int[] arr;
    static long[] bucketMax, bucketMin;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            Q = sc.nextInt();
            sq = (int) Math.sqrt(N);
            arr = new int[N];
            bucketMax = new long[N/sq+1];
            bucketMin = new long[N/sq+1];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
                if (i % sq == 0) {
                    bucketMax[i/sq] = arr[i];
                    bucketMin[i/sq] = arr[i];
                } else {
                    int bucketIdx = i/sq;
                    bucketMax[bucketIdx] = Math.max(bucketMax[bucketIdx], arr[i]);
                    bucketMin[bucketIdx] = Math.min(bucketMin[bucketIdx], arr[i]);
                }
            }

            System.out.print("#" + tc + " ");
            for (int i = 0; i < Q; i++) {
                int cmd = sc.nextInt();
                int l = sc.nextInt();
                int r = sc.nextInt();
                if (cmd == 0) {
                    update(l, r);
                } else {
                    System.out.print(query(l, r) + " ");
                }
            }
            System.out.println();
        }
    }

    private static void update(int idx, int val) {
        int bucketIdx = idx/sq;
        int startIdx = bucketIdx*sq;
        int endIdx = Math.min(startIdx+sq, N);
        bucketMax[bucketIdx] = arr[startIdx];
        bucketMin[bucketIdx] = arr[startIdx];
        for (int i = startIdx; i < endIdx; i++) {
            if (i == idx) {
                arr[i] = val;
            }
            bucketMax[bucketIdx] = Math.max(bucketMax[bucketIdx], arr[i]);
            bucketMin[bucketIdx] = Math.min(bucketMin[bucketIdx], arr[i]);
        }
    }

    private static long query(int left, int right) {
        int startBucketIdx = left/sq;
        int endBucketIdx = right/sq;
        long resMax = Integer.MIN_VALUE;
        long resMin = Integer.MAX_VALUE;

        // start
        for (int i = left; i < (startBucketIdx+1)*sq && i <= right; i++) {
            resMax = Math.max(resMax, arr[i]);
            resMin = Math.min(resMin, arr[i]);
        }
        // middle
        for (int i = startBucketIdx+1; i < endBucketIdx; i++) {
            resMax = Math.max(resMax, bucketMax[i]);
            resMin = Math.min(resMin, bucketMin[i]);
        }
        // end
        if (startBucketIdx != endBucketIdx) {
            for (int i = endBucketIdx*sq; i <= right; i++) {
                resMax = Math.max(resMax, arr[i]);
                resMin = Math.min(resMin, arr[i]);
            }
        }

        return resMax - resMin;
    }
}
