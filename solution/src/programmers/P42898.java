package programmers;

import java.util.Arrays;

public class P42898 {

	/*
	1. 상태 (x,y) : (x,y)까지의 최단거리
	2. 종료조건 : (x,y) = (m,n) = 1 도착
	(x,y) 가 웅덩이 = 0
	(x,y)가 범위를 벗어났다 = 0
	3. 점화식 (x,y) = (x+1,y) + (x, y+1);
	(m,n) = n행 m열 => y = n x=m (x,y)
	 */

	static class Solution {

		private int[][] mem = new int[101][101];

		public int solution(int m, int n, int[][] puddles) {

			for (int[] row : mem) {
				Arrays.fill(row, -1);
			}

			boolean[][] isPuddle = new boolean[101][101];
			for (int[] p : puddles) {
				isPuddle[p[1]][p[0]] = true;
			}

			return count(1, 1, m, n, isPuddle);
		}

		private int count(int x, int y, int w, int h, boolean[][] isPuddle) {
			if (x > w || y > h) return 0;
			if (isPuddle[y][x]) return 0;

			if (mem[y][x] != -1) return mem[y][x];
			if (x == w && y == h) return 1;

			int total = count(x + 1, y, w, h, isPuddle) + count(x, y + 1, w, h, isPuddle);

			System.out.println(total%1000000007);
			return mem[y][x] = total%1000000007;
		}

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(4, 3, new int[][]{{2,2}});
	}
}
