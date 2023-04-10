package SamsungDxAlgorithm;

import java.util.PriorityQueue;
import java.util.Scanner;


public class No26 {
    public static int n;
    public static int k;
    public static int[] arr;

    public static void main(String[] args) {
        class Node implements Comparable<Node> {
            int x;
            int y;

            public Node(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public int compareTo(Node node) {
                return this.x - node.x;
            }
        }
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }
            k = sc.nextInt();
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(0, k));
            while (!pq.isEmpty()) {
                if (pq.peek().y == 0) break;
                Node poll = pq.poll();
                int x = poll.x;
                int y = poll.y;
                pq.add(new Node(x + y, 0));
                for (int i = 1; i <= n; i++) {
                    pq.add(new Node(x + y % arr[i], y / arr[i]));
                }
            }
            sb.append("#").append(test_case).append(" ").append(pq.peek().x).append("\n");
        }
        System.out.print(sb);

    }

}
