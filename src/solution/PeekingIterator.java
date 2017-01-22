package solution;

import java.util.Iterator;

/* Peeking Iterator - Medium */
public class PeekingIterator implements Iterator<Integer> {
	private Iterator<Integer> iterator;
	private Integer peekNumber;
	private boolean hasPeeked;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (hasPeeked) return peekNumber;
        peekNumber = iterator.next();
        hasPeeked = true;
        return peekNumber;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(!hasPeeked) return iterator.next();
	    
	    hasPeeked = false;
	    return peekNumber;
	}

	@Override
	public boolean hasNext() {
	    return iterator.hasNext() || hasPeeked;
	}
}
