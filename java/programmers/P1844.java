package programmers;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P1844 {
	/*
	(0,0) 시작 도착점까지 가장 빠르게 도달
	벽 0 자리 1 , 도착점 n,m
	 */

	class Solution {
		public int solution(int[][] maps) {

			Queue<List<Integer>> queue = new LinkedList<>();
			int n = maps[0].length;
			int m = maps.length;

			queue.offer(List.of(0, 0));
			int[] dr = {-1, 1, 0, 0};
			int[] dc = {0, 0, -1, 1};

			while (!queue.isEmpty()) {
				List<Integer> current = queue.poll();
				int r = current.get(0);
				int c = current.get(1);

				for (int i = 0; i < 4; i++) {
					int newR = r + dr[i];
					int newC = c + dc[i];

					if (newR < 0 || newR >= m || newC < 0 || newC >= n)
						continue;
					if (maps[newR][newC] == 0)
						continue;

					maps[newR][newC] = maps[r][c] + 1;
					queue.offer(List.of(newR, newC));
				}
			}

			return maps[m - 1][n - 1] == 1 ? -1 : maps[m - 1][n - 1];
		}
	}

	public static void main(String[] args) {
		class Solution {
			public int solution(int[][] maps) {

				Queue<List<Integer>> queue = new LinkedList<>();
				int n = maps[0].length;
				int m = maps.length;

				queue.offer(List.of(0, 0));
				int[] dr = {-1, 1, 0, 0};
				int[] dc = {0, 0, -1, 1};

				while (!queue.isEmpty()) {
					List<Integer> current = queue.poll();
					int r = current.get(0);
					int c = current.get(1);

					for (int i = 0; i < 4; i++) {
						int newR = r + dr[i];
						int newC = c + dc[i];

						if (newR == 0 && newC == 0)
							continue;

						if (newR < 0 || newR >= m || newC < 0 || newC >= n)
							continue;
						if (maps[newR][newC] == 1) {
							maps[newR][newC] = maps[r][c] + 1;
							queue.offer(List.of(newR, newC));
						}
					}
				}

				return maps[m - 1][n - 1] == 1 ? -1 : maps[m - 1][n - 1];
			}
		}

		Solution solution = new Solution();
		solution.solution(
			new int[][] {{1}, {1}});
	}
}
