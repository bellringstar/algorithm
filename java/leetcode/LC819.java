package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC819 {
	class Solution {
		public String mostCommonWord(String paragraph, String[] banned) {
			// 가장 많이 등장한 단어(금지단어 제외)
			// 1. paragraph를 전부 소문자로 변경해 단어들만 뽑아낸다.
			Set<String> ban = new HashSet<>(Arrays.asList(banned)); // 포함여부 확인을 위해 set으로 변경
			List<String> wordList = new ArrayList<>();
			Map<String, Integer> countMap = new HashMap<>();
			paragraph = paragraph.replaceAll("[^a-zA-z]", " ");
			String[] words = paragraph.split(" ");
			for (String word : words) {
				if (!word.isBlank()) {
					wordList.add(word.toLowerCase());
				}
			}
			// 2. 각 단어를 보면서 단어가 banned가 아니면 개수를 세서 추가한다.
			for (String word : wordList) {
				if (!ban.contains(word)) {
					int cnt = countMap.getOrDefault(word, 0);
					countMap.put(word, cnt + 1);
				}
			}

			return Collections.max(countMap.entrySet(), Map.Entry.comparingByValue()).getKey();
		}
	}
}
