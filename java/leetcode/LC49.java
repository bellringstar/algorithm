package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LC49 {
	class Solution {
		public List<List<String>> groupAnagrams(String[] strs) {
			// HashMap을 통해 해당 키로 String[]가 존재하면 넣고 없으면 만들어서 자신을 넣는다.
			Map<String, List<String>> anagrams = new HashMap<>();
			List<List<String>> rst = new ArrayList<>();
			for (String str : strs) {
				// str을 정렬
				String sortedStr = Arrays.stream(str.split("")).sorted().collect(Collectors.joining());
				List<String> emptyList = new ArrayList<>();
				List<String> values = anagrams.getOrDefault(sortedStr, emptyList);
				values.add(str);
				anagrams.put(sortedStr, values);
			}
			for (Map.Entry<String, List<String>> entry : anagrams.entrySet()) {
				rst.add(entry.getValue());
			}
			return rst;
		}
	}

	class Solution2 {
		public List<List<String>> groupAnagrams(String[] strs) {
			Map<String, List<String>> result = new HashMap<>();
			for (String s : strs) {
				char[] chars = s.toCharArray();
				Arrays.sort(chars);
				String key = new String(chars);

				if (!result.containsKey(key)) {
					result.put(key, new ArrayList<>());
				}
				result.get(key).add(s);
			}
			return new ArrayList<>(result.values());
		}
	}
}
