package programmers;

import java.util.Arrays;

public class P12913 {

	class Solution {
		int solution(int[][] land) {
			int N = land.length;
			int[][] mem = new int[N][4];
			for (int i = 0; i < 4; i++) {
				mem[0][i] = land[0][i];
			}

			for (int row = 1; row < N; row++) {
				// row-1번쨰 줄에서 자신의 열과 다른 것들 중 최대
				for (int i = 0; i < 4; i++) {
					int max = 0;
					for (int j =0; j < 4; j++) {
						if (j != i) max = Math.max(max, mem[row-1][j]);
					}
					mem[row][i] = land[row][i] + max;
				}
			}

			return Arrays.stream(mem[N-1]).max().getAsInt();
		}
	}
}
