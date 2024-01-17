import java.util.LinkedList;
import java.util.Queue;

public class LC225 {
	/**
	 * Your MyStack object will be instantiated and called as such:
	 * MyStack obj = new MyStack();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.top();
	 * boolean param_4 = obj.empty();
	 * 두 개의 큐를 사용해 스택을 구현하자.
	 */
	class MyStack {
		Queue<Integer> queue = new LinkedList<>();

		public MyStack() {
		}

		public void push(int x) {
			//Pushes element x to the top of the stack.
			queue.add(x);
			for (int i = 1; i < queue.size(); i++) {
				queue.add(queue.remove());
			}
		}

		public int pop() {
			//Removes the element on the top of the stack and returns it.
			return queue.remove();
		}

		public int top() {
			//Returns the element on the top of the stack.
			return queue.peek();
		}

		public boolean empty() {
			//Returns true if the stack is empty, false otherwise.
			return queue.size() == 0;
		}
	}

}
