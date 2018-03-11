package AdvancedProblem;

public class LinkedList {

	int data;
	LinkedList link;
	
	public LinkedList() {
		
	}
	
	public LinkedList(int data) {
		this.data = data;
		this.link = null;
	}

	@Override
	public String toString() {
		return "LinkedList [data=" + data + ", link=" + link + "]";
	}
}
