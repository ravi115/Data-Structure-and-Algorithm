package LinkedList;

class List {

	int data;
	List link;

	//default constructor
	List() {

	}

	//create a complete node
	List(int data) {

		this.data  = data;
	}

	//display Object
	@Override
	public String toString() {
		return "List [data=" + data + ", link=" + link + "]";
	}
}

/**
 * This class reverse the list using 
 * 1. iterative ways
 * 2. recursion ways.
 * 
 * @author ravi ranjan kumar
 *
 */

public class ReverseList {

	private static List head;
	private static List current;

	/**
	 * List creation
	 * 
	 * @param n
	 */
	private static void add(int n) {

		List temp = new List(n);

		if(null == head) {
			head = temp;
			current = temp;
		}else {
			current.link = temp;
			current = temp;
		}
	}

	/**
	 * display List
	 */
	private static void display(List head) {

		if(null == head) {
			System.out.println("List is Empty");
		}
		int count = 0;
		for(List temp = head; temp != null; temp = temp.link) {

			count++;
			System.out.print(temp.data + " ");
		}
		System.out.println("\ncount : " + count);
	}

	/**
	 * reverse List using iterative method.
	 */
	private static List iterativeReverse() {

		List curr = head, next = head;
		List temp = null;

		// if list is empty
		if(head == null) {
			System.out.println("List is not available!");
		}
		//if list has only one node.
		else if(head.link == null) {
			temp = head;
			System.out.println("only one list is there!");
		}else {

			while(curr != null ) {

				//move current link to next node
				next = curr.link;

				//delete reference of current link to another link.
				curr.link = temp;

				temp = curr;

				curr = next;
			}
		}
		return temp;
	}

	/**
	 * Rules : -
	 * 
	 * 1. divide the List into two parts. (1. first Node and Rest of the Node(except first)
	 * 2. recursively call reverse for the rest of the node.
	 * 3. Link rest to first
	 * 4. FIX Header.
	 * 
	 * @return
	 */
	private static List recursivelyReverse(List first) {

		if(first == null) return null;
		if(first.link == null) return first;

		List rest = recursivelyReverse(first.link);
		first.link.link = first;
		first.link = null;
		return rest;
	}

	public static void main(String[] args) {

		//add 10 List
		for(int i = 10; i <= 20; i++) {
			add(i);
		}

		//display all List
		display(head);

		head = iterativeReverse();
		System.out.println("\n\n<--- ** reverse is done using iterative ways** --->");
		display(head);


		head = recursivelyReverse(head);
		System.out.println("\n\n<--- ** reverse is done using recursive ways** --->");
		display(head);

	}
}
