package BST;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST {
	
	public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        sb.append(root.val);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr.left != null) {
                q.add(curr.left);
                sb.append(",");
                sb.append(curr.left.val);
            }else {
                sb.append(",");
                sb.append("n");
            }
            if(curr.right != null) {
                q.add(curr.right);
                sb.append(",");
                sb.append(curr.right.val);
            }else {
                sb.append(",");
                sb.append("n");
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] s = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(s[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int index = 1;
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(s[index].equals("n")) {
                curr.left = null;
            }else {
                TreeNode left = new TreeNode(Integer.valueOf(s[index]));
                curr.left = left;
                q.add(left);
            }
            index++;
            if(s[index].equals("n")) {
                curr.right = null;
            }else {
                TreeNode right = new TreeNode(Integer.valueOf(s[index]));
                curr.right = right;
                q.add(right);
            }
            index++;
        }
        return root;
    }

}
