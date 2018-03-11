package CircularLinkedList;

public class CircularNode {

	int data;
	CircularNode link;
	
	public CircularNode() {
		
	}
	
	public CircularNode(int data) {
		this.data = data;
		this.link = null;
	}

	@Override
	public String toString() {
		return "CircularNode [data=" + data + ", link=" + link + "]";
	}
}
