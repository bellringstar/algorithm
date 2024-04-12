package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P92334 {
	/*
내가 신고당한 횟수도 관리
내가 신고당한 횟수가 k 이상이다 => 나를 신고한 사람들에게 알림
*/
	class Solution {
		public int[] solution(String[] id_list, String[] report, int k) {
			Map<String, Set<String>> reportMap = new HashMap<>();
			Map<String, Set<String>> reportedMap = new HashMap<>();
			Map<String, Integer> countMap = new HashMap<>();
			for (String id : id_list) {
				reportedMap.put(id, new HashSet<>());
				reportMap.put(id, new HashSet<>());
				countMap.put(id, 0);
			}

			for (String r : report) {
				String[] info = r.split(" ");
				Set<String> reportMe = reportedMap.get(info[1]);
				reportMap.get(info[0]).add(info[1]);
				if (!reportMe.contains(info[0])) {
					reportMe.add(info[0]);
					countMap.put(info[1], countMap.get(info[1]) + 1);
				}
			}

			int[] answer = new int[id_list.length];

			for (int i = 0; i < id_list.length; i++) {
				String id = id_list[i];
				int cnt = 0;
				for (String user : reportMap.get(id)) {
					if (countMap.get(user) >= k) {
						cnt++;
					}
				}
				answer[i] = cnt;
			}

			return answer;
		}
	}

	class Solution2 {
		public int[] solution(String[] id_list, String[] report, int k) {
			Map<String, Set<String>> reportedUser = new HashMap<>();
			Map<String, Integer> count = new HashMap<>();

			for (String r : report) {
				String[] s = r.split(" ");
				String userId = s[0];
				String reportedId = s[1];

				if (!reportedUser.containsKey(reportedId)) {
					reportedUser.put(reportedId, new HashSet<>());
				}
				reportedUser.get(reportedId).add(userId);
			}

			for (Map.Entry<String, Set<String>> entry : reportedUser.entrySet()) {
				if (entry.getValue().size() >= k) {
					for (String uid : entry.getValue()) {
						count.put(uid, count.getOrDefault(uid, 0) + 1);
					}
				}
			}
			int[] answer = new int[id_list.length];
			for (int i = 0; i < id_list.length; i++) {
				answer[i] = count.getOrDefault(id_list[i], 0);
			}
			return answer;
		}
	}
}
