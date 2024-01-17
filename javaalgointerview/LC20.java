import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LC20 {
	class Solution {
		/*
		여는 거 = 스택에 삽입
		닫는 거 = 스탭에서 pop 해서 해당 짝인지 확인.
		 */
		public boolean isValid(String s) {
			Deque<Character> stack = new ArrayDeque<>();
			Map<Character, Character> pairMap = new HashMap<>();
			pairMap.put('(', ')');
			pairMap.put('{', '}');
			pairMap.put('[', ']');
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
					stack.push(s.charAt(i));
				} else {
					if (stack.isEmpty())
						return false;

					char pair = stack.pop();
					if (s.charAt(i) != pairMap.get(pair)) {
						return false;
					}
				}
			}
			if (!stack.isEmpty())
				return false;
			return true;
		}

		public boolean solution(String s) {
			Deque<Character> stack = new ArrayDeque<>();
			Map<Character, Character> table = new HashMap<>() {
				{
					put(')', '(');
					put('}', '{');
					put(']', '[');
				}
			};

			for (int i = 0; i < s.length(); i++) {
				if (!table.containsKey(s.charAt(i))) {
					stack.push(s.charAt(i));
				} else if (stack.isEmpty() || table.get(s.charAt(i)) != stack.pop()) {
					return false;
				}
			}
			return stack.size() == 0;
		}
	}
}
