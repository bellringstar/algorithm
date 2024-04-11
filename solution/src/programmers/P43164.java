package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P43164 {
	/*
	ICN에서 출발, 알파벳순서
	 */

	public static void main(String[] args) {
		class Solution {
			public String[] solution(String[][] tickets) {
				List<String> results = new ArrayList<>();
				Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();
				for (String[] ticket : tickets) {
					fromToMap.putIfAbsent(ticket[0], new PriorityQueue<>());
					fromToMap.get(ticket[0]).add(ticket[1]);
				}
				dfs(results, fromToMap, "ICN");
				
				return results.toArray(new String[0]);
			}

			public void dfs(List<String> results, Map<String, PriorityQueue<String>> fromToMap, String current) {
				while (fromToMap.containsKey(current) && !fromToMap.get(current).isEmpty()) {
					dfs(results, fromToMap, fromToMap.get(current).poll());
				}

				results.add(0, current);
			}
		}
	}
}
