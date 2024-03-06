import java.util.*;
import java.util.stream.Collectors;

public class P42862 {
	/*
	 * +-1 학생에게서만 빌려줄 수 있다.
	 * 최대한 많은 학생이 체육복을 입어야 한다.
	 * 1. 빌려줄 수 있는가? -> 여벌 체육복을 가져왔는데 도둑질을 안당했다 && 번호가 +- 1
	 * 정렬 후 작은 번호부터 빌려준다.
	 */
	
	class Solution {
	    public int solution(int n, int[] lost, int[] reserve) {
	    	Arrays.sort(lost);
	    	Arrays.sort(reserve);
	    	
	    	Set<Integer> owns = Arrays.stream(lost)
	    						.boxed()
	    						.collect(Collectors.toSet());
	    	owns.retainAll(Arrays.stream(reserve)
	    			.boxed()
	    			.collect(Collectors.toSet()));
	    	
	    	Queue<Integer> q = new LinkedList<>();
	    	for (int l : lost) q.add(l);
	    	
	    	int get = 0;
	    	for (int r : reserve) {
	    		if (owns.contains(r)) continue;
	    		while (!q.isEmpty() && (q.peek() < r - 1 || owns.contains(q.peek()))) {
	    			q.poll();
	    		}
	    		if (q.isEmpty()) break;
	    		
	    		if (q.peek() <= r + 1) {
	    			q.poll();
	    			get++;
	    		}
	    	}
	    	return n - lost.length + owns.size() + get;
	    }
	}

}
