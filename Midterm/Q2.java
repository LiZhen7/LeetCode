package Midterm;

import java.util.LinkedList;
import java.util.Queue;

public class Q2 {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right, TreeNode parent) {
			this.val = val;
		    this.left = left;
		    this.right = right;
		    this.parent = parent;
		}
	}
	
	public TreeNode parentNode(TreeNode root) {
		if(root == null) return null;
		root.parent = root;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				TreeNode curr = q.poll();
				if(curr.left != null) {
					q.add(curr.left);
					curr.left.parent = curr;
				}
				if(curr.right != null) {
					q.add(curr.right);
					curr.right.parent = curr;
				}
			}
		}
		return root;
	}
	//Time Complexity:O(n)

}
