package leetcode;

public class LC200 {
	/*
	m x n 2차원 그리드, '1' = 땅, '0' = 물=> 섬의 개수를 리턴
	 */

	class Solution {

		int count = 0;
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};

		public int numIslands(char[][] grid) {
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					if (grid[i][j] == '1') {
						recDFS(i, j, grid);
						count++;
					}
				}
			}
			return count;
		}

		public void recDFS(int r, int c, char[][] grid) {
			grid[r][c] = '0';

			for (int i = 0; i < 4; i++) {
				int newR = r + dr[i];
				int newC = c + dc[i];
				if (newR < 0 || newR >= grid.length || newC < 0 || newC >= grid[0].length)
					continue;
				if (grid[newR][newC] == '0')
					continue;
				recDFS(newR, newC, grid);
			}
		}
	}
}
