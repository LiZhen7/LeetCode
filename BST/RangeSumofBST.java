package BST;

public class RangeSumofBST {
	
	public int rangeSumBST(TreeNode root, int low, int high) {
        int ans = 0;
        helper(root, low, high, ans);
        return ans;
    }
    
    public void helper(TreeNode root, int low, int high, int ans) {
        if(root == null) return;
        if(root.val >= low && root.val <= high) {
            ans += root.val;
        }
        if(root.val <= low) {
            helper(root.right, low, high, ans);
        }else if(root.val >= high) {
            helper(root.left, low, high, ans);
        }else {
            helper(root.left, low, high, ans);
            helper(root.right, low, high, ans);
        }
    }

}
