package SamsungDxAlgorithm;

import java.util.*;

class N15 {
    public static int[] depth;
    public static int[] visited;
    public static int maxIdx;
    public static int bef;
    public static int n;
    public static ArrayList<ArrayList<Integer>> graph;

    public static int[][] ans;

    public static void init() {
        Queue<Integer> q = new LinkedList();
        int[] parents = new int[n + 1];
        Arrays.fill(parents, -1);
        q.add(1);
        parents[1] = 0;
        depth[0] = -1;
        while (!q.isEmpty()) {
            int current = q.poll();
            ans[current][0] = parents[current];
            depth[current] = depth[parents[current]] + 1;
            for (int i = 1; i <= maxIdx; i++) {
                int temp = ans[current][i - 1];
                ans[current][i] = ans[temp][i - 1];
            }
            for (int i = 0; i < graph.get(current).size(); i++) {
                int next = graph.get(current).get(i);
                if (parents[next] != -1) continue;
                parents[next] = current;
                q.add(next);
            }
        }
    }

    public static int getAns(int x, int y) {
        if (depth[x] != depth[y]) {
            if (depth[x] > depth[y]) {
                int temp = x;
                x = y;
                y = temp;
            }
            for (int i = maxIdx; i >= 0; i--) {
                if (depth[x] <= depth[ans[y][i]]) {
                    y = ans[y][i];
                }
            }
        }
        int lca = x;
        if (x == y) return lca;
        for (int i = maxIdx; i >= 0; i--) {
            if (ans[x][i] != ans[y][i]) {
                x = ans[x][i];
                y = ans[y][i];
            }
            lca = ans[x][i];
        }
        return lca;
    }

    public static void main(String[] args) throws Exception {

        //System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            visited = new int[n + 1];
            long res = 0;
            depth = new int[n + 1];
            maxIdx = 0;
            int tempDepth = n;
            while (tempDepth > 0) {
                maxIdx++;
                tempDepth /= 2;
            }
            graph = new ArrayList<>();
            ans = new int[n + 1][maxIdx + 1];
            for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
            for (int i = 2; i <= n; i++) graph.get(sc.nextInt()).add(i);
            for (int i = 1; i <= n; i++) Collections.sort(graph.get(i));
            depth[0] = -1;
            init();
            Arrays.fill(visited, -1);
            visited[1] = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            bef = 1;
            while (!q.isEmpty()) {
                int current = q.poll();
                int lca = getAns(bef, current);
                res += visited[bef] - visited[lca];
                res += visited[current] - visited[lca];
                for (int i = 0; i < graph.get(current).size(); i++) {
                    int nextIdx = graph.get(current).get(i);
                    if (visited[nextIdx] != -1) continue;
                    visited[nextIdx] = visited[current] + 1;
                    q.add(nextIdx);
                }
                bef = current;
            }
            sb.append("#").append(test_case).append(" ").append(res).append("\n");
        }
        System.out.println(sb);
    }
}