package BinaryTree;

public class MaximumDepth {
	
	private int ans = 0;
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        helper(root, 1);
        return ans;
    }
    
    public void helper(TreeNode root, int level) {
        if(root != null) {
            ans = Math.max(ans, level);
        }
        if(root.left != null) {
            helper(root.left, level+1);
        }
        if(root.right != null) {
            helper(root.right, level+1);
        }
    }

}
