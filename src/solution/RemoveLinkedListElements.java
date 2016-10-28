package solution;

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummyHead = new ListNode(-1), pos = dummyHead;
		dummyHead.next = head;
		
		while(pos != null && pos.next != null) {
			if(pos.next.val == val)
				pos.next = pos.next.next;
			else
				pos = pos.next;
		}
		
        return dummyHead.next;
    }
}
