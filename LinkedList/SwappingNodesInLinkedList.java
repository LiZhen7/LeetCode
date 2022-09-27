package LinkedList;

public class SwappingNodesInLinkedList {

	class ListNode {
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public ListNode swapNodes(ListNode head, int k) {
        if(head == null) return null;
        int len = 0;
        ListNode curr = head;
        ListNode begin = head;
        while(curr != null) {
            len++;
            if(len == k) {
                begin = curr;
            }
            curr = curr.next;
        }
        int lastPosition = len - k;
        curr = head;
        while(lastPosition > 0) {
            curr = curr.next;
            lastPosition--;
        }
        
        int tmp = curr.val;
        curr.val = begin.val;
        begin.val = tmp;
        
        return head;
    }
}
