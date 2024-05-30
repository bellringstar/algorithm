package programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class P12917 {

	class Solution {
		public String solution(String s) {
			return Arrays.stream(s.split(""))
					.sorted((s1, s2) -> s2.compareTo(s1))
					.collect(Collectors.joining(""));
		}
	}

	class Solution2 {
		public String solution(String s) {

			return s.chars()
				.boxed()
				.sorted((v1, v2) -> v2 - v1)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
		}
	}
}
