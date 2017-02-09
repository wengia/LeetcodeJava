package solution;

/* Odd Even Linked List - Medium */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = head, pos = head.next;
        
        while(pos != null && pos.next != null) {
    		ListNode currentOdd = pos.next;
    		pos.next = currentOdd.next;
    		currentOdd.next = odd.next;
    		odd.next = currentOdd;
    		
    		odd = odd.next;
        	pos = pos.next.next;
        }
        
        return head;
    }
}
