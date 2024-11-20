package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11657 {
	static FastReader scan = new FastReader();
	static int N, M;
	static Edge[] edges;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		edges = new Edge[M];

		for (int i = 0; i < M; i++) {
			edges[i] = new Edge(scan.nextInt(), scan.nextInt(), scan.nextInt());
		}
	}

	static void solve() {
		long[] dist = new long[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;

		boolean hasNegativeCycle = false;

		for (int i = 1; i <= N; i++) {
			for (Edge edge : edges) {
				if (dist[edge.from] != Integer.MAX_VALUE &&
					dist[edge.to] > dist[edge.from] + edge.cost) {
					dist[edge.to] = dist[edge.from] + edge.cost;

					if (i == N) {
						// N인데도 갱신? -> 음수 사이클 존재
						hasNegativeCycle = true;
						break;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		if (hasNegativeCycle) {
			System.out.println(-1);
		} else {
			for (int i = 2; i <= N; i++) {
				if (dist[i] == Integer.MAX_VALUE) {
					sb.append(-1).append('\n');
				} else {
					sb.append(dist[i]).append('\n');
				}
			}
			System.out.println(sb);
		}
	}

	public static void main(String[] args) {
		input();
		solve();
	}

	static class Edge {
		int from;
		int to;
		int cost;

		Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
