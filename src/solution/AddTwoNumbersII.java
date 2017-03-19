package solution;

import java.util.Stack;

/* Add Two Numbers II - Medium */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        
        ListNode l1_cp = l1, l2_cp = l2;
        while(l1_cp != null) {
        	st1.push(l1_cp.val);
        	l1_cp = l1_cp.next;
        }
        while(l2_cp != null) {
        	st2.push(l2_cp.val);
        	l2_cp = l2_cp.next;
        }
        
        ListNode head = new ListNode(-1);
        int carry = 0;
        while(!st1.isEmpty() || !st2.isEmpty()) {
        	int cur = carry;
        	if (!st1.isEmpty()) cur += st1.pop();
        	if (!st2.isEmpty()) cur += st2.pop();
        	ListNode node = new ListNode(cur % 10);
        	node.next = head.next;
        	head.next = node;
        	carry = cur / 10;
        }
        
        if (carry > 0) {
        	ListNode node = new ListNode(carry % 10);
        	node.next = head.next;
        	head.next = node;
        }
        
        return head.next;
    }
}
