package DoublyLinkedList;

public class InsertDoublyList {

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

	private static void insertAtBegnnig(int data) {

		DoublyLinkedList temp = new DoublyLinkedList(data);
		DoublyLinkedList currentTemp = head;
		if(head == null) {
			head = temp;
		}else {
			
			temp.right = currentTemp;
			currentTemp.left = temp;
			head = temp;
		}
	}

	private static void insertAtEnding(int data) {

		DoublyLinkedList temp = new DoublyLinkedList(data);
		DoublyLinkedList currentTemp = head;
		if(head == null ) {
			head = temp;
		}else {
			while(currentTemp.right != null)currentTemp = currentTemp.right;
			currentTemp.right = temp;
			temp.left = currentTemp;
		}
	}

	private static void insertAtMiddle(int data, int position) {

		DoublyLinkedList temp = new DoublyLinkedList(data);
		DoublyLinkedList currentTemp = head;
		if(head == null) {
			head = temp;
		}else {
			
			while(position > 1) {
				position--;
				currentTemp = currentTemp.right;
			}
			
			temp.right = currentTemp.right;
			currentTemp.right.left = temp;
			currentTemp.right = temp;
			temp.left = currentTemp;
		}
	}

	private static void displayFromLeftToRight(DoublyLinkedList head) {

		DoublyLinkedList temp = head;
		if(head == null) {
			System.out.println("No List is to display");
		}else {

			while(temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.right;
			}
		}
	}
	private static void displayFromRightToLeft(DoublyLinkedList head) {

		DoublyLinkedList temp = head;
		if(head == null) {
			System.out.println("No List is to display");
		}else {

			while(temp.right != null) {
				temp = temp.right;
			}

			while(temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.left;
			}

		}

	}


	public static void main(String[] args) {

		for(int i = 10; i <= 20; i++ ) {

			insertNode(i);
		}
		
		insertAtEnding(55);
		
		insertAtEnding(155);
		
		insertAtMiddle(30,2);

		insertAtMiddle(70,3);
		
		insertAtBegnnig(169);
		
		System.out.println("<--- *** insertion of node is done *** ---------->");

		System.out.println("\n\n<--- display node from left to right --- >");
		
		displayFromLeftToRight(head);
		
		System.out.println("\n\n<--- display node from right to left --- >");
		
		displayFromRightToLeft(head);
	}
}
