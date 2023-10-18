import java.util.ArrayList;
import java.util.List;

public class LC937 {
	class Solution {
		public String[] reorderLogFiles(String[] logs) {

			List<String> letterList = new ArrayList<>();
			List<String> digitList = new ArrayList<>();

			for(String log:logs){
				if(Character.isLetter(log.split(" ")[1].charAt(0))) {
					letterList.add(log);
				} else {
					digitList.add(log);
				}
			}

			letterList.sort((s1, s2) -> {
				// 식별자와 내용으로 분리
				String[] s1x = s1.split(" ", 2);
				String[] s2x = s2.split(" ", 2);

				// 내용부터 비교
				int compare = s1x[1].compareTo(s2x[1]);

				if (compare == 0) {
					// 동일한 내용일 경우
					return s1x[0].compareTo(s2x[0]);
				} else {
					return compare;
				}
			});

			// 숫자 리스트를 정렬된 문자 리스트에 붙인다
			letterList.addAll(digitList);

			return letterList.toArray(new String[0]);
		}
	}
}
