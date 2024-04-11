package programmers;

public class P68645 {

	/*
	1. n*n 크기의 배열 선언
	2. 숫자를 (0, 0)부터 채울 수 있을 때까지 채워나간다.
	2-1. 아래방향
	2-2. 오른쪽방향
	2-3. 왼쪽위로
	채울 수 없다면 방향을 전환한다.
	3. 완성된 이차원 배열의 row를 정답에 순서대로 넣는다.
	 */

	class Solution {

		private static final int[] dx = {0, 1, -1};
		private static final int[] dy = {1, 0, -1};

		public int[] solution(int n) {
			int[][] graph = new int[n][n];
			int x = 0;
			int y = 0;
			int d = 0;
			int v = 1;

			while (true) {
				graph[y][x] = v++;
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx == n || ny == n || nx == -1 || ny == -1 || graph[ny][nx] != 0) {
					d = (d + 1) % 3;
					nx = x + dx[d];
					ny = y + dy[d];
					if (nx == n || ny == n || nx == -1 || ny == -1 || graph[ny][nx] != 0) {
						break;
					}
				}
				x = nx;
				y = ny;
			}

			int[] result = new int[v - 1];
			int idx = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < i + 1; j++) {
					result[idx++] = graph[i][j];
				}
			}
			return result;
		}
	}
}
