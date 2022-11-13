package Midterm;

public class Q4 {
	
	class Node {
	    public int val;
	    public Node next;
	    public Node() {}
	    public Node(int _val) { val = _val; }
	    public Node(int _val, Node _next) { val = _val; next = _next; }
	}
	
	public Node insert(Node head, int value) {
		if(head == null) return new Node(value);
		Node prev = null;
		Node curr = head;
		while(curr != null && curr.val < value) {
			prev = curr;
			curr = curr.next;
		}
		Node node = new Node(value);
		node.next = curr;
		if(prev != null) prev.next = node;
		
		return prev == null ? node : head;
	}
	//Time Complexity:O(n)

}
