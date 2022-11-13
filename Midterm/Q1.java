package Midterm;

public class NextLeft {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right, TreeNode next) {
			this.val = val;
		    this.left = left;
		    this.right = right;
		    this.next = next;
		}
	}
	
	public TreeNode Q1(TreeNode root) {
		if(root == null) return null;
		while(root.right != null) {
			TreeNode curr = root;
			while(curr.next != null) {
				curr.right.next = curr.left;
				curr.left.next = curr.next.right;
				curr = curr.next;
			}
			curr.right.next = curr.left;
			root = root.right;
		}
		return root;
	}
	//Time Complexity: O(n)

}
