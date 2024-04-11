package programmers;

import java.util.ArrayList;
import java.util.List;

/*
 * n의 범위가 크다 = 실제로 int[][] 를 만들기에는 무리가 있다
 * left, right가 long이다 = 인덱스로 사용할 수 없다.
 * */

public class P87390 {
	class Solution {
		public int[] solution(int n, long left, long right) {

			List<Integer> answer = new ArrayList<>();
			for (long i = left; i <= right; i++) {
				answer.add((int)Math.max(i / n, i % n) + 1);
			}

			return answer.stream().mapToInt(Integer::intValue).toArray();
		}
	}
}
