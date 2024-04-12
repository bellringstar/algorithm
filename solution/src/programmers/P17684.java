package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P17684 {
	/*
단어의 시작부터 늘려가며 Map의 키에 존재하는지 확인. 없다면 마지막 위치에 추가
=> 마지막 위치를 따로 관리
1. 재귀를 통해 현재 있는 단어 중 가장 긴 단어를 찾는다. -> 해당 value 출력
2. 그 다음글자까지 합친 것을 map에 추가한다.
*/
	class Solution {

		public int[] solution(String msg) {
			Map<String, Integer> dic = new HashMap<>();
			for (char i = 'A'; i <= 'Z'; i++) {
				dic.put(Character.toString(i), i - 64);
			}
			int index = 27;
			List<Integer> result = new ArrayList<>();
			String[] arr = msg.split("");
			int start = 0;
			while (start < arr.length) {
				String s = arr[start];
				while (dic.containsKey(s)) {
					if (start == arr.length - 1) {
						start++;
						break;
					} else {
						String str = s + arr[++start];
						if (dic.containsKey(str)) {
							s = str;
						} else {
							dic.put(str, index++);
							break;
						}
					}

				}
				result.add(dic.get(s));
			}

			return result.stream().mapToInt(Integer::intValue).toArray();
		}
	}
}
