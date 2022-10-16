package Quiz1;

public class SameTree {
	
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
	
	public boolean sameTree(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null) return true;
		if(t1 == null || t2 == null) return false;
		if(t1.val != t2.val) return false;
		return sameTree(t1.left, t2.left) && sameTree(t1.right, t2.right);
	}

}
