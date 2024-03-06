import java.util.*;

public class P43163 {
	/*
	 * 시작단어 부터 words를 순회하며 알파벳 하나만 바꿔서 만들 수 있는거면 q에 삽입, 방문처리
	 * target이 등장하면 종료
	 * 모든 단어가 방문처리됐는데 target을 못찾으면 0
	 */
	
	class Solution {
		
		private boolean isConvertable(String src, String dst) {
			char[] srcArr = src.toCharArray();
			char[] dstArr = src.toCharArray();
			int diff = 0;
			for (int i = 0; i < srcArr.length; i++) {
				if (srcArr[i] != dstArr[i]) diff++;
			}
			return diff == 1;
		}
		
		private static class State {
			public final String word;
			public final int step;
			
			private State(String word, int step) {
				this.word = word;
				this.step = step;
			}
		}
		
	    public int solution(String begin, String target, String[] words) {
	        boolean[] isVisited = new boolean[words.length];
	        
	        Queue<State> queue = new LinkedList<>();
	        queue.add(new State(begin, 0));
	        
	        while (!queue.isEmpty()) {
	        	State state = queue.poll();
	        	
	        	if (state.word.equals(target)) {
	        		return state.step;
	        	}
	        	
	        	for (int i = 0; i < words.length; i++) {
	        		String next = words[i];
	        		
	        		if (!isConvertable(state.word, next)) continue;
	        		if (isVisited[i]) continue;
	        		
	        		isVisited[i] = true;
	        		queue.add(new State(next, state.step + 1));
	        	}
	        }
	        
	        return 0;
	    }
	}

}
