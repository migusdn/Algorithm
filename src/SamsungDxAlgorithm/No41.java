package SamsungDxAlgorithm;
import java.util.Arrays;
import java.util.Scanner;

public class No41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int K = sc.nextInt();
            String str = sc.next();
            String[] prefix = new String[str.length()];
            for (int i = 0; i < str.length(); i++) {
                prefix[i] = str.substring(i, str.length());
            }
            Arrays.sort(prefix);
            sb.append("#").append(test_case).append(" ").append(prefix[K - 1]);

        }
    }
}
