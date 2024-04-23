package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P49189 {
	/*
	cost를 1, 1번 시작점 dijkstra
	도달 한 노드 중 가장 거리가 먼 노드
	*/
	class Solution {

		static class Node {
			int dest;
			int cost;

			public Node(int dest, int cost) {
				this.dest = dest;
				this.cost = cost;
			}
		}

		public int solution(int n, int[][] edges) {

			List<Node>[] nodes = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				nodes[i] = new ArrayList<>();
			}

			for (int[] edge : edges) {
				nodes[edge[0]].add(new Node(edge[1], 1));
				nodes[edge[1]].add(new Node(edge[0], 1));
			}

			int[] distance = new int[n + 1];
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[1] = 0;

			PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
			pq.add(new Node(1, 0));

			while (!pq.isEmpty()) {
				Node curr = pq.poll();

				if (distance[curr.dest] < curr.cost)
					continue;

				for (Node next : nodes[curr.dest]) {
					if (distance[next.dest] > curr.cost + next.cost) {
						distance[next.dest] = curr.cost + next.cost;
						pq.add(new Node(next.dest, distance[next.dest]));
					}
				}
			}

			final int max = Arrays.stream(distance)
				.filter(v -> v != Integer.MAX_VALUE)
				.max().getAsInt();

			return (int)Arrays.stream(distance)
				.filter(v -> v == max)
				.count();
		}
	}
}
