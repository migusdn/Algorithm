package SamsungDxAlgorithm.No32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class UserSolution {
    private static final int MAX_N = 100000;

    private static int N;
    private static char[] initString = new char[MAX_N + 5];
    private static char[] resultString = new char[MAX_N + 5];
    private static int[] changeCount = new int[MAX_N + 5];

    private static int changeIndex = 0;

    public static void init(int n, char[] init_string) {
        N = n;
        initString = Arrays.copyOf(init_string, N);
        Arrays.fill(changeCount, 0);
        changeIndex = 0;
    }

    public static int change(char[] string_A, char[] string_B) {
        int num = 0;
        String strA = new String(string_A);
        String strB = new String(string_B);

        while (true) {
            int index = new String(initString).indexOf(strA, changeIndex);
            if (index == -1) {
                break;
            }

            for (int i = 0; i < 3; i++) {
                resultString[changeIndex + i] = strB.charAt(i);
            }
            changeCount[changeIndex]++;
            num++;
            changeIndex += 3;
        }

        return num;
    }

    public static void result(char[] ret) {
        for (int i = 0; i < N; i++) {
            if (changeCount[i] == 0) {
                ret[i] = initString[i];

            } else {
                ret[i] = resultString[i];
            }
            System.out.print(ret[i]);
        }
        System.out.println("\n");
    }
}
