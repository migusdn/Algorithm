import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Q1260 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        boolean[][] graph = new boolean[n + 1][n + 1];
        boolean[] visit;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        boolean flag = false;
        visit = new boolean[n + 1];
        visit[v] = true;
        sb.append(v).append(" ");
        while (!stack.isEmpty()) {
            int num = stack.peek();
            flag = false;
            for (int i = 0; i < graph[num].length; i++) {
                if (graph[num][i] && !visit[i]) {
                    stack.push(i);
                    visit[i] = true;
                    flag = true;
                    sb.append(i).append(" ");
                    break;
                }
            }
            if(!flag)
                stack.pop();
        }
        sb.append("\n");
        sb.append(v).append(" ");
        Queue<Integer> queue = new LinkedList<>();
        visit = new boolean[n + 1];
        visit[v] = true;
        queue.add(v);
        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int i = 0; i < graph[num].length; i++) {
                if (graph[num][i] && !visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();

    }
}