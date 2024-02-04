package programmers;

import java.util.HashMap;
import java.util.Map;

public class P42576 {

	/*
	한명을 제외하고 마라톤을 완주.
	완주하지 못한 선수 리턴.
	즉 participant에 있지만 completion에는 없는 선수를 출력하라.
	 */
	class Solution {
		public String solution(String[] participant, String[] completion) {

			String answer = "";

			Map<String, Integer> completionMap = new HashMap<>();
			for (String comp : completion) {
				completionMap.put(comp, completionMap.getOrDefault(comp, 0) + 1);
			}

			for (String p : participant) {
				if (completionMap.getOrDefault(p, 0) > 0) {
					completionMap.put(p, completionMap.get(p) - 1);
				} else {
					answer = p;
				}
			}

			return answer;
		}
	}
}
