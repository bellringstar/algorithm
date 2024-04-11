package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1916 {

	static FastReader scan = new FastReader();
	static int N, M, start, end;
	static int[] dist;
	static ArrayList<Edge>[] edges;

	static class Info {
		int idx, dist;

		public Info(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}
	}

	static class Edge {
		int to, weight;

		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		dist = new int[N + 1];
		edges = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
			edges[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int from = scan.nextInt(), to = scan.nextInt(), weight = scan.nextInt();
			edges[from].add(new Edge(to, weight));
		}
		start = scan.nextInt();
		end = scan.nextInt();
	}

	static void dijkstra(int start) {
		dist[start] = 0;
		PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
		pq.add(new Info(start, 0));

		while (!pq.isEmpty()) {
			Info info = pq.poll();
			if (info.dist != dist[info.idx])
				continue;

			for (Edge e : edges[info.idx]) {
				if (e.weight + dist[info.idx] >= dist[e.to])
					continue;
				dist[e.to] = e.weight + dist[info.idx];
				pq.add(new Info(e.to, dist[e.to]));
			}
		}
	}

	static void pro() {
		dijkstra(start);
		System.out.println(dist[end]);
	}

	public static void main(String[] args) {
		input();
		pro();
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
