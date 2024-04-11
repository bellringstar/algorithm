package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class LC347 {

	/*
	k번째로 가장 많이 나오는 리스트

	 */

	class Solution {
		public int[] topKFrequent(int[] nums, int k) {
			Map<Integer, Integer> numberCount = new HashMap<>();
			for (int num : nums) {
				numberCount.put(num, numberCount.getOrDefault(num, 0) + 1);
			}

			Map<Integer, Integer> sortedMap = numberCount.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(
					Map.Entry::getKey,
					Map.Entry::getValue,
					(e1, e2) -> e1,
					LinkedHashMap::new
				));

			return sortedMap.entrySet().stream().limit(k).mapToInt(Map.Entry::getKey).toArray();
		}
	}

	class Solution2 {
		public int[] topKFrequent(int[] nums, int k) {

			Map<Integer, Integer> frequencyMap = new HashMap<>();
			for (int num : nums) {
				frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
			}

			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
			for (int elem : frequencyMap.keySet()) {
				pq.add(new int[] {elem, frequencyMap.get(elem)});
			}

			int[] result = new int[k];
			for (int i = 0; i < k; i++) {
				result[i] = pq.poll()[0];
			}
			return result;
		}
	}

}
