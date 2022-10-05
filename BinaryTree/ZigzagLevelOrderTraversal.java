package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrderTraversal {
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> subList = new LinkedList<>();
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                if(ans.size() % 2 == 0) {
                    subList.add(curr.val);
                }else {
                    subList.addFirst(curr.val);
                }
            }
            ans.add(subList);
        }
        return ans;
    }

}
