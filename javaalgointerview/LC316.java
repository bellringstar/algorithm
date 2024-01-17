import java.util.ArrayDeque;
import java.util.Deque;

public class LC316 {
	/*
	문자열 s에서 중복된 문자를 제외하고 문자가 한번만 나오도록 한 다음 사전식 순서로 나열하라.
	s = "cbacdcbc" -> "acdb"
	s = "ecbacba" -> "eacb"
	 */
	class Solution {
		public String removeDuplicateLetters(String s) {
			Deque<Character> stack = new ArrayDeque<>();
			for (int i = 0; i < s.length(); i++) {
				if (stack.contains(s.charAt(i)))
					continue;
				char curr = s.charAt(i);
				while (!stack.isEmpty() && stack.peekLast() - curr > 0) {
					char stackPeek = stack.peekLast();
					String subString = s.substring(i + 1);
					if (subString.contains(Character.toString(stackPeek))) {
						stack.pollLast();
					} else {
						break;
					}
				}
				stack.add(s.charAt(i));
			}
			String ans = "";
			for (char c : stack) {
				ans += c;
			}
			return ans;
		}
	}

}
