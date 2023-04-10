package SamsungDxAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No39 {
    static int L;
    static int N;
    static int result;
    static int sum;
    static int x;
    static int y;
    static boolean schedule[] = new boolean[100000000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st=null;
        for (int t = 1; t <= T; t++) {
            L = Integer.parseInt(br.readLine());
            N = Integer.parseInt(br.readLine());
            result = 0;
            x = 0;
            y = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                for(int start=x;start<y;start++) {
                    schedule[start]=true;
                }
            }
            sum=0;
            for(int i=0;i<L;i++) {
                sum+=(schedule[i] ? 1 : 0);
            }
            result=sum;
            int start=0;
            for(int end=L;end<y;end++) {
                sum-=(schedule[start++] ? 1 : 0);
                sum+=(schedule[end] ? 1 : 0);
                result=Math.max(result, sum);
            }
            System.out.println("#" + t + " " + result);
            for (int i = 0; i < y; i++) {
                schedule[i] = false;
            }
        }
    }
}