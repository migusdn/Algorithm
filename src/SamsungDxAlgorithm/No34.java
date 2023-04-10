package SamsungDxAlgorithm;

import java.util.Scanner;

public class No34 {

    static long[] status = new long[31];



    static long mod(int exp, int k) {
        long result = 1;
        for(int i = 0; i< status.length; i++) {
            if((exp & 1<<i) != 0) {
                result = (result * status[i]) % k;
            }
        }
        return result;
    }

    static long cal(int a, int b, int k) {
        int c = a+b;
        long e = mod(k,a+b);
        return Math.min((a*e)%c,(b*e)%c);
    }

    public static void main(String[] args){
        status[0]=2;
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1 ; test_case<= T; test_case++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();

            for(int i = 1; i< status.length; i++) {
                status[i] = (status[i-1] * status[i-1]) % (a+b);
            }
            sb.append("#" + test_case + " " + cal(a,b,k) + "\n");
        }
        System.out.println(sb);
    }
}

