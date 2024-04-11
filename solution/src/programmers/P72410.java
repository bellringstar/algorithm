package programmers;

public class P72410 {

	/*
	아이디의 길이는 3~15
	알파벳 소문자, 숫자, "-", "_", "." 만 사용가능
	"."는 처음과 끝에 사용할 수 없으며 연속으로 사용 불가.

	1. 대문자를 소문자로 치환
	2. 허용 문자를 제외한 문자 제거
	3. "."가 연속된 부분을 "."하나로 변경
	4. "."이 처음이나 끝에 위치한다면 제거
	5. 빈 문자열이라면 a를 대입
	6. 16자 이상이라면 첫 15개만 남기고 제거. 만약 제거 후 "."가 끝에 위치한다면 제거
	7. 길이가 2 이하라면 마지막 문자를 길이가3이 될 때까지 반복해서 추가
	 */

	class Solution {
		public String solution(String newId) {

			newId = newId.toLowerCase();
			newId = newId.replaceAll("[^a-z0-9\\-_.]", "");
			newId = newId.replaceAll("\\.+", ".");
			newId = newId.replaceAll("^\\.+|\\.$", "");
			if (newId.isEmpty()) {
				newId = "a";
			}
			if (newId.length() >= 16) {
				newId = newId.substring(0, 15);
				newId = newId.replaceAll("\\.$", "");
			}
			while (newId.length() < 3) {
				newId = newId + newId.charAt(newId.length() - 1);
			}
			return newId;
		}
	}
}
