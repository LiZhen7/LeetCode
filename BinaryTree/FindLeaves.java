package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FindLeaves {
	
	public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<TreeNode, Integer> inDegree = new HashMap<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> topo = new LinkedList<>();
        
        bfs(root, inDegree, parent, topo);
        
        while(!topo.isEmpty()) {
            int size = topo.size();
            List<Integer> sub = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode curr = topo.poll();
                sub.add(curr.val);
                if(parent.containsKey(curr)) {
                    TreeNode parentNode = parent.get(curr);
                    inDegree.put(parentNode, inDegree.get(parentNode) - 1);
                    if(inDegree.get(parentNode) == 0) topo.add(parentNode);
                }
            }
            ans.add(sub);
        }
        return ans;
    }
    
    public void bfs(TreeNode root, Map<TreeNode, Integer> inDegree, Map<TreeNode, TreeNode> parent, Queue<TreeNode> topo) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if(curr.left == null && curr.right == null) {
                    topo.add(curr);
                }
                if(curr.left != null) {
                    q.add(curr.left);
                    parent.put(curr.left, curr);
                    inDegree.put(curr, inDegree.getOrDefault(curr, 0) + 1);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                    parent.put(curr.right, curr);
                    inDegree.put(curr, inDegree.getOrDefault(curr, 0) + 1);
                }
            }
        }
    }

}
