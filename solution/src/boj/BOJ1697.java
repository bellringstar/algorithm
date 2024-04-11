package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {

	static FastReader scan = new FastReader();

	static int N, K;
	static boolean[] visit;
	static int[] dist;

	static void input() {
		N = scan.nextInt();
		K = scan.nextInt();
		visit = new boolean[100001];
		dist = new int[100001];
	}

	static void bfs(int start) {
		Queue<Integer> Q = new LinkedList<>();
		Q.add(start);
		visit[start] = true;
		dist[start] = 0;
		while (!Q.isEmpty()) {
			int x = Q.poll();
			for (int i : new int[] {-1, 1, x}) {
				int nx = x + i;
				if (nx > 100000 || nx < 0)
					continue;
				if (visit[nx])
					continue;
				visit[nx] = true;
				Q.add(nx);
				dist[nx] = dist[x] + 1;
			}
		}
	}

	public static void main(String[] args) {
		input();
		bfs(N);
		System.out.println(dist[K]);
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
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
