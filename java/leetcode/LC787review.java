package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC787review {
	/*
	n개의 도시, flights = from, to, price
	src에서 dst까지 k번만 갈아타고 가는데 가장 저렴한 가격은? 불가능한 루트면 -1
	 */

	class Solution {

		class Vertex {
			int id;
			int cost;
			int cnt;

			public Vertex(int id, int cost, int cnt) {
				this.id = id;
				this.cost = cost;
				this.cnt = cnt;
			}
		}

		public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
			Map<Integer, List<Vertex>> graph = buildGraph(n, flights);
			int[] distance = new int[n];
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[src] = 0;

			Queue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
			pq.offer(new Vertex(src, 0, 0));
			Map<Vertex, Integer> visit = new HashMap<>();

			while (!pq.isEmpty()) {
				Vertex current = pq.poll();
				visit.put(current, current.cnt);
				int id = current.id;
				int cost = current.cost;
				int cnt = current.cnt;

				if (id == dst)
					return cost;
				if (cnt > k)
					continue;

				for (Vertex neighbor : graph.get(id)) {
					int nextNode = neighbor.id;
					int nextCost = neighbor.cost + cost;

					if (nextCost < distance[nextNode] || visit.getOrDefault(nextNode, 0) >= cnt + 1) {
						distance[nextNode] = nextCost;
						pq.offer(new Vertex(nextNode, nextCost, cnt + 1));
					}
				}
			}

			return -1;
		}

		private Map<Integer, List<Vertex>> buildGraph(int n, int[][] flights) {
			Map<Integer, List<Vertex>> graph = new HashMap<>();

			for (int i = 0; i < n; i++) {
				graph.put(i, new ArrayList<>());
			}

			for (int[] flight : flights) {
				graph.get(flight[0]).add(new Vertex(flight[1], flight[2], 0));
			}

			return graph;

		}
	}

	class Solution2 {
		static class Vertex {
			int to;
			int cost;
			int cnt;

			public Vertex(int to, int cost, int cnt) {
				this.to = to;
				this.cost = cost;
				this.cnt = cnt;
			}
		}

		int minCost;

		public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
			Map<Integer, List<Vertex>> graph = buildGraph(flights);
			minCost = Integer.MAX_VALUE;
			boolean[] visited = new boolean[n];
			dfs(graph, src, dst, k + 1, 0, visited);

			return minCost == Integer.MAX_VALUE ? -1 : minCost;
		}

		private void dfs(Map<Integer, List<Vertex>> graph, int src, int dst, int stops, int cost, boolean[] visited) {
			if (src == dst) {
				minCost = Math.min(minCost, cost);
				return;
			}

			if (stops == 0 || cost > minCost) {
				return;
			}

			visited[src] = true;
			for (Vertex neighbor : graph.getOrDefault(src, new ArrayList<>())) {
				if (!visited[neighbor.to]) {
					dfs(graph, neighbor.to, dst, stops - 1, cost + neighbor.cost, visited);
				}
			}

			visited[src] = false;
		}

		private Map<Integer, List<Vertex>> buildGraph(int[][] flights) {
			Map<Integer, List<Vertex>> graph = new HashMap<>();

			for (int[] flight : flights) {
				int from = flight[0];
				int to = flight[1];
				int cost = flight[2];

				graph.putIfAbsent(from, new ArrayList<>());
				graph.get(from).add(new Vertex(to, cost, 0));
			}

			return graph;
		}
	}
}
