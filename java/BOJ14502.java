import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, M, B, ans;
	static int[][] A,blank;
	static boolean[][] visit;
	static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		A = new int[N+1][M+1];
		blank = new int[N*M+1][2];
		visit = new boolean[N+1][M+1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <=M; j++) {
				A[i][j] = scan.nextInt();
			}
		}
	}

	static void bfs() {
		Queue<Integer> Q = new LinkedList<>();

		for (int i = 1; i <=N; i++) {
			for (int j = 1; j <= M; j++) {
				visit[i][j] = false;
				if (A[i][j] == 2) {
					Q.add(i);
					Q.add(j);
					visit[i][j] = true;
				}
			}
		}

		while (!Q.isEmpty()) {
			int x = Q.poll(), y = Q.poll();
			for (int k = 0; k < 4; k++) {
				int nx = x + dir[k][0], ny = y + dir[k][1];
				if (nx < 1 || ny <1 || nx > N || ny >M) continue;
				if (A[nx][ny] != 0) continue;
				if (visit[nx][ny]) continue;
				visit[nx][ny] = true;
				Q.add(nx);
				Q.add(ny);
			}
		}

		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (A[i][j] == 0 && !visit[i][j]) cnt ++;
			}
		}
		ans = Math.max(ans, cnt);
	}

	static void dfs(int idx, int selectedCnt) {
		if (selectedCnt == 3) {
			bfs();
			return;
		}

		if (idx > B) return;

		A[blank[idx][0]][blank[idx][1]] = 1;
		dfs(idx+1, selectedCnt + 1);
		A[blank[idx][0]][blank[idx][1]] = 0;
		dfs(idx+1, selectedCnt);
	}

	static void pro() {
		for (int i = 1; i <=N; i++) {
			for (int j = 1; j <= M; j++) {
				if (A[i][j] == 0) {
					B++;
					blank[B][0] = i;
					blank[B][1] = j;
				}
			}
		}
		dfs(1, 0);
		System.out.println(ans);
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

		double nextDouble() {
			return Double.parseDouble(next());
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
