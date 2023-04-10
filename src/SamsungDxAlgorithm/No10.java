package SamsungDxAlgorithm;

import java.util.Scanner;
import java.util.StringTokenizer;

class No10 {
    public static void main(String args[]) throws Exception {

        //System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = 10;
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int maxVertex = Integer.parseInt(sc.nextLine());
            String[] data = new String[maxVertex + 1];
            int[] node = new int[maxVertex * 2 + 2];
            for (int i = 1; i <= maxVertex; i++) {
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                int num = Integer.parseInt(st.nextToken());
                String value = st.nextToken();
                int left = -1;
                int right = -1;
                if (st.hasMoreTokens()) {
                    left = Integer.parseInt(st.nextToken());
                    if (st.hasMoreTokens()) {
                        right = Integer.parseInt(st.nextToken());
                    }
                }
                data[num] = value;
                node[num * 2 - 1] = left;
                node[num * 2] = right;
            }

            sb.append("#").append(test_case).append(" ").append(calculator(data, node, 1)).append("\n");
        }
        System.out.println(sb);
    }

    public static int calculator(String[] data, int[] node, int current) {
        int result = 0;
        if (current > 0 && current < data.length) {
            int left = node[current * 2 - 1];
            int right = node[current * 2];
            String value = data[current];
            if (left == -1) {
                return Integer.parseInt(value);
            } else {
                int x = calculator(data, node, left);
                int y = calculator(data, node, right);
                switch (value) {
                    case "+": {
                        result = x + y;
                        break;
                    }
                    case "-": {
                        result = x - y;
                        break;
                    }
                    case "*": {
                        result = x * y;
                        break;
                    }
                    case "/": {
                        result = x / y;
                        break;
                    }
                }
            }
        }
        return result;
    }
}