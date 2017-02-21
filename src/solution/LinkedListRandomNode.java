package solution;

import java.util.Random;

/** Linked List Random Node - Medium 
 * 
 *  Solution: Reservoir sampling
 * */
public class LinkedListRandomNode {
	private ListNode head;
	private Random rand = new Random();

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.head = head; 
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int res = head.val, i = 1;
        ListNode pos = head.next;
        
        while(pos != null) {
        	int k = rand.nextInt(++i);
        	if (k == 0)
        		res = pos.val;
        	pos = pos.next;
        }
        
        return res;
    }
}
