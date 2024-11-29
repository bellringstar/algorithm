package leetcode;

public class LC1768 {
	class Solution {
		public String mergeAlternately(String word1, String word2) {
			// word1, word2를 번갈아가면서 문자를 추가해간다.
			StringBuilder sb = new StringBuilder();
			int length = word1.length() > word2.length() ? word1.length() : word2.length();
			for (int i = 0; i < length; i++) {
				if (i < word1.length()) {
					sb.append(word1.charAt(i));
				}

				if (i < word2.length()) {
					sb.append(word2.charAt(i));
				}
			}

			return sb.toString();
		}
	}
}
