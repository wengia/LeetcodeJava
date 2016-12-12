package solution;

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		if (head == null) return true;
		ListNode fast = head.next, slow  = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		fast = slow.next;
		while(fast != null && fast.next != null) {
			ListNode tmp = fast.next;
			fast.next = tmp.next;
			tmp.next = slow.next;
			slow.next = tmp;
		}
		
		fast = head;
		slow = slow.next;
		while(fast != null && slow != null) {
			if (fast.val != slow.val)
				return false;
			fast = fast.next;
			slow = slow.next;
		}
		
        return true;
    }
}
