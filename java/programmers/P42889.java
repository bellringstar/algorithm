package programmers;

import java.util.HashMap;
import java.util.Map;

/*
* 해당 스테이지 도달했으나 클리어 못한 사람 = 해당 스테이지에 머물러 있는 사람
* 스테이지 도달한 사람 = 전체에서 해당 스테이지 이하의 수를 뺀 것
* */
public class P42889 {

	class Solution {
		public int[] solution(int N, int[] stages) {

			int[] current = new int[N+2]; // 최대 N+1 스테이지까지 입력

			for (int stage : stages) {
				current[stage] += 1; // 해당 스테이지에 있는 사람 누적
			}

			Map<Integer, Double> failure = new HashMap<>();
			double total = stages.length;
			for (int stage = 1; stage <= N; stage++) {
				if (current[stage] == 0) {
					failure.put(stage, 0.0);
				} else {
					failure.put(stage, current[stage]/total);
					total -= current[stage];
				}
			}

			return failure.entrySet().stream()
				.sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
				.mapToInt(Map.Entry::getKey).toArray();

		}
	}
}
