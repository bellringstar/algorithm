package programmers;

public class P43165 {

	/*
	+,-를 선택하는 문제
	[4,1,2,1] -> 총 3번의 +,- 선택
	 */

	class Solution {

		int cnt = 0;

		public int solution(int[] numbers, int target) {
			recFunc(0, 0, numbers, target);
			return cnt;
		}

		public void recFunc(int depth, int sum, int[] numbers, int target) {
			if (depth == numbers.length) {
				if (sum == target) {
					cnt++;
					return;
				}
			} else {
				recFunc(depth + 1, sum + numbers[depth], numbers, target);
				recFunc(depth + 1, sum - numbers[depth], numbers, target);
			}
		}
	}

}
