package SamsungDxAlgorithm;

import java.util.*;

public class No33 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for(int test_case=1; test_case<=T; test_case++) {
            int N = sc.nextInt();
            String[] names = new String[N];
            for(int i=0; i<N; i++) {
                names[i] = sc.next();
            }

            Arrays.sort(names, (o1, o2) -> {
                if(o1.length()==o2.length())
                    return o1.compareTo(o2);
                return o1.length()-o2.length();
            });

            sb.append("#").append(test_case).append("\n");

            String temp="";
            for(String str: names) {
                if(!temp.equals(str)) {
                    sb.append(str).append("\n");
                }
                temp = str;
            }
        }
        System.out.println(sb);
    }

}