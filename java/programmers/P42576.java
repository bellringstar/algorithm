import java.util.HashMap;
import java.util.Map;

public class P42576 {

	class Solution {
		public String solution(String[] participant, String[] completion) {

			Map<String, Integer> participantMap = new HashMap<>();
			for (String p : participant) {
				participantMap.put(p, participantMap.getOrDefault(p, 0) + 1);
			}

			for (String c : completion) {
				participantMap.put(c, participantMap.get(c) - 1);
			}

			String answer = "";

			for (Map.Entry<String, Integer> entry :participantMap.entrySet()) {
				if (entry.getValue() != 0) {
					answer = entry.getKey();
				}
			}

			return answer;
		}
	}

	class Solution2 {
		public String solution(String[] participant, String[] completion) {
			Map<String, Integer> count = new HashMap<>();

			for (String name : participant) {
				count.put(name, count.getOrDefault(name, 0) + 1);
			}

			for (String name : completion) {
				int v = count.get(name) - 1;
				count.put(name, v);
				if (v == 0) count.remove(name);
			}

			return count.keySet().iterator().next();

		}
	}
}
