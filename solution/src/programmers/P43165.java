import java.util.*;

public class P43165 {
	/*
	 * 0부터 시작해서 더하거나 뺴거나
	 */
	class Solution {
		
		private static class State {
			public final int index;
			public final int acc;
			
			State(int index, int acc) {
				this.index = index;
				this.acc = acc;
			}
		}
		
	    public int solution(int[] numbers, int target) {
	    	Deque<State> stack = new ArrayDeque<>();
	    	stack.addLast(new State(0, 0));
	    	
	    	int count = 0;
	    	
	    	while (!stack.isEmpty()) {
	    		State state = stack.pollLast();
	    		
	    		if (state.index == numbers.length) {
	    			if (state.acc == target) count++;
	    			continue;
	    		}
	    		
	    		stack.addLast(new State(state.index + 1, state.acc - numbers[state.index]));
	    		stack.addLast(new State(state.index + 1, state.acc + numbers[state.index]));
	    	}
	    	return count;
	    }	   
	}

}
