package SamsungDxAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

class No3 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        StringBuilder sb = new StringBuilder();
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            String s = sc.next();
            long[] checkArr = new long[16];
            long[] stack = new long[16];
            char[] strArray = s.toCharArray();
            long answer = 0;
            checkArr[1] = 1;
            for (int j = 0; j < strArray.length; j++) {
                int temp = 1 << (strArray[j] - 'A');
                for (int k = 0; k < checkArr.length; k++) {
                    if (checkArr[k] > 0) {
                        for (int l = 0; l < checkArr.length; l++) {
                            if ((l & temp) != 0 && (k & l) != 0) {
                                stack[l] += checkArr[k];
                                stack[l] %= 1000000007;
                            }
                        }
                    }
                }
                System.arraycopy(stack, 0, checkArr, 0, stack.length);
                Arrays.fill(stack, 0);
            }
            for (int j = 0; j < checkArr.length; j++) {
                answer += checkArr[j];
                answer %= 1000000007;
            }
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
