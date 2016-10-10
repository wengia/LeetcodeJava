package solution;

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode posMin = headA, pos = headB;
        while (posMin != null || pos != null) {
        	if (posMin != null) {
        		lenA++;
        		posMin = posMin.next;
        	}
        	if (pos != null) {
        		lenB++;
        		pos = pos.next;
        	}
        }
        
        int diff = Math.abs(lenA - lenB);
        posMin = (lenA < lenB) ? headA : headB;
        pos = (lenA < lenB) ? headB : headA;
        while(diff-- > 0) pos = pos.next;
        while (pos != null) {
        	if (posMin == pos) return pos;
        	posMin = posMin.next;
        	pos = pos.next;
        }
        
        return null;
    }
}
