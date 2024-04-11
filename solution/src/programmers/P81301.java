package programmers;

import java.util.HashMap;
import java.util.Map;

public class P81301 {

	/*
	원래 의미하는 수
	zero, one,two ... 순회하면서 존재하면 replace
	 */
	class Solution {
		public int solution(String s) {
			Map<String, String> dic = new HashMap<>();
			dic.put("zero", "0");
			dic.put("one", "1");
			dic.put("two", "2");
			dic.put("three", "3");
			dic.put("four", "4");
			dic.put("five", "5");
			dic.put("six", "6");
			dic.put("seven", "7");
			dic.put("eight", "8");
			dic.put("nine", "9");

			for (String key : dic.keySet()) {
				if (s.contains(key)) {
					s = s.replace(key, dic.get(key));
				}
			}
			return Integer.valueOf(s);
		}
	}
}
