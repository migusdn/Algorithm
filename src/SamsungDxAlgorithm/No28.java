package SamsungDxAlgorithm;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class No28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        Set<String> set1;
        Set<String> set2;
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            set1 = new HashSet<>();
            set2 = new HashSet<>();
            for(int i=0; i<n; i++){
                set1.add(sc.next());
            }
            for(int i=0; i<m; i++){
                set2.add(sc.next());
            }
            int cnt=0;
            for(String str:set1){
                if(set2.contains(str))
                    cnt++;
            }
            sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);

    }
}
