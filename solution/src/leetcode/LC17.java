package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC17 {
	/*
	2~9로 이루어진 문자열 digits, 모든 가능한 문자 조합을 리턴하시오.
	 */

	class Solution {
		public List<String> letterCombinations(String digits) {
			if (digits.isBlank())
				return List.of();

			Map<Character, List<Character>> dic = new HashMap<>();
			dic.put('0', List.of());
			dic.put('1', List.of());
			dic.put('2', List.of('a', 'b', 'c'));
			dic.put('3', List.of('d', 'e', 'f'));
			dic.put('4', List.of('g', 'h', 'i'));
			dic.put('5', List.of('j', 'k', 'l'));
			dic.put('6', List.of('m', 'n', 'o'));
			dic.put('7', List.of('p', 'q', 'r', 's'));
			dic.put('8', List.of('t', 'u', 'v'));
			dic.put('9', List.of('w', 'x', 'y', 'z'));

			List<String> results = new ArrayList<>();
			dfs(digits, 0, new StringBuilder(), dic, results);

			return results;
		}

		public void dfs(String digit, int idx, StringBuilder path, Map<Character, List<Character>> dic,
			List<String> results) {
			if (path.length() == digit.length()) {
				results.add(path.toString());
				return;
			}

			for (char c : dic.get(digit.charAt(idx))) {
				dfs(digit, idx + 1, new StringBuilder(path).append(c), dic, results);
			}
		}
	}
}
