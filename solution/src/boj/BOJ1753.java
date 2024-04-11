package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753 {

	static FastReader scan = new FastReader();
	static int V, E, start;
	static ArrayList<Edge>[] edges;
	static int[] dist;

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
		V = scan.nextInt();
		E = scan.nextInt();
		start = scan.nextInt();
		edges = new ArrayList[V + 1];
		dist = new int[V + 1];
		for (int i = 1; i <= V; i++)
			edges[i] = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			int from = scan.nextInt();
			int to = scan.nextInt();
			int weight = scan.nextInt();
			edges[from].add(new Edge(to, weight));
		}
	}

	static void dijkstra(int start) {
		for (int i = 1; i <= V; i++)
			dist[i] = Integer.MAX_VALUE;
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

	public static void main(String[] args) {
		input();
		dijkstra(start);
		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
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
