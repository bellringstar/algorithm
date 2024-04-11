package programmers;

import java.util.HashMap;
import java.util.Map;
/*
제품, 수량 일치 10일
XYZ마트 1일부터 10일까지 제품:수량 을 맵으로 관리
2일이 되면 1일 제품을 -1 11일 제품을 1개 추가...
원하는 제품들을 map으로 관리해 두 map이 일치하면 정답을 1 증가
*/
public class P131127 {
	class Solution {
		public int solution(String[] want, int[] number, String[] discount) {
			Map<String, Integer> wantMap = new HashMap<>();
			for (int i = 0; i < want.length; i++) {
				wantMap.put(want[i], number[i]);
			}

			Map<String, Integer> discountMap = new HashMap<>();
			for (int i = 0; i < 10; i++) {
				String item = discount[i];
				discountMap.put(item, discountMap.getOrDefault(item, 0) + 1);
			}

			int answer = 0;

			for (int day = 0; day < discount.length - 10; day++) {
				if (wantMap.equals(discountMap)) answer++;
				// day 추가 day + 10 제거
				discountMap.put(discount[day], discountMap.get(discount[day]) - 1);
				if (discountMap.get(discount[day]) == 0) {
					discountMap.remove(discount[day]);
				}

				discountMap.put(discount[day+10], discountMap.getOrDefault(discount[day+10], 0) + 1);
			}
			if (wantMap.equals(discountMap)) answer++;

			return answer;
		}
	}
}
