package programmers;

import java.util.Arrays;

public class P12982 {
/*
최대한 많은 부서 -> 요구 금액이 작은 곳부터 지원
1. 신청 금액 오름차순
2. 예산내에서 지원
*/
	class Solution {
		public int solution(int[] d, int budget) {
			int answer = 0;
			Arrays.sort(d);
			for (int x : d) {
				if (budget - x >= 0) {
					budget -= x;
					answer++;
				}
			}
			return answer;
		}
	}
}
