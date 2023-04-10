package SamsungDxAlgorithm;

import java.util.Scanner;

public class No37 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        long N;
        long ans;
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextLong();
            ans = calculate(N);
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static long calculate(long N) {
        long result = 0;
        long idx = -1;
        for(long n=(long)Math.sqrt(N*2)+1; ; ++n) {
            result = (n*(n+1))/2;
            if( result == N ){
                idx = n;
                break;
            }else if( result > N ){
                break;
            }
        }
        return idx;
    }
}