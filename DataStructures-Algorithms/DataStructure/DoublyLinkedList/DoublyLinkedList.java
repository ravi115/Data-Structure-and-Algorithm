package DoublyLinkedList;

public class DoublyLinkedList {

	int data;
	DoublyLinkedList left;
	DoublyLinkedList right;
	
	public DoublyLinkedList() {}
	
	public DoublyLinkedList(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {
		return "DoublyLinkedList [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
	
}
