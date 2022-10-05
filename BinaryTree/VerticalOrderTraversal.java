package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VerticalOrderTraversal {
	
	class Pair {
		TreeNode node;
		int position;
		public Pair(TreeNode node, int position) {
			this.node = node;
			this.position = position;
		}
	}
	
	public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int minCol = 0;
        int maxCol = 0;
        q.add(new Pair(root, 0));
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Pair curr = q.poll();
                TreeNode node = curr.node;
                int position = curr.position;
                minCol = Math.min(minCol, position);
                maxCol = Math.max(maxCol, position);
                if(node.left != null) q.add(new Pair(node.left, position - 1));
                if(node.right != null) q.add(new Pair(node.right, position + 1));
                if(!map.containsKey(position)) map.put(position, new ArrayList<>());
                map.get(position).add(node.val);
            }
        }
        for(int i = minCol; i <= maxCol; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }

}
