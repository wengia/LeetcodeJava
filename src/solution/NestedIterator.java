package solution;

import java.util.*;

/* Flatten Nested List Iterator - Medium */
public class NestedIterator implements Iterator<Integer> {
	LinkedList<Integer> nestSort = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
    	Stack<NestedInteger> nestedStack = new Stack<>();
    	for(NestedInteger item: nestedList)
    		nestedStack.push(item);
    	
    	while(!nestedStack.isEmpty()) {
    		NestedInteger current = nestedStack.pop();
    		if (current.isInteger()) {
    			nestSort.add(current.getInteger());
    			continue;
    		}
    		
    		for(NestedInteger item: current.getList())
    			nestedStack.push(item);
    	}
    }

    @Override
    public Integer next() {
    	return nestSort.pollLast();
    }

    @Override
    public boolean hasNext() {
        return !nestSort.isEmpty();
    }
}
