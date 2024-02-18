package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LC743 {

	/*
	n개의 노드, 1~n times[i] = ui, vi, wi u에서 v로가는데 w의 시간이 걸린다. 시작점 k
	모든 n개의 노드가 신호를 받는 최소 시간은? 불가능하다면 -1
	 */
	class Solution {

		class Vertex {

			public int to;
			public int distance;

			public Vertex(int to, int distance) {
				this.to = to;
				this.distance = distance;
			}

		}

		public int networkDelayTime(int[][] times, int n, int k) {

			Map<Integer, List<Vertex>> graph = buildGraph(times, n);
			int[] distance = new int[n + 1];
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[k] = 0;

			findPath(graph, distance, k);

			int maxTime = Integer.MIN_VALUE;

			for (int i = 1; i <= n; i++) {
				if (distance[i] == Integer.MAX_VALUE) {
					return -1;
				}

				if (distance[i] > maxTime) {
					maxTime = distance[i];
				}
			}

			return maxTime;

		}

		private Map<Integer, List<Vertex>> buildGraph(int[][] times, int n) {
			Map<Integer, List<Vertex>> graph = new HashMap<>();
			for (int i = 1; i <= n; i++) {
				graph.put(i, new ArrayList<>());
			}

			for (int[] time : times) {
				graph.get(time[0]).add(new Vertex(time[1], time[2]));
			}

			return graph;
		}

		private void findPath(Map<Integer, List<Vertex>> graph, int[] distance, int k) {
			PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
			pq.offer(new Vertex(k, 0));

			while (!pq.isEmpty()) {
				Vertex current = pq.poll();
				int to = current.to;
				int dist = current.distance;

				if (dist > distance[to])
					continue;

				for (Vertex neighbor : graph.get(to)) {
					if (distance[to] + neighbor.distance < distance[neighbor.to]) {
						distance[neighbor.to] = distance[to] + neighbor.distance;
						pq.offer(new Vertex(neighbor.to, distance[neighbor.to]));
					}
				}
			}
		}
	}

}
