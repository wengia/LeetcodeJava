package solution;

import java.util.Stack;

public class ImplementQueueusingStacks {
	Stack<Integer> mainSt = new Stack<>();
	Stack<Integer> helper = new Stack<>();
	
	// Push element x to the back of queue.
    public void push(int x) {
        mainSt.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        peek();
        helper.pop();
    }

    // Get the front element.
    public int peek() {
        if (!helper.isEmpty())
        	return helper.peek();
        
        while(!mainSt.isEmpty()) {
        	helper.push(mainSt.pop());
        }
        
        return helper.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return mainSt.isEmpty() && helper.isEmpty();
    }
}
