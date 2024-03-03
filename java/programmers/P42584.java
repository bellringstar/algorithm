import java.util.ArrayDeque;
import java.util.Deque;

public class P42584 {
	static class Solution {
		public int[] solution(int[] prices) {
			Deque<Integer> stack = new ArrayDeque<>();
			int[] answer = new int[prices.length];

			for (int i = 0; i < prices.length; i++) {

				while (!stack.isEmpty() && prices[i] < prices[stack.peekLast()]) {
					int idx = stack.pollLast();
					answer[idx] = i - idx;
				}

				stack.addLast(i);
			}

			while (!stack.isEmpty()) {
				int pos = stack.pollLast();
				int count = prices.length - 1 - pos;
				answer[pos] = count;
			}

			return answer;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(new int[] {3, 2, 2, 2, 1});
	}

}
