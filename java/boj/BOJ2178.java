package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {

	static FastReader scan = new FastReader();

	static int N, M;
	static String[] A;
	static int[][] distance;
	static boolean[][] visit;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		A = new String[N];
		for (int i = 0; i < N; i++) {
			A[i] = scan.nextLine();
		}
		distance = new int[N][M];
		visit = new boolean[N][M];
	}

	static void bfs() {
		Queue<Integer> Q = new LinkedList<>();
		Q.add(0);
		Q.add(0);
		distance[0][0] = 1;
		visit[0][0] = true;
		while (!Q.isEmpty()) {
			int x = Q.poll(), y = Q.poll();
			for (int k = 0; k < 4; k++) {
				int nx = x + dir[k][0], ny = y + dir[k][1];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (visit[nx][ny])
					continue;
				if (A[nx].charAt(ny) == '0')
					continue;
				visit[nx][ny] = true;
				distance[nx][ny] = distance[x][y] + 1;
				Q.add(nx);
				Q.add(ny);
			}
		}
	}

	public static void main(String[] args) {
		input();
		bfs();
		System.out.println(distance[N - 1][M - 1]);
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
