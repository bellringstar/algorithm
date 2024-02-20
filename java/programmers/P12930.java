package programmers;

public class P12930 {

	/*
	짝수, 홀수의 판정을 띄어쓰기 별로 나눠진 단어마다 처리
	1. 공백을 기준으로 단어를 나눈다.
	2. 해당 단어별로 charArray로 변경 후 대소문자 변환
	3. 다시 문자열로 변경 해 공백을 끼워넣어서 합친다.
	 */

	class Solution {
		public String solution(String s) {
			StringBuilder sb = new StringBuilder();
			boolean toUpper = true;

			for (char c : s.toCharArray()) {
				if (!Character.isAlphabetic(c)) {
					sb.append(c);
					toUpper = true;
				} else {
					if (toUpper) {
						sb.append(Character.toUpperCase(c));
					} else {
						sb.append(Character.toLowerCase(c));
					}
					toUpper = !toUpper;
				}
			}

			return sb.toString();
		}
	}
}
