package CircularLinkedList;

public class InsertCircularNode {

	private static CircularNode head;

	private static void insert(int data) {

		CircularNode temp = new CircularNode(data);

		if(head == null) {
			head = temp;
			head.link = head;
		}else {
			CircularNode curr = head;
			while(curr.link != head)curr = curr.link;
			temp.link = curr.link;
			curr.link = temp;
		}
	}

	private static void insertAtBegginnig(int data) {

		CircularNode temp = new CircularNode(data);

		if(head == null) {
			head = temp;
			head.link = head;
		}else {
			CircularNode curr = head;
			while(curr.link != head)curr = curr.link;
			curr.link = temp;
			temp.link = head;
			head = temp; //make new node temp as head node

		}
	}

	private static void insertAtMiddle(int data, int position) {

		CircularNode temp = new CircularNode(data);

		if(head == null) {
			head = temp;
			head.link = head;
		}else {
			CircularNode curr = head;
			while(position > 0) {
				curr = curr.link;
				position--;
			}
			temp.link = curr.link;
			curr.link = temp;
		}
	}

	private static void insertAtEnd(int data) {

		CircularNode temp = new CircularNode(data);

		if(head == null) {
			head = temp;
			head.link = head;
		}else {
			CircularNode curr = head;
			while(curr.link != head)curr = curr.link;
			temp.link = curr.link;
			curr.link = temp;

		}
	}

	private static void display() {

		CircularNode temp = head;
		if(head == null) {
			System.out.println("no node found..");
		}else {
			do {
				System.out.print(temp.data + " " );
				temp = temp.link;
			}while(temp != head);
		}
	}

	public static void main(String[] args) {

		System.out.println("--- insert node in circular list ----");
		for(int i = 100 ; i <= 115; i++ ) {
			insert(i);
		}
		System.out.println("\n\n<--- display all the node --->");
		display();

		System.out.println("\n\n<--insert at before head node --- >");
		insertAtBegginnig(12);
		insertAtBegginnig(11);

		System.out.println("\n\n<--- display all the node after inserting at begginig--->");
		display();

		System.out.println("\n\n<-- insert at the end of node -->");
		insertAtEnd(69);
		insertAtEnd(55);

		System.out.println("\n\n<--- display all the node after inserting at begginig--->");
		display();
		
		System.out.println("\n\n<--- insert at middle -- >");
		insertAtMiddle(222, 5);
		insertAtMiddle(333, 7);
		insertAtMiddle(444, 21);
		System.out.println("\n\n<--- display all the node after inserting at begginig--->");
		display();
		
	}

}
