package LinkedList;

public class SplitLinkedListInParts {

	class ListNode {
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int len = 0;
        ListNode curr = head;
        while(curr != null) {
            len++;
            curr = curr.next;
        }
        
        int m = len / k;
        int n = len % k;
        int[] count = new int[k];
        for(int i = 0; i < k; i++) {
            count[i] = m;
        }
        for(int i = 0; i < n; i++) {
            count[i]++;
        }
        
        curr = head;
        for(int i = 0; i < k; i++) {
            if(count[i] == 0) continue;
            ans[i] = curr;
            for(int j = 0; j < count[i] - 1; j++) {
                curr = curr.next;
            }
            ListNode preTail = curr;
            curr = curr.next;
            preTail.next = null;
        }
        return ans;
    }
}
