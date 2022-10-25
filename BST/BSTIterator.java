package BST;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
	
	private List<Integer> bst = new ArrayList<Integer>();
    private int index;
    
    private void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        this.inorder(root.left);
        bst.add(root.val);
        this.inorder(root.right);
    }

    public BSTIterator(TreeNode root) {
        this.bst = new ArrayList<Integer>();
        this.index = -1;
        this.inorder(root);
    }
    
    public int next() {
        index = index + 1;
        return bst.get(index);
        
    }
    
    public boolean hasNext() {
        return index + 1 < bst.size();
    }

}
