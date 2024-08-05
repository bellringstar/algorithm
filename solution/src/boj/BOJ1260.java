package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {

	static FastReader scan = new FastReader();

	static int N, M, V;
	static List<int[]> graph = new ArrayList<>();

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		V = scan.nextInt();

		for (int i = 0; i <= N; i++) {
			graph.add(new int[N+1]);
		}

		for (int i = 0; i < M; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			graph.get(a)[b] = 1;
			graph.get(b)[a] = 1;
		}
	}

	static void dfs(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		for (int u = 1; u <= N; u++) {
			if (graph.get(v)[u] == 1 && !visited[u]) {
				dfs(u, visited);
			}
		}
	}

	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		queue.add(v);
		visited[v] = true;

		while (!queue.isEmpty()) {
			int u = queue.poll();
			System.out.print(u + " ");
			for (int i = 1; i <= N; i++) {
				if (graph.get(u)[i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		input();
		dfs(V, new boolean[N + 1]);
		System.out.println();
		bfs(V);
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
	}
}
