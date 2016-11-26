package solution;

import java.util.*;

public class ImplementStackusingQueues {
	Queue<Integer> que = new LinkedList<>();
	Queue<Integer> cacheQue = new LinkedList<>();
	
	// Push element x onto stack.
    public void push(int x) {
        que.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while(que.size() > 1) cacheQue.add(que.poll());
        if (!que.isEmpty()) {
        	que.poll();
        	return;
        }
        
        while(cacheQue.size() > 1) que.add(cacheQue.poll());
        if (!cacheQue.isEmpty()) cacheQue.poll();
    }

    // Get the top element.
    public int top() {
    	while(que.size() > 1) cacheQue.add(que.poll());
        if (!que.isEmpty()) return que.peek();
        
        int res = 0;
        while(!cacheQue.isEmpty()) {
        	if (cacheQue.size() == 1) res = cacheQue.peek();
        	que.add(cacheQue.poll());
        }
        
        return res;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return que.isEmpty() && cacheQue.isEmpty();
    }
}
