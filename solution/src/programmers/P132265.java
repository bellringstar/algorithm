package programmers;

import java.util.HashMap;
import java.util.Map;

public class P132265 {
	/*
	동일 가지수의 토핑
	형 동생 Map을 구성해 토핑을 관리
	Map의 key가 answer++
	*/
	class Solution {
		public int solution(int[] topping) {
			Map<Integer, Integer> a = new HashMap<>();
			Map<Integer, Integer> b = new HashMap<>();
			for (int t : topping) {
				b.put(t, b.getOrDefault(t, 0) + 1);
			}

			int answer = 0;

			for (int i = 0; i < topping.length; i++) {
				int t = topping[i];
				a.put(t, a.getOrDefault(t, 0) + 1);
				b.put(t, b.get(t) - 1);
				if (b.get(t) == 0) {
					b.remove(t);
				}
				if (a.keySet().size() == b.keySet().size()) answer++;
			}

			return answer;
		}
	}

}
