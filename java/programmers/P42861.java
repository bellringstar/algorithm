import java.util.Arrays;
import java.util.Comparator;

public class P42861 {
	/*
	최소신장트리 : 간선을 가중치 순으로 정렬 후 순서대로 순회하며 연결되지 않은 두 정점을 잇는 간선을 채택 = 크루스칼 알고리즘
	 */

	class Solution {

		private static class Node {
			private Node parent = null;

			public boolean isConnected(Node o) {
				return root() == o.root();
			}

			public void merge(Node o) {
				if (isConnected(o)) return;

				o.parent = this;
			}

			private Node root() {
				if (parent == null) return this;
				return parent = parent.root();
			}
		}

		private static class Edge {
			public final int u;
			public final int v;
			public final int cost;

			public Edge(int u, int v, int cost) {
				this.u = u;
				this.v = v;
				this.cost = cost;
			}
		}

		public int solution(int n, int[][] costs) {
			Edge[] edges = Arrays.stream(costs)
				.map(edge -> new Edge(edge[0], edge[1], edge[2]))
				.sorted(Comparator.comparingInt(e -> e.cost))
				.toArray(Edge[]::new);

			Node[] nodes = new Node[n];
			for (int i = 0; i < n; i++) {
				nodes[i] = new Node();
			}

			int totalCost = 0;
			for (Edge edge : edges) {
				Node node1 = nodes[edge.u];
				Node node2 = nodes[edge.v];

				if (node1.isConnected(node2)) continue;
				node1.merge(node2);
				totalCost += edge.cost;
			}

			return totalCost;
		}
	}
}
