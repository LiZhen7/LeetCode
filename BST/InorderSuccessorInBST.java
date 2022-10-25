package BST;

public class InorderSuccessorInBST {
	
	private TreeNode prev;
    private TreeNode ans;
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        this.ans = null;
        inorder(root, p);
        return ans;
    }
    
    public void inorder(TreeNode root, TreeNode p) {
        if(root == null) return;
        inorder(root.left, p);
        if(prev == p && ans == null) {
            ans = root;
            return;
        }
        this.prev = root;
        inorder(root.right, p);
    }

}
