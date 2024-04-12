package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
맵을 통해 id : 닉네임을 관리
*/
public class P42888 {
	class Solution {
		public String[] solution(String[] record) {
			Map<String, String> userMap = new HashMap<>();
			List<String> result = new ArrayList<>();
			for (String query : record) {
				String[] q = query.split(" ");
				if (q[0].equals("Enter")) {
					userMap.put(q[1], q[2]);
				} else if (q[0].equals("Change")) {
					userMap.put(q[1], q[2]);
				}
			}

			for (String query : record) {
				String[] q = query.split(" ");
				if (q[0].equals("Enter")) {
					result.add(userMap.get(q[1]) + "님이 들어왔습니다.");
				} else if (q[0].equals("Leave")) {
					result.add(userMap.get(q[1]) + "님이 나갔습니다.");
				}
			}

			return result.stream().toArray(String[]::new);
		}
	}
}
