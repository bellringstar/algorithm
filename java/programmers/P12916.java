package programmers;

public class P12916 {

	class Solution {
		boolean solution(String s) {

			s = s.toLowerCase();

			int pCount = 0;
			int yCount = 0;
			for (char c : s.toCharArray()) {
				if (c == 'p') {
					pCount++;
				} else if (c == 'y') {
					yCount++;
				}
			}
			return pCount == yCount;
		}
	}

	class Solution2 {
		boolean solution(String s) {
			s = s.toLowerCase();

			int ps = s.length() - s.replace("p", "").length();
			int ys = s.length() - s.replace("y", "").length();
			return ps == ys;
		}
	}

	class Solution3 {
		boolean solution(String s) {
			int ps = 0;
			int ys = 0;

			for (char c : s.toCharArray()) {
				switch (c) {
					case 'p', 'P' -> ps++;
					case 'y', 'Y' -> ys++;
				}
			}

			return ps == ys;
		}
	}
}
