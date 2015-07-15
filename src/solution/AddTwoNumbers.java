package solution;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0), pos = res;
        int carry = 0;
        
        while (l1 != null && l2 != null) {
        	int current = l1.val + l2.val + carry;
        	pos.next = new ListNode(current % 10);
        	carry = current / 10;
        	l1 = l1.next;
        	l2 = l2.next;
        	pos = pos.next;
        }
        
        while (l1 != null) {
        	int current = l1.val + carry;
        	pos.next = new ListNode(current % 10);
        	carry = current / 10;
        	l1 = l1.next;
        	pos = pos.next;
        }
        
        while (l2 != null) {
        	int current = l2.val + carry;
        	pos.next = new ListNode(current % 10);
        	carry = current / 10;
        	l2 = l2.next;
        	pos = pos.next;
        }
        
        if (carry != 0)
        	pos.next = new ListNode(carry);
        
        return res.next;
    }
}
