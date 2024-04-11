package programmers;

import java.util.ArrayList;
import java.util.List;

public class P60057 {
	/*
	몇 개 단위로 잘랐을 때 가장 짧은 문자열이 나오는가.
	1,2,3... 단위로 잘라보면서 제일 짧은 길이를 리턴한다.

	 */
	class Solution {
		public int solution(String s) {

			int min = Integer.MAX_VALUE;

			for (int length = 1; length < s.length(); length++) {

				min = Math.min(min, compress(s, length));
			}

			return min;
		}

		private int compress(String source, int length) {

			StringBuilder sb = new StringBuilder();
			int count = 0;
			String last = "";

			for (String token : split(source, length)) {
				if (token.equals(last)) {
					count++;
				} else {
					if (count > 1)
						sb.append(count);
					sb.append(last);
					last = token;
					count = 1;
				}
			}

			if (count > 1)
				sb.append(count);
			sb.append(last);

			return sb.length();
		}

		private List<String> split(String source, int length) {

			List<String> tokens = new ArrayList<>();

			for (int startIndex = 0; startIndex < source.length(); startIndex += length) {
				int endIndex = startIndex + length;
				if (endIndex > source.length())
					endIndex = source.length();

				tokens.add(source.substring(startIndex, endIndex));
			}

			return tokens;
		}
	}
}
