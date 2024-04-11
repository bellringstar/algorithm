import java.util.Arrays;

public class P49993 {
	/*
	 * 선행 스킬
	 * skill 이외의 다른 문자는 영향 x -> 제거 가능
	 * skill에서 앞부터 나와야한다 -> prefix
	 */

	class Solution {
	    public int solution(String skill, String[] skillTrees) {
	        return (int) Arrays.stream(skillTrees)
	        	.map(s -> s.replaceAll("[^" + skill + "]", ""))
	        	.filter(skill::startsWith)
	        	.count();
	    }
	}

}
