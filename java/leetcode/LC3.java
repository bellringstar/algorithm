package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC3 {

	/*
	문자열 s가 주어졌을 때 반복되는 문자가 없는 가장 긴 substring의 길이를 리턴해라
	"abcabcbb" -> "abc" -> 3
	1. 확장해가며 중복되는 문자가 나오는 순간 중지 -> 길이 반환 함수
	2. 1의 함수를 시작점을 변경해가며 시행
	 */

	static class Solution {
		public static int lengthOfLongestSubString(String s) {
			int maxLength = 0;
			for (int start = 0; start < s.length(); start++) {
				int length = expand(s, start);
				maxLength = Math.max(maxLength, length);
			}
			System.out.println(maxLength);
			return maxLength;
		}

		private static int expand(String s, int start) {
			Set<Character> characters = new HashSet<>();
			int length = 0;
			for (int i = start; i < s.length(); i++) {
				if (characters.contains(s.charAt(i))) {
					return length;
				}
				characters.add(s.charAt(i));
				length++;
			}
			return length;
		}
	}

	class Solution2 {
		public int lengthOfLongestSubstring(String s) {
			HashMap<Character, Integer> used = new HashMap<>();
			int maxLength = 0;
			int left = 0;
			int right = 0;
			for (char c : s.toCharArray()) {
				if (used.containsKey(c) && left <= used.get(c)) {
					left = used.get(c) + 1;
				} else {
					maxLength = Math.max(maxLength, right - left + 1);
				}
				used.put(c, right);
				right++;
			}
			return maxLength;
		}
	}

	public static void main(String[] args) {
		Solution.lengthOfLongestSubString("pwwkew");
	}
}
