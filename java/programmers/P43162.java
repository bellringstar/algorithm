import java.util.*;

public class P43162 {
	
	class Solution {
	    public int solution(int n, int[][] computers) {
	        boolean[] isVisited = new boolean[n];
	        int answer = 0;
	        
	        for (int i = 0; i < n; i++) {
	        	if (isVisited[i]) continue;
	        	visitAll(i, computers, isVisited);
	        	answer++;
	        }
	        
	        return answer;
	    }
	    
	    private void visitAll(int computer, int[][] computers, boolean[] isVisited) {
	    	
	    	Deque<Integer> stack = new ArrayDeque<>();
	    	stack.addLast(computer);
	    	
	    	while (!stack.isEmpty()) {
	    		int c = stack.pollLast();
	    		
	    		if (isVisited[c]) continue;
	    		isVisited[c] = true;
	    		
	    		for (int next = 0; next < computers[c].length; next++) {
	    			if (computers[c][next] == 0) continue;
	    			stack.push(next);
	    		}
	    	}
	    }
	}

}
