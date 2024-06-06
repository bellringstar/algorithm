package programmers;

import java.util.Arrays;

public class P43105 {

	/*
	정해진 방향으로 이동해가며 누적합을 기록
	상태 : 누적합 s, 행 y
	종료조건 : 행 y가 마지막 행에 닿아 모든 합을 계산
	점화식 : (s, y) = (s + 다음 행 위치의 값, y + 1)
	 */


	class Solution {

		private final int[][] mem = new int[501][501];

		public int solution(int[][] triangle) {

			for (int[] row : mem) {
				Arrays.fill(row, -1);
			}

			return max(0, 0, triangle);
		}

		private int max(int x, int y, int[][] triangle) {
			if (y == triangle.length) {
				return 0;
			}
			if (mem[x][y] != -1) return mem[x][y];

			return mem[x][y] = triangle[y][x] + Math.max(max(x, y + 1, triangle), max(x+1, y+1, triangle));
		}
	}
}
