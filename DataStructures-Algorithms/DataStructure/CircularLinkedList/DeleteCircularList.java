package CircularLinkedList;

public class DeleteCircularList {

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

	private static void deleteAtEnd() {
		
		if(head == null) {
			System.out.println("no node");
		}else {
			CircularNode curr = head;
			while(curr.link.link != head)curr = curr.link;
			System.out.println("\ndeleted element is : " + curr.link.data);
			curr.link = head;
		}
	}
	
	private static void deleteAtBeginig() {
		
		if(head == null) {
			System.out.println("no node");
		}else {
			CircularNode curr = head.link;
			CircularNode temp = curr;
			System.out.println("\ndeleted element is : " + head.data);
			while(temp.link != head) temp = temp.link;
			temp.link = curr;
			head = curr;
		}
	}
	
	private static void delete(int data) {
		
		if(head == null) {
			System.out.println("no node");
		}else {
			CircularNode curr = head;
			CircularNode temp = curr.link;
			
			//if the node is the first node
			if(curr.data == data && curr == head) {
				deleteAtBeginig();
			}else {
			
				while(temp.data != data) {
					curr = temp;
					temp = temp.link;
				}
				System.out.println("deleted data :" + data);
				curr.link  =temp.link;
				
			}
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

		for(int i = 10; i <= 25; i++) {
			insert(i);
		}

		System.out.println("\n\n<--- display all the elements --- > ");
		display();
		
		deleteAtEnd();
		deleteAtEnd();
		deleteAtEnd();
		
		System.out.println("\n\n<--- display all the elements --- > ");
		display();
		
		System.out.println("\n\n<-- deleted the link at begginnig-->");
		deleteAtBeginig();
		deleteAtBeginig();
		deleteAtBeginig();
		
		System.out.println("\n\n<--- display all the elements --- > ");
		display();
		
		System.out.println("delete the node with the specified data ");
		delete(19);
		delete(13);
		
		System.out.println("\n\n<--- display all the elements --- > ");
		display();
	}

}
