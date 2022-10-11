package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidth {
	
	class Pair {
		TreeNode node;
		int position;
		Pair(TreeNode node, int position) {
			this.node = node;
			this.position = position;
		}
	}
	
	public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        if(root == null) return ans;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()) {
            int size = q.size();
            int firstPos = 0;
            int lastPos = 0;
            for(int i = 0; i < size; i++) {
                Pair curr = q.poll();
                TreeNode node = curr.node;
                int position = curr.position;
                if(i == 0) firstPos = position;
                if(i == size - 1) lastPos = position;
                if(node.left != null) q.add(new Pair(node.left, position * 2));
                if(node.right != null) q.add(new Pair(node.right, position * 2 + 1));
            }
            ans = Math.max(ans, lastPos - firstPos + 1);
        }
        return ans;
    }

}
