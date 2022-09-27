package LinkedList;

public class RotateList {
	
	 class ListNode {
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int len = 1;
        ListNode curr = head;
        while(curr.next != null) {
            len++;
            curr = curr.next;
        }
        curr.next = head;
        
        int step = len - k % len;
        curr = head;
        while(step > 1) {
            curr = curr.next;
            step--;
        }
        ListNode newHead = curr.next;
        curr.next = null;
        return newHead;
    }
}
