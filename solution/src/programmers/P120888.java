package programmers;

import java.util.HashSet;
import java.util.Set;

public class P120888 {

	class Solution {
		public String solution(String my_string) {
			Set<Character> characters = new HashSet<>();
			StringBuilder sb = new StringBuilder();
			for (char c : my_string.toCharArray()) {
				if (characters.contains(c)) continue;
				characters.add(c);
				sb.append(c);
			}

			return sb.toString();

		}
	}
}
