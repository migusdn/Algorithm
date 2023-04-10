package SamsungDxAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class No40 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int cowNum = sc.nextInt();
            int horNum = sc.nextInt();

            int[] cow = new int[N];
            for (int i = 0; i < N; i++)
                cow[i] = sc.nextInt();
            Arrays.sort(cow);

            int res = Integer.MAX_VALUE;
            int cnt = 0;
            for(int i = 0; i < M; i++) {
                int horse = sc.nextInt();
                int l = 0, r = N - 1, mid = 0, idx = -1;
                while(l <= r) {
                    mid = (l + r) / 2;

                    if(cow[mid] == horse) {
                        idx = mid;
                        break;
                    }
                    else if(cow[mid] > horse) r = mid - 1;
                    else l = mid + 1;
                }

                if(cow[mid] < horse) idx = mid + 1;
                else idx = mid;

                if(0 <= idx && idx < N && res > Math.abs(cow[idx] - horse)) {
                    res = Math.abs(cow[idx] - horse);
                    cnt = 1;
                }
                else if(0 <= idx && idx < N && res == Math.abs(cow[idx] - horse)) ++cnt;

                if(idx - 1 < 0) continue;
                if(res > Math.abs(cow[idx - 1] - horse)) {
                    res = Math.abs(cow[idx - 1] - horse);
                    cnt = 1;
                }
                else if(res == Math.abs(cow[idx - 1] - horse)) ++cnt;
            }

            res += Math.abs(cowNum - horNum);
            sb.append("#").append(test_case).append(" ").append(res).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}