package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P138476 {
	/*
k개를 고르는데 종류가 최소 => 같은 종류를 최대한 많이 넣으면 된다.
종류 : 개수 -> 개수가 많은 순으로 정렬
거기서 k개를 채운다.
*/
	class Solution {
		public int solution(int k, int[] tangerine) {
			Map<Integer, Integer> counter = new HashMap<>();
			for (int t : tangerine) {
				counter.put(t, counter.getOrDefault(t, 0) + 1);
			}

			List<Map.Entry<Integer, Integer>> sorted = new ArrayList<>(counter.entrySet());

			sorted.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

			int answer = 0;
			for (Map.Entry<Integer,Integer> entry : sorted) {
				int count = entry.getValue();
				if (k <= 0) break;
				answer++;
				k -= count;
			}

			return answer;
		}
	}
}
