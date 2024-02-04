package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1005 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] indegree, T_done, T;
	static ArrayList<Integer>[] adj;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		adj = new ArrayList[N + 1];
		indegree = new int[N + 1];
		T = new int[N + 1];
		T_done = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
			T[i] = scan.nextInt();
		}
		for (int i = 0; i < M; i++) {
			int x = scan.nextInt(), y = scan.nextInt();
			adj[x].add(y);
			indegree[y]++;
		}
	}

	static void pro() {
		Deque<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
				T_done[i] = T[i];
			}
		}

		while (!queue.isEmpty()) {
			int x = queue.poll();
			for (int y : adj[x]) {
				indegree[y]--;
				if (indegree[y] == 0)
					queue.add(y);
				T_done[y] = Math.max(T_done[y], T_done[x] + T[y]);
			}
		}
		int W = scan.nextInt();
		System.out.println(T_done[W]);
	}

	public static void main(String[] args) {
		int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			input();
			pro();
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
