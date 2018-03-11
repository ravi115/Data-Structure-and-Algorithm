package DoublyLinkedList;

public class DeleteDoublyList {

	
	private static DoublyLinkedList head;
	private static DoublyLinkedList current;

	private static void insertNode(int data) {

		DoublyLinkedList temp = new DoublyLinkedList(data);

		if(head == null) {
			current = temp;
			head = current;
		}else {
			current.right = temp;
			temp.left = current;
			current = temp;
		}
	}
	
	
	private static void deleteFirstNode() {
		
		if(head == null) {
			System.out.println("no node to delete");
		}else {
			
			System.out.println("deleteing first node  : " + head.data);
			head = head.right;
		}
	}
	
	private static void deleteEndNode() {
		
		DoublyLinkedList temp = head;
		if(head == null) {
			System.out.println("no node..!!");
		}else {
			while(temp.right != null) temp = temp.right;
			System.out.println("deleted Node is : " + temp.data);
			temp.left.right = null;
		}
	}
	
	private static void deleteNode(int data) {
		
		DoublyLinkedList temp = head;
		
		if(head == null) {
			System.out.println("no node..");
		}else {
			while(temp.data != data) temp = temp.right;
			System.out.println("deleted : " + temp.data);
			temp.left.right = temp.right;
		}
	}
	
	private static void deleteNodeAtPosition(int position) {
		
		DoublyLinkedList temp = head;
		
		if(head == null) {
			System.out.println("no node to diaplay");
		}else {
			
			while(position > 0) {
				temp = temp.right;
				position--;
			}
			System.out.println("deleting the node : " + temp.data);
			temp.left.right = temp.right;
		}
	}
	
	private static void displayFromLeftToRight(DoublyLinkedList head) {

		DoublyLinkedList temp = head;
		if(temp == null) {
			System.out.println("No List is to display");
		}else {

			while(temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.right;
			}
		}
	}
	
	public static void main(String[] args) {
		
		for(int i = 55; i<= 65; i++ ) {
			
			insertNode(i);
		}
		
		System.out.println("............display the inserted List.............");
		displayFromLeftToRight(head);
		
		System.out.println("\n\n<-------------- *** delete the first node *** ----------->");
		deleteFirstNode();
		
		System.out.println("\n\n............display the inserted List.............");
		displayFromLeftToRight(head);
		
		System.out.println("\n\n<--- *** delete the last node *** ------->");
		deleteEndNode();
		
		System.out.println("\n\n............display the inserted List.............");
		displayFromLeftToRight(head);
		
		System.out.println("\n\ndeleting node with specified value");
		deleteNode(58);
		
		System.out.println("\n\n............display the inserted List.............");
		displayFromLeftToRight(head);
		
		
		System.out.println("\n\n<--- deleteting node at specifed position....");
		deleteNodeAtPosition(3);
		
		System.out.println("\n\n............display the inserted List.............");
		displayFromLeftToRight(head);
		
		
	}
}
