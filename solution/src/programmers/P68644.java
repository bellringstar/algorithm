package programmers;

import java.util.HashSet;
import java.util.Set;

public class P68644 {

	class Solution {
		public int[] solution(int[] numbers) {
			Set<Integer> results = new HashSet<>();
			for (int i = 0; i < numbers.length; i++) {
				for (int j = i + 1; j < numbers.length; j++) {
					int sum = numbers[i] + numbers[j];
					results.add(sum);
				}
			}

			return results.stream().mapToInt(Integer::intValue).sorted().toArray();
		}
	}
}
