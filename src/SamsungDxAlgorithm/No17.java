package SamsungDxAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class No17 {

    static int[] parent;

    public static void main(String[] args) throws Exception {
        class Node implements Comparable<Node> {
            int s;
            int e;
            int c;

            public Node(int s, int e, int c) {
                this.s = s;
                this.e = e;
                this.c = c;
            }

            @Override
            public int compareTo(Node o) {
                return this.c-o.c;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            List<Node> nodes = new ArrayList<>();
            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken()) - 1;
                int e = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken());
                nodes.add(new Node(s, e, c));
            }
            Collections.sort(nodes);
            int min = 0;
            for (Node node : nodes) {
                if (!isSameParent(node.s, node.e)) {
                    min += node.c;
                    union(node.s, node.e);
                }
            }

            System.out.println("#" + test_case + " " + min);
        }
    }

    static int find(int s) {
        if (parent[s] == s) {
            return s;
        }
        return parent[s] = find(parent[s]);
    }

    static void union(int s, int e) {
        s = find(s);
        e = find(e);
        if (s != e) {
            parent[s] = e;
        }
    }

    static boolean isSameParent(int s, int e) {
        return find(s) == find(e);
    }
}