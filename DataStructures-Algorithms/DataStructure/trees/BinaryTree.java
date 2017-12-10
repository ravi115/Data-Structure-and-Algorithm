package trees;

class Tree {
	
	Integer element;
	
	Tree leftChild;
	Tree rightChild;
	
	public Tree() {
		
	}
	
	/*
	 * whenever a tree level is created means 
	 * a new node is created, so at that time its left child
	 * as well right child will be null
	 * 
	 */
	public Tree(final Integer element) {
		
		this.element = element;
		leftChild = rightChild = null;
	}
	
}


/**
 * 
 * This class will introduce how to create a binary tree in java.
 * 
 * @author raviranjan
 *
 */
public class BinaryTree {

	//create a root node
	static Tree root;
	
	private static void createBinaryTree(final Integer element) {
		
		if(root == null ) {
			root = new Tree(element);
			
		/*	diagram 
				root (element)
				/  \
	    leftChild   rightChild
		(null)      (null)		
				
		 */		
		}else {
			
			Tree tree = new Tree(element);
			if(root.leftChild == null ) {
				root.leftChild = tree;
			}else {
				root.rightChild = tree;
			}
			
			/*
			 
						  	root (element)
						  	/  \
				   leftChild    rightChild
				   		/ \
				leftChild  rightChild
			
			 */
		}
		
		
		
	}
	
	public static void main(String[] args) {
		
		createBinaryTree(5);
	}

}
