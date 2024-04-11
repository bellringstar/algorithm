package programmers;

import java.util.ArrayList;
import java.util.List;

public class P84512 {

	/*
	A,E,I,O,U로 이루어진 길이 5이하의 모든 단어가 사전에 수록.
	첫째단어는 A 그  다음은 AA 마지막은 UUUUU
	단어 word가 몇번째 단어일까?

	모든 단어는 5^5개 -> 여유 전부 만들어서 해당 단어의 인덱스를 리턴하면 된다.

	1. 상태
	(word) : 단어가 변화한다.
	2. 종료조건
	단어 길이가 5일때 더이상 이어붙이지 못한다.
	3. 점화식
	(word) = [word] + (word + 'A') + (word +'E') + (word + 'I') + (word + 'O') + (word + 'U)

	 */
	class Solution {

		private static final char[] CHARS = "AEIOU".toCharArray();

		public int solution(String word) {
			return generate("").indexOf(word);
		}

		private List<String> generate(String word) {
			List<String> words = new ArrayList<>();
			words.add(word);

			if (word.length() == 5)
				return words;

			for (char c : CHARS) {
				words.addAll(generate(word + c));
			}
			return words;
		}

		private void generate2(String word, List<String> words) {
			words.add(word);

			if (word.length() == 5)
				return;

			for (char c : CHARS) {
				generate2(word + c, words);
			}
		}
	}
}
