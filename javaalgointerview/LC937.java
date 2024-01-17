import java.util.ArrayList;
import java.util.List;

public class LC937 {
	/**
	 * 로그파일은 스페이스로 구분된 단어들.
	 * 구분자 = 첫 단어
	 * Letter-logs = 구분자를 제외한 모든 단어가 영단어 소문자
	 * Digit-logs = 구분자를 제외한 모든 단어가 숫자
	 * 재정렬 필요 재정렬 기준
	 * 1. letter log가 digit log보다 먼저 나와야한다.
	 * 2. lttter log는 사전순으로 정렬 만약 content가 같다면 구분자로 사전순
	 * 3. digit log는 순서 유지
	 */
	class Solution {
		public String[] reorderLogFiles(String[] logs) {
			List<String> letterLogs = new ArrayList<>();
			List<String> digitLogs = new ArrayList<>();
			for (String log : logs) {
				String[] l = log.split(" ");
				if (Character.isDigit(l[1].charAt(0))) {
					digitLogs.add(log);
				} else {
					letterLogs.add(log);
				}
			}

			letterLogs.sort((s1, s2) -> {
				String[] s1x = s1.split(" ", 2);
				String[] s2x = s2.split(" ", 2);

				int compared = s1x[1].compareTo(s2x[1]);
				if (compared == 0) {
					return s1x[0].compareTo(s2x[0]);
				}
				return compared;
			});

			letterLogs.addAll(digitLogs);
			return letterLogs.toArray(new String[0]);
		}
	}
}
