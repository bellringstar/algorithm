import java.util.*;
import java.io.*;

public class BOJ9663 {

	static int N, ans;
	static int[] col;

	static void input() {
		FastReader scan = new FastReader();
		N = scan.nextInt();
		col = new int[N+1];
	}

	static boolean attackable(int r1, int c1, int r2, int c2) {
		if (c1 == c2) return true;
		if (r1+c1 == r2+c2) return true;
		if (r1-c1 == r2-c2) return true;
		return false;
	}

	static void rec_func(int row) {
		if (row == N+1){
			//1부터 N까지 총 N줄에 걸쳐 선택 완료
			ans++;
		} else {
			for (int cand = 1; cand <= N; cand++) {
				boolean flag = true;
				for (int i = 1; i<row; i++) {
					if (attackable(i, col[i], row, cand)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					col[row] = cand;
					rec_func(row+1);
					col[row] = 0;
				}
			}
		}

	}

	public static void main(String[] args) {
		input();
		rec_func(1);
		System.out.println(ans);
	}



	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastReader(String s) throws FileNotFoundException{
			br = new BufferedReader(new FileReader(new File(s)));
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
