package BST;

import java.util.LinkedList;
import java.util.List;

public class RecoverBST {
	
	public void recoverTree(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        inorder(root, list);
        TreeNode node1 = null;
        TreeNode node2 = null;
        for(int i = 1; i < list.size(); i++) {
            if(list.get(i).val <= list.get(i - 1).val) {
                node1 = list.get(i);
                if(node2 == null) {
                    node2 = list.get(i - 1);
                }
            }
        }
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }
    
    public void inorder(TreeNode root, List<TreeNode> list) {
        if(root == null) return;
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }

}
