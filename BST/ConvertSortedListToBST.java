package BST;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBST {
	
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        return binarySearch(list, 0, list.size() - 1);
    }
    
    public TreeNode binarySearch(List<Integer> list, int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start)/2;
        TreeNode curr = new TreeNode(list.get(mid));
        curr.left = binarySearch(list, start, mid - 1);
        curr.right = binarySearch(list, mid + 1, end);
        return curr;
    }

}
