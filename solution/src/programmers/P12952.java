package programmers;

public class P12952 {
	/*
각 행마다 퀸을 놓을 수 있는지 판단
1. 같은 행
2. 같은 열
3. 대각
*/

	class Solution {

		static int[] cols;
		static int result = 0;

		private boolean isPossible(int row, int col, int[] cols) {
			for (int i = 0; i < row; i++) {
				if (col == cols[i]) return false;

				if (row + col == i + cols[i]) return false;

				if (row - col == i - cols[i]) return false;
			}

			return true;
		}

		private void dfs(int k, int n) {
			if (k == n) {
				result += 1;
				return;
			}

			for (int i = 0; i < n; i++) {
				// k번쨰 행의 col 결정
				if (isPossible(k, i, cols)) {
					cols[k] = i;
					dfs(k+1, n);
					cols[k] = 0;
				}
			}
		}

		public int solution(int n) {
			cols = new int[n];
			dfs(0, n);
			return result;
		}
	}
}
