import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P64063 {
	/*
	순서대로 순회
	방이 비어있다 -> 해당 방 배정
	방이 비어있지 않다 -> 방 번호보다 큰 방중 번호가 가장 작은 비어있는 방 배정
	 */

	static class Solution {

		private static class Node {
			private Node parent = null;
			private long max;

			public boolean isConnected(Node o) {
				return root() == o.root();
			}

			public void merge(Node o) {
				if (isConnected(o)) return;
				o.parent = this;
				root().max = o.root().max = Math.max(root().max, o.root().max);
			}

			private Node root() {
				if (parent == null) return this;
				return parent = parent.root();
			}

			public Node(long number) {
				this.max = number;
			}
		}

		public long[] solution(long k, long[] room_number) {
			List<Long> assigned = new ArrayList<>();

			Map<Long, Node> nodes = new HashMap<>();
			for (long number : room_number) {
				if (nodes.containsKey(number)) {
					number = nodes.get(number).root().max + 1;
				}

				Node node = new Node(number);
				nodes.put(number, node);

				if (nodes.containsKey(number - 1)) {
					node.merge(nodes.get(number - 1));
				}
				if (nodes.containsKey(number + 1)) {
					node.merge(nodes.get(number + 1));
				}

				assigned.add(number);
			}

			return assigned.stream().mapToLong(Long::longValue).toArray();
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(10, new long[]{1, 3, 4, 1, 3, 1});
	}
}
