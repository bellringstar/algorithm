import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LC819 {
	/**
	 * 가장 흔한 단어
	 * ban되지 않은 단어중 가장 많이 나온 단어를 출력하라.
	 * 최소한 한 단어 이상이 ban에 포함돼있으며 답은 유니크하다.
	 * 문자열은 대소문자 구분이 없이 횟수를 계산하고 출력은 소문자로 해야한다.
	 */
	class Solution {
		public String mostCommonWord(String paragraph, String[] banned) {
			int maxCount = 0;
			String mostCommonWord = "";
			Map<String, Integer> wordCounter = new HashMap<>();
			paragraph = paragraph.replaceAll("\\W+"," ");
			for (int i = 0; i < banned.length; i++) {
				banned[i] = banned[i].toLowerCase();
			}
			for (String word : paragraph.split(" ")) {
				String key = word.toLowerCase();
				if (!isBanned(key,banned)) {
					wordCounter.put(key, wordCounter.getOrDefault(key, 0) + 1);
				}
			}
			for (Map.Entry<String, Integer> entrySet : wordCounter.entrySet()) {
				if (entrySet.getValue() > maxCount) {
					mostCommonWord = entrySet.getKey();
					maxCount = entrySet.getValue();
				}
				System.out.println("word = " + entrySet.getKey() + " count = " + entrySet.getValue());
			}
			// Collections.max(wordCounter.entrySet(), Map.Entry.comparingByValue());
			return mostCommonWord;

		}

		public boolean isBanned(String key, String[] banned) {
			for (String word : banned) {
				if (word.equals(key)) {
					return true;
				}
			}
			return false;
		}
	}
}
