package SamsungDxAlgorithm;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No16 {
	private static Node[] nodes, lines;
	private static int[] parents;
	static StringTokenizer st;
	private static class Node implements Comparable<Node> {
		int x, y;
		long w;

		private Node(int px, int py) {
			this.x = px;
			this.y = py;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			double ans = 0;
			parents = new int[n];
			nodes = new Node[n];
			lines = new Node[(int) Math.pow(n, 2)];
			int[] tmpXPosition = new int[n];
			int[] tmpYPosition = new int[n];
			for(int i=0; i<n; i++){
				tmpXPosition[i] = sc.nextInt();
			}
			for(int i=0; i<n; i++){
				tmpYPosition[i] = sc.nextInt();
			}

			for (int i = 0; i < n; i++) {
				nodes[i] = new Node(tmpXPosition[i], tmpYPosition[i]);
			}
			double d = sc.nextDouble();

			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					lines[cnt] = new Node(i, j);
					lines[cnt++].w = (long) Math.pow((nodes[i].x - nodes[j].x), 2)
							+ (long) Math.pow((nodes[i].y - nodes[j].y), 2);
				}
			}
			Arrays.sort(lines);
			Arrays.fill(parents, -1);

			for (int i = 0; i < lines.length; i++) {
				Node cur = lines[i];
				if (cur.w == 0)
					continue;
				if (union(cur.x, cur.y)) {
					ans += cur.w;
				}
			}
			ans *= d;
			sb.append("#").append(test_case).append(" ").append(Math.round(ans)).append("\n");
		}
		System.out.println(sb);
	}

	private static int find(int x) {
		if (parents[x] < 0)
			return x;
		return parents[x] = find(parents[x]);
	}

	private static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if (xRoot != yRoot) {
			parents[yRoot] = xRoot;
			return true;
		}
		return false;
	}
}