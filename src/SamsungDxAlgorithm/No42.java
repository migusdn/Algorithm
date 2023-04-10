package SamsungDxAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

public class No42 {

    public static void main(String args[]) throws Exception {
        int T;
        String result = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int k = 0;
            int position = Integer.parseInt(br.readLine());
            StringBuilder sbTemp = new StringBuilder(br.readLine());
            TreeSet<String> set = new TreeSet<String>();
            for (int i = 0; i < sbTemp.length(); i++) {
                for (int j = 0; j < sbTemp.length(); j++) {
                    if (i + j < sbTemp.length()) {
                        set.add(sbTemp.substring(j, i + j + 1));
                    }
                }
            }
            Iterator<String> it = set.iterator();
            if (set.size() < position) {
                sb.append("#").append(test_case).append(" none").append("\n");
            } else {
                while (it.hasNext()) {
                    k++;
                    result = it.next();
                    if (k == position) {
                        sb.append("#").append(test_case).append(" ").append(result).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.print(sb);
    }
}
