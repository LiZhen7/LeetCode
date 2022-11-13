package Midterm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q3 {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
		    this.left = left;
		    this.right = right;
		}
	}
	
	public List<Integer> insideRange(TreeNode root, int start, int end) {
		List<Integer> ans = new ArrayList<>();
		if(root == null) return ans;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				TreeNode curr = q.poll();
				if(curr.val >= start && curr.val <= end) {
					ans.add(curr.val);
				}
				if(curr.left != null && curr.val > start) {
					q.add(curr.left);
				}
				if(curr.right != null && curr.val < end) {
					q.add(curr.right);
				}
			}
		}
		return ans;
	}
	//Time Complexity:O(n)

}
