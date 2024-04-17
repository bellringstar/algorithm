package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P12978 {

/*
k 시간 이하로 배달 가능한 마을만.
다익스트라
*/
	class Solution {

		static class Node {
			int to;
			int cost;

			public Node(int to, int cost) {
				this.to = to;
				this.cost = cost;
			}
		}

		public int solution(int N, int[][] road, int K) {
			Map<Integer, List<Node>> edges = new HashMap<>();

			for (int i = 1; i <= N; i++) {
				edges.put(i, new ArrayList<>());
			}

			for (int[] r : road) {
				edges.get(r[0]).add(new Node(r[1], r[2]));
				edges.get(r[1]).add(new Node(r[0], r[2]));
			}

			int[] distance = new int[N+1];
			Arrays.fill(distance, Integer.MAX_VALUE);

			PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
			pq.add(new Node(1, 0));
			distance[1] = 0;
			while (!pq.isEmpty()) {
				Node now = pq.poll();

				if (distance[now.to] < now.cost) continue;

				for (Node next : edges.get(now.to)) {
					if (distance[next.to] > now.cost + next.cost) {
						distance[next.to] = now.cost + next.cost;
						pq.add(new Node(next.to, distance[next.to]));
					}
				}
			}
			int answer = 0;
			for (int i = 1; i <= N; i++) {
				if (distance[i] <= K) answer++;
			}

			return answer;
		}
	}
}
