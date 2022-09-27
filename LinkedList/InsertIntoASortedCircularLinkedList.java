package LinkedList;

public class InsertIntoASortedCircularLinkedList {

	class Node {
	    public int val;
	    public Node next;
	    public Node() {}
	    public Node(int _val) { val = _val; }
	    public Node(int _val, Node _next) { val = _val; next = _next; }
	}
	
	public Node insert(Node head, int insertVal) {
        if(head == null) {
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }
        
        Node min = head;
        Node max = head;
        Node curr = head;
        do{
            if(curr.val > curr.next.val) {
                min = curr.next;
                max = curr;
                break;
            }
            max = curr;
            curr = curr.next;
        }while(curr != head);
        
        curr = min;
        boolean isInsert = false;
        while(curr.next != min) {
            if(curr.val <= insertVal && curr.next.val >= insertVal) {
                Node newNode = new Node(insertVal, curr.next);
                curr.next = newNode;
                isInsert = true;
                break;
            }
            curr = curr.next;
        }
        
        if(!isInsert) {
            Node newNode = new Node(insertVal);
            max.next = newNode;
            newNode.next = min;
        }
        return head;
    }
}
