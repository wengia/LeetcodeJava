package solution;

import java.util.*;

public class MinStack {
	private Stack<Integer> stack;
	private Stack<MinElement> minElementQue;
	
	/** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minElementQue = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (minElementQue.isEmpty() || x < minElementQue.peek().value) {
        	minElementQue.push(new MinElement(x, 1));
        } else if (x == minElementQue.peek().value) {
        	minElementQue.peek().frequency++;
        }
    }
    
    public void pop() {
        int value = stack.pop();
        if (value == minElementQue.peek().value) {
        	minElementQue.peek().frequency--;
        }
        if (minElementQue.peek().frequency == 0) {
        	minElementQue.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minElementQue.peek().value;
    }
    
    private class MinElement {
    	private int value;
    	private int frequency;
    	
    	private MinElement(int value, int frequency) {
    		this.value = value;
    		this.frequency = frequency;
    	}
    }
}
