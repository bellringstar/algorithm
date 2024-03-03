import java.util.ArrayDeque;
import java.util.Deque;


public class P12909 {

	/*
	여는 괄호 -> 스택에 넣는다
	닫는 괄호 -> 스택에서 꺼내 짝인지 확인한다.
	 */

	class Solution {

		boolean solution(String s) {

			Deque<Character> stack = new ArrayDeque<>();

			for (char p : s.toCharArray()) {
				if (p == '(') {
					stack.push(p);
				} else {
					if (stack.isEmpty()) return false;
					stack.pop();
				}
			}
			return stack.isEmpty();
		}
	}
}
