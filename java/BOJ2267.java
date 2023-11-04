import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2267 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();
	static int N, group_cnt;
	static String[] A;
	static boolean[][] visit;
	static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static ArrayList<Integer> group;

	static void input() {
		N = scan.nextInt();
		A = new String[N];
		for (int i = 0; i<N; i++) {
			A[i] = scan.nextLine();
		}
		visit = new boolean[N][N];
	}

	// x, y를 갈 수 있다는 걸 알고 방문
	static void dfs(int x, int y) {
		group_cnt++;
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if (nx <0 || nx >= N || ny <0 || ny >= N) continue;
			if (A[nx].charAt(ny) == '0') continue;
			if (visit[nx][ny]) continue;
			dfs(nx, ny);
		}
	}

	static void pro() {
		group = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && A[i].charAt(j) == '1') {
					group_cnt = 0;
					dfs(i, j);
					group.add(group_cnt);
				}
			}
		}
		Collections.sort(group);

		sb.append(group.size()).append('\n');
		for (int count : group) {
			sb.append(count).append('\n');
		}
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
