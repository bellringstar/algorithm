import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC49 {
	class Solution {
		public List<List<String>> groupAnagrams(String[] strs) {
			Map<String, List<String>> groupMap = new HashMap<>();
			for (String word : strs) {
				char[] c = word.toCharArray();
				Arrays.sort(c);
				String key = Arrays.toString(c);
				groupMap.putIfAbsent(key, new ArrayList<>());
				groupMap.get(key).add(word);
			}
			List<List<String>> answer = new ArrayList<>();
			for (Map.Entry entry : groupMap.entrySet()) {
				answer.add((List<String>)entry.getValue());
			}
			return answer;
		}
	}
}
