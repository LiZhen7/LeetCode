package Quiz1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
	
    public class TreeNode {
		
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
    
    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
    	List<List<Integer>> ans = new ArrayList<>();
    	if(root == null) return ans;
    	Queue<TreeNode> q = new LinkedList<>();
    	q.add(root);
    	while(!q.isEmpty()) {
    		int size = q.size();
    		List<Integer> sub = new ArrayList<>();
    		for(int i = 0; i < size; i++) {
    			TreeNode curr = q.poll();
    			sub.add(curr.val);
    			if(curr.left != null) q.add(curr.left);
    			if(curr.right != null) q.add(curr.right);
    		}
    		ans.add(sub);
    	}
    	return ans;
    }

}
