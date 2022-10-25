package BST;

public class ValidateBST {
	
    private TreeNode prev;
    
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }
    
    public boolean inorder(TreeNode root) {
        if(root == null) return true;
        if(!inorder(root.left)) return false;
        if(prev != null && root.val <= prev.val) return false;
        prev = root;
        return inorder(root.right);
    }

}
