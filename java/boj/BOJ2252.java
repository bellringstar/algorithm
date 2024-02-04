package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2252 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static ArrayList<Integer>[] adj;
	static int[] indegree;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			adj[i] = new ArrayList<>();
		indegree = new int[N + 1];
		for (int i = 0; i < M; i++) {
			int a = scan.nextInt(), b = scan.nextInt();
			indegree[b]++;
			adj[a].add(b);
		}
	}

	static void topologySort() {
		Queue<Integer> Q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0)
				Q.add(i);
		}

		while (!Q.isEmpty()) {
			int x = Q.poll();
			sb.append(x).append(' ');
			for (int y : adj[x]) {
				indegree[y]--;
				if (indegree[y] == 0) {
					Q.add(y);
				}
			}
		}
	}

	static void pro() {
		topologySort();
		System.out.println(sb.toString());
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
