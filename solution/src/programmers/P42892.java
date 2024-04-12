package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P42892 {

	/*
	y축 = 노드의 레벨 y축 내림차순 정렬
	 */

	class Solution {

		private static class Node {
			private final int value;
			private final int x;
			private final int y;

			private Node left;
			private Node right;

			public Node(int value, int x, int y) {
				this.value = value;
				this.x = x;
				this.y = y;
			}
		}

		public int[][] solution(int[][] nodeInfo) {
			Node[] nodes = new Node[nodeInfo.length];
			for (int i = 0; i < nodeInfo.length; i++) {
				nodes[i] = new Node(i + 1, nodeInfo[i][0], nodeInfo[i][1]);
			}

			Arrays.sort(nodes, (a, b) -> b.y - a.y);

			Node root = constructTree(nodes);

			List<Integer> pre = new ArrayList<>();
			preOrder(root, pre);

			List<Integer> post = new ArrayList<>();
			postOrder(root, post);

			return new int[][] {
				pre.stream().mapToInt(Integer::intValue).toArray(),
				post.stream().mapToInt(Integer::intValue).toArray()
			};
		}

		private Node constructTree(Node[] nodes) {
			Node root = nodes[0];

			for (int i = 1; i < nodes.length; i++) {
				insert(root, nodes[i]);
			}

			return root;
		}

		private void insert(Node root, Node node) {
			if (root.x > node.x) {
				if (node.left == null) {
					root.left = node;
				} else {
					insert(node.left, node);
				}
			} else {
				if (node.right == null) {
					root.right = node;
				} else {
					insert(root.right, node);
				}
			}
		}

		private void preOrder(Node node, List<Integer> visits) {
			if (node == null)
				return;

			visits.add(node.value);
			preOrder(node.left, visits);
			preOrder(node.right, visits);
		}

		private void postOrder(Node node, List<Integer> visits) {
			if (node == null)
				return;

			postOrder(node.left, visits);
			postOrder(node.right, visits);
			visits.add(node.value);
		}
	}

	class Solution2 {
		private static class Node {
			int x, y, num;
			Node left, right;

			public Node(int num, int x, int y) {
				this.num = num;
				this.x = x;
				this.y = y;
			}
		}

		private static Node makeBT(int[][] nodeInfo) {
			Node[] nodes = new Node[nodeInfo.length];
			for (int i = 0; i < nodeInfo.length; i++) {
				nodes[i] = new Node(i + 1, nodeInfo[i][0], nodeInfo[i][1]);
			}

			Arrays.sort(nodes, (o1, o2) -> {
				if (o1.y == o2.y) {
					return Integer.compare(o1.x, o2.x);
				}
				return Integer.compare(o2.y, o1.y);
			});

			Node root = nodes[0];

			for (int i = 1; i < nodes.length; i++) {
				Node parent = root;
				while (true) {
					if (nodes[i].x < parent.x) {
						if (parent.left == null) {
							parent.left = nodes[i];
							break;
						} else {
							parent = parent.left;
						}
					} else {
						if (parent.right == null) {
							parent.right = nodes[i];
							break;
						} else {
							parent = parent.right;
						}
					}
				}
			}
			return nodes[0];
		}

		private static void preOrder(Node curr, List<Integer> answer) {
			if (curr == null)
				return;

			answer.add(curr.num);
			preOrder(curr.left, answer);
			preOrder(curr.right, answer);
		}

		private static void postOrder(Node curr, List<Integer> answer) {
			if (curr == null)
				return;

			postOrder(curr.left, answer);
			postOrder(curr.right, answer);
			answer.add(curr.num);

		}

		public int[][] solution(int[][] nodeInfo) {
			Node root = makeBT(nodeInfo);
			List<Integer> preOrderList = new ArrayList<>();
			List<Integer> postOrderList = new ArrayList<>();
			preOrder(root, preOrderList);
			postOrder(root, postOrderList);

			int[][] answer = new int[2][nodeInfo.length];
			answer[0] = preOrderList.stream().mapToInt(Integer::intValue).toArray();
			answer[1] = postOrderList.stream().mapToInt(Integer::intValue).toArray();

			return answer;
		}
	}
}
