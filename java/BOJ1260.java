import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1260 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, M, V;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		V = scan.nextInt();

		graph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int start = scan.nextInt(), to = scan.nextInt();
			graph[start].add(to);
			graph[to].add(start);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}
	}

	static void dfs(int v) {
		sb.append(v).append(' ');
		visited[v] = true;

		for (int x : graph[v]) {
			if (visited[x]) continue;
			dfs(x);
		}
	}

	static void bfs(int v) {

		Deque<Integer> queue = new LinkedList<>();
		queue.add(v);
		visited[v] = true;

		while (!queue.isEmpty()) {
			int x = queue.poll();
			sb.append(x).append(' ');
			for (int y : graph[x]) {
				if (visited[y]) continue;
				queue.add(y);
				visited[y] = true;
			}
		}
	}

	public static void main(String[] args) {
		input();
		visited = new boolean[N + 1];
		dfs(V);
		sb.append('\n');
		for (int i = 1; i <= N; i++) {
			visited[i] = false;
		}
		bfs(V);
		System.out.println(sb);
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
