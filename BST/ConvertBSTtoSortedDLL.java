package BST;

import java.util.LinkedList;
import java.util.List;

public class ConvertBSTtoSortedDLL {
	
	public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null) return root;
        List<TreeNode> list = new LinkedList<>();
        inorder(root, list);
        if(list.size() == 1) {
            root.left = root;
            root.right = root;
            return root;
        }
        for(int i = 0; i < list.size(); i++) {
        	TreeNode curr = list.get(i);
            if(i == 0) {
                curr.left = list.get(list.size() - 1);
                curr.right = list.get(i + 1);
            }else if(i == list.size() - 1) {
                curr.left = list.get(i - 1);
                curr.right = list.get(0);
            }else {
                curr.left = list.get(i - 1);
                curr.right = list.get(i + 1);
            }
        }
        return list.get(0);
    }
    
    public void inorder(TreeNode root, List<TreeNode> list) {
        if(root == null) return;
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }

}
