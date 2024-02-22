package programmers;

import java.util.ArrayList;
import java.util.List;

public class P12946 {
	/*
	1. 상태
	원판의 개수 n, 원핀이 현재 위치한 기둥 from, 원판이 이동해야 하는 기둥 to
	(n, from, to)
	2. 종료조건
	(1, from, to)
	3. 점화식
	n-1개를 이동시킬 수 있다면 n개도 이동가능하다
	(n, from, to) = (n-1, from, empty) + (1,from, to) + (n-1, empty, to)
	empty = 6 - from - to (1,2,3 번기둥만 있기 때문)
	 */

	class Solution {
		public int[][] solution(int n) {
			return hanoi(n, 1, 3).toArray(new int[0][]);
		}

		private List<int[]> hanoi(int n, int from, int to) {
			if (n == 1)
				return List.of(new int[] {from, to});

			int empty = 6 - from - to;

			List<int[]> result = new ArrayList<>();
			result.addAll((hanoi(n - 1, from, empty)));
			result.addAll((hanoi(1, from, to)));
			result.addAll((hanoi(n - 1, empty, to)));

			return result;
		}

		private void hanoi2(int n, int from, int to, List<int[]> process) {
			if (n == 1) {
				process.add(new int[] {from, to});
				return;
			}
			int empty = 6 - from - to;
			hanoi2(n - 1, from, empty, process);
			hanoi2(1, from, to, process);
			hanoi2(n - 1, empty, to, process);
		}
	}
}
