package SamsungDxAlgorithm;

import java.util.LinkedList;
import java.util.Scanner;

public class No35 {
    static Integer[] arr;
    static long answer;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            arr = new Integer[N];
            answer = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.valueOf(sc.next());
            }
            sort(0, N - 1);
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }

    static LinkedList<Integer> sort(int start, int end) {
        LinkedList<Integer> list = new LinkedList<>();
        if (end - start == 0) {
            list.add(arr[start]);
            return list;
        }
        int mid = (start + end) / 2;
        list = merge(sort(start, mid), sort(mid + 1, end));
        return list;
    }

    static LinkedList<Integer> merge(LinkedList<Integer> linkedList1, LinkedList<Integer> linkedList2) {
        LinkedList<Integer> temp = new LinkedList<>();
        int length1 = linkedList1.size();
        int length2 = linkedList2.size();
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 != length1 && idx2 != length2) {
            Integer n1 = linkedList1.peek();
            Integer n2 = linkedList2.peek();
            if (n1 > n2) {
                temp.add(linkedList2.poll());
                idx2++;
                answer += linkedList1.size();
            } else {
                temp.add(linkedList1.poll());
                idx1++;
            }
        }
        if (idx1 != length1) {
            temp.addAll(linkedList1);
        }
        if (idx2 != length2) {
            temp.addAll(linkedList2);
        }
        return temp;
    }
}