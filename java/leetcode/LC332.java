package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LC332 {
	/*
	ticket = [from, to] JFK에서 출발, 여러 경우가 있을 경우 사전순
	출발 : 도착리스트 map으로 저장. value를 사전순으로 정렬해놓는다.
	dfs 로 모든곳 방문
	 */

	class Solution {
		public List<String> findItinerary(List<List<String>> tickets) {

			List<String> answer = new ArrayList<>();
			Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();

			for (List<String> ticket : tickets) {
				fromToMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
				fromToMap.get(ticket.get(0)).add(ticket.get(1));
			}

			dfs(answer, fromToMap, "JFK");
			return answer;
		}

		public void dfs(List<String> answer, Map<String, PriorityQueue<String>> fromToMap, String current) {
			while (fromToMap.containsKey(current) && !fromToMap.get(current).isEmpty()) {
				dfs(answer, fromToMap, fromToMap.get(current).poll());
			}

			answer.add(0, current);
		}
	}

	class Solution2 {
		public List<String> findItinerary(List<List<String>> tickets) {
			List<String> answer = new ArrayList<>();
			Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();

			for (List<String> ticket : tickets) {
				fromToMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
				fromToMap.get(ticket.get(0)).add(ticket.get(1));
			}

			Deque<String> stack = new ArrayDeque<>();
			stack.push("JFK");
			while (!stack.isEmpty()) {
				while (fromToMap.containsKey(stack.getFirst()) && !fromToMap.get(stack.getFirst()).isEmpty()) {
					stack.push(fromToMap.get(stack.getFirst()).poll());
				}

				answer.add(0, stack.pop());
			}
			return answer;
		}

	}

	public static void main(String[] args) {
		class Solution {
			public List<String> findItinerary(List<List<String>> tickets) {

				List<String> answer = new ArrayList<>();
				Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();

				for (List<String> ticket : tickets) {
					fromToMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
					fromToMap.get(ticket.get(0)).add(ticket.get(1));
				}

				dfs(answer, fromToMap, "JFK");
				return answer;
			}

			public void dfs(List<String> answer, Map<String, PriorityQueue<String>> fromToMap, String current) {
				while (fromToMap.containsKey(current) && !fromToMap.get(current).isEmpty()) {
					dfs(answer, fromToMap, fromToMap.get(current).poll());
				}

				answer.add(0, current);
			}

		}

		Solution solution = new Solution();
		solution.findItinerary(
			List.of(List.of("JFK", "KUL"), List.of("JFK", "NRT"), List.of("NRT", "JFK")));
	}
}
