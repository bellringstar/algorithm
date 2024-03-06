import java.util.*;
import java.util.stream.Collectors;

public class P42883 {
	
	class Solution {
	    public String solution(String number, int k) {
	    	Deque<Character> stack = new ArrayDeque<>();
	    	
	    	for (char c : number.toCharArray()) {
	    		while (k > 0 && !stack.isEmpty() && c > stack.peek()) {
	    			stack.pollLast();
	    			k--;
	    		}
	    		stack.addLast(c);
	    	}
	    	
	    	while (k-- > 0) {
	    		stack.pollLast();
	    	}
	    	
	    	return stack.stream().map(String::valueOf)
	    			.collect(Collectors.joining());

	    }
	}

}
