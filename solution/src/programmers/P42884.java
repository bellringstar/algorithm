import java.util.Arrays;
import java.util.Comparator;

public class P42884 {
	
	class Solution {
	    public int solution(int[][] routes) {
	    	Arrays.sort(routes, Comparator.comparingInt(route -> route[1]));
	    	
	    	int last = Integer.MIN_VALUE;
	    	int count = 0;
	    	
	    	for (int[] route : routes) {
	    		if (last >= route[0] && last <= route[1]) continue;
	    		last = route[1];
	    		count++;
	    	}
	    	
	    	return count;
	    }
	}

}
