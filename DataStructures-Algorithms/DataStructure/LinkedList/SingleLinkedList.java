package LinkedList;


//node class
class Node {

	private int n;

	Node next;

	public Node() {

	}

	public Node(int n) {
		super();
		this.n = n;
	}


	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}


}


public class SingleLinkedList {

	static Node head;
	static Node current;

	private static void add(final int n) {

		Node node = new Node(n);
		if(head != null) {

			current.next = node;
			current = node;
			
		}else {
			head = node;
			current = node;	
		}

	}

	private static void delete(final int n) {

		if(head == null ) {
			
			System.out.println("node is empty");
		}else {
			
			
			Node prev = null;
			Node temp = head;
			if(temp != null && temp.getN() == n ) {
				System.out.println("deleted " + temp.getN());
				head = temp.next;
				return;
			}
			while(temp != null && temp.getN() != n ) {
				
				prev = temp;
				temp = temp.next;
			}
			if(temp == null ) {
				System.out.println("No node found in the present link list");
				return;
			}else {
				
				System.out.println("deleted " + temp.getN());
				prev.next = temp.next;
				
			}
			
		}
	}

	private static void display() {

		for(Node temp = head; temp != null; temp = temp.next) {
			System.out.println(temp.getN());
		}
	}
	
	private static void reverse() {
		
		if(head == null ) {
			System.out.println("no node is available\n already reversed");
		}
		Node prev = null;
		Node current = head;
		Node next = null;
		
		while(current != null ) {
			
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

	public static void main(String[] args) {
		add(5);
		add(6);
		add(8);
		add(1);
		display();
		delete(4);
		display();
		delete(8);
		display();
		delete(5);
		display();
		add(5);
		add(6);
		add(8);
		add(1);
		System.out.println("display before reverse");
		display();
		System.out.println("reverse");
		reverse();
		display();
	}

}
