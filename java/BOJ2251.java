import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class State {
	int[] X;
	State (int[] _X) {
		X = new int[3];
		for (int i = 0; i < 3; i++) X[i] = _X[i];
	}

	State move(int from, int to, int[] Limit) {
		int[] nX = new int[]{X[0], X[1], X[2]};
		if (nX[from] + nX[to] <= Limit[to]) {
			nX[to] = nX[to] + nX[from];
			nX[from] = 0;
		} else {
			nX[from] -= Limit[to] - nX[to];
			nX[to] = Limit[to];
		}
		return new State(nX);
	}
}

public class BOJ2251 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int[] Limit;
	static boolean[] possible;
	static boolean[][][] visit;

	static void input() {
		Limit = new int[3];
		for (int i =0; i < 3; i++) {
			Limit[i] = scan.nextInt();
		}
		possible = new boolean[205];
		visit = new boolean[205][205][205];
	}

	static void bfs(int x1, int x2, int x3) {
		Queue<State> Q = new LinkedList<>();
		Q.add(new State(new int[]{x1, x2, x3}));
		visit[x1][x2][x3] = true;
		while (!Q.isEmpty()) {
			State st = Q.poll();
			if (st.X[0] == 0) possible[st.X[2]] = true;
			for (int from = 0; from < 3; from++) {
				for (int to = 0; to < 3; to++) {
					if (from == to) continue;
					State nxt = st.move(from, to, Limit);
					if (!visit[nxt.X[0]][nxt.X[1]][nxt.X[2]]) {
						visit[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
						Q.add(nxt);
					}
				}
			}
		}
	}

	static void pro() {
		bfs(0, 0, Limit[2]);
		for (int i = 0; i < 205; i++) {
			if (possible[i]) sb.append(i).append(' ');
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
