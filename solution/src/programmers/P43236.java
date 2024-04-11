import java.util.Arrays;

public class P43236 {
	/*
	모든 지점 사이의 거리가 d 이상이 될 수 있는가? -> d 이상이 되도록 바위를 없앨 수 있나?
	즉 바위 n개를 이용하여 특정 거리 d에 대해 모든 지점 사이의 거리가 d 이상이 되는 d 중 가장 큰 값은?
	기능 1. 특정 거리 d에 대해 n개의 바위를 없앴을 때 최소 거리가 d 이상이 될 수 있는가
	rocks를 순회하면서 이전 바위와 거리가 d 보다 작다 -> 바위 삭제
	모두 반복했을 때 삭제한 바위가 n보다 같거나 작으면 만족.
	 */
	class Solution {
		public int solution(int distance, int[] rocks, int n) {

			rocks = Arrays.copyOf(rocks, rocks.length + 1);
			rocks[rocks.length - 1] = distance;
			Arrays.sort(rocks);

			int start = 1;
			int end = distance + 1;


			while (end - start > 1) {
				int d = (start + end) / 2;
				if (isValid(d, rocks, n)) {
					start = d;
				} else {
					end = d;
				}
			}
			return start;
		}

		private boolean isValid(int d, int[] rocks, int n) {
			int removed = 0;
			int last = 0;
			for (int rock : rocks) {
				if (rock - last < d) {
					removed++;
					continue;
				}
				last = rock;
			}
			return removed <= n;
		}
	}
}
