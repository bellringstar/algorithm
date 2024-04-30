package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P42577 {
/*
오름차순 정렬
*/
	class Solution {
		public boolean solution(String[] phone_book) {
			Arrays.sort(phone_book);
			for (int i = 1; i < phone_book.length; i++) {
				if (phone_book[i].startsWith(phone_book[i-1])) return false;
			}
			return true;
		}
	}

	class Solution2 {
		public boolean solution(String[] phone_book) {

			Set<String> set = new HashSet<>(Arrays.asList(phone_book));

			for (String s : phone_book) {
				for (int i = 1; i < s.length(); i++) {
					if (set.contains(s.substring(0, i))) return false;
				}
			}
			return true;
		}
	}
}
