package programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
양의수와 늑대의 수를 비교해가며 백트랙킹
갈 수 없는 곳이라도 나중에는 가능해질 수도있다.
-> 당장 못가는 곳도 다음 목적지 후보로 담아둔다.
*/
public class P92343 {
	class Solution {

		static int MAX = Integer.MIN_VALUE;

		static void dfs(Node curr, List<Node> next, int sheep, int wolf) {
			if (sheep <= wolf) return;
			MAX = Math.max(MAX, sheep);

			List<Node> newNext = new ArrayList<>(next);
			newNext.remove(curr);
			newNext.addAll(curr.children);
			for (Node v : newNext) {
				if (v.id == 0) {
					dfs(v, newNext, sheep + 1, wolf);
				} else {
					dfs(v, newNext, sheep, wolf + 1);
				}
			}

		}

		static class Node {
			int id; //0은 양 1은 늑대
			Node parent;
			List<Node> children = new ArrayList<>();
		}
		public int solution(int[] info, int[][] edges) {
			Node[] nodes = new Node[info.length];
			for (int i = 0; i < info.length; i++) {
				Node node = new Node();
				node.id = info[i];
				nodes[i] = node;
			}

			for (int[] edge : edges) {
				Node parent = nodes[edge[0]];
				Node child = nodes[edge[1]];
				parent.children.add(child);
				child.parent = parent;
			}

			Node root = nodes[0];
			List<Node> next = new ArrayList<>();
			next.add(root);
			dfs(root, next, 1, 0);

			return MAX;
		}
	}

	class Solution2 {
		private static class Info {
			int node, sheep, wolf;
			Set<Integer> visited;

			public Info(int node, int sheep, int wolf, Set<Integer> visited) {
				this.node = node;
				this.sheep = sheep;
				this.wolf = wolf;
				this.visited = visited;
			}
		}
		private static List<Integer>[] tree;

		private static void buildTree(int[] info, int[][] edges) {
			tree = new ArrayList[info.length];
			for (int i = 0; i < tree.length; i++) {
				tree[i] = new ArrayList<>();
			}
			for (int[] edge : edges) {
				tree[edge[0]].add(edge[1]);
			}
		}

		public int solution(int[] info, int[][] edges) {
			buildTree(info, edges);
			int answer = 0;

			Queue<Info> q = new ArrayDeque<>();
			q.add(new Info(0, 1, 0, new HashSet<>()));

			while (!q.isEmpty()) {
				Info now = q.poll();
				answer = Math.max(answer, now.sheep);
				now.visited.addAll(tree[now.node]);

				for (int next : now.visited) {
					Set<Integer> set = new HashSet<>(now.visited);
					set.remove(next);

					if (info[next] == 1) {
						if (now.sheep != now.wolf + 1) {
							q.add(new Info(next, now.sheep, now.wolf + 1, set));
						}
					} else {
						q.add(new Info(next, now.sheep + 1, now.wolf, set));
					}
				}
			}
			return answer;
		}
	}
}
