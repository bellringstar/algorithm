import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class P76502 {
	/*
	1. 문자열을 왼쪽으로 한칸 민다. -> deque를 써서 앞에서 하나 빼서 뒤에 넣으면 회전 1
	2. 올바른 조합인가?

	 */
	class Solution {
		public int solution(String s) {

			int cnt = 0;

			if (s.length() == 0) return 0;

			for (int i = 0; i < s.length(); i++) {
				s = rotate(s);
				if (isCorrect(s))
					cnt++;
			}

			return cnt;
		}

		private String rotate(String s) {
			Deque<String> deque = new ArrayDeque<>();
			for (String p : s.split("")) {
				deque.addLast(p);
			}

			deque.addLast(deque.pollFirst());

			return deque.stream().collect(Collectors.joining());
		}

		private boolean isCorrect(String s) {
			Deque<String> stack = new ArrayDeque<>();
			Map<String, String> pairMap = new HashMap<>();
			pairMap.put(")", "(");
			pairMap.put("}", "{");
			pairMap.put("]", "[");

			for (String p : s.split("")) {
				switch (p) {
					case "(", "{", "[" -> stack.addLast(p);
					case ")", "}", "]" -> {
						if (stack.isEmpty() || !pairMap.get(p).equals(stack.pollLast()))
							return false;
					}
				}
			}
			return stack.isEmpty();
		}
	}

	class Solution2 {

		private boolean isCorrect(char[] str, int offset) {
			Deque<Character> stack = new ArrayDeque<>();

			for (int i = 0; i < str.length; i++) {
				char c = str[(offset + i) % str.length];
				switch (c) {
					case '(' -> stack.push(')');
					case '{' -> stack.push('}');
					case '[' -> stack.push(']');
					case ')', '}', ']' -> {
						if (stack.isEmpty()) return false;
						if (stack.pollLast() != c) return false;
					}
				}
			}

			return stack.isEmpty();
		}

		public int solution(String s) {
			char[] str = s.toCharArray();
			int count = 0;
			for (int offset = 0; offset < str.length; offset++) {
				if (isCorrect(str, offset)) {
					count++;
				}
			}
			return count;
		}
	}
}
