package Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearchTree {

	private static BinaryTree root;
	private static BinaryTree prev;
	
	/**
	 * insert element to the BST tree
	 * @param root
	 * @param element
	 * @return
	 */
	public static BinaryTree insert(BinaryTree root, int element) {
		
		if(root == null) {
			root = new BinaryTree(element);
			return root;
		}
		//left sub tree insertion
		if(element < root.getData()) 
			root.setLeftChild(insert(root.getLeftChild(), element));
		
		//right sub tree insertion
		if(element > root.getData())
			root.setRightChild(insert(root.getRightChild(), element));
	
		return root;
	}
	
	/**
	 * find an element in BST
	 * @param root
	 * @param key
	 * @return
	 */
	public static boolean binarySearch(BinaryTree root, int key) { 
	
		if(root == null)
			return false;
		
		if(key == root.getData()) 
			return true;
		
		else if(key < root.getData())
			return binarySearch(root.getLeftChild(), key);
		else 
			return binarySearch(root.getRightChild(), key);
	}
	
	/**
	 * print the BST. using In-Order traversal, it prints in sorted order.  
	 * @param root
	 */
	private static void display(BinaryTree root) {
		
		if(root != null) {	
			display(root.getLeftChild());
			System.out.println(root.getData());
			display(root.getRightChild());
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private static boolean isBST(BinaryTree root, BinaryTree prev) {
		
		return isBST(root);
	}
	
	/**
	 * using in-order traversal we are checking the tree is a BST or not.
	 * @param root
	 * @return
	 */
	private static boolean isBST(BinaryTree root) {
		
		if(root != null ) {
			
			if(!isBST(root.getLeftChild()))
				return false;
			if(prev != null && root.getData() <= prev.getData())
				return false;
			prev = root;
			
			return isBST(root.getRightChild());
		}
		return true;
	}
	
	/**
	 * Main function.
	 * @param args
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		formTree();
		
		BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));

		do {
			System.out.println("Enter an element : ");
			int n = Integer.parseInt(bw.readLine());
			root = insert(root, n);
			System.out.println("want to add more ! Press(Y) : ");
		}while(bw.readLine().equalsIgnoreCase("y"));
		
		display(root);
		
		System.out.println("enter an element to be searched : ");
		int key = Integer.parseInt(bw.readLine());
		boolean b = binarySearch(root, key);
		System.out.println("Found (true/false) ? " + b);
		
		System.out.println("\n<--- *** Check a tree is BST *** ----->\n");
		System.out.println(isBST(root, null));
	
		
	}
	
	
	private static void formTree() {
		
		//the below one is not a binary search teee. 
		/**
		 * 
		 * 					10
		 * 				   /  \
		 * 				  3    15
		 * 				 / \
		 * 				1   9
		 * 
		 */
		
		BinaryTree tree = new BinaryTree(10);
		tree.setLeftChild(new BinaryTree(3));
		tree.setRightChild(new BinaryTree(15));
		tree.getLeftChild().setLeftChild(new BinaryTree(1));
		tree.getLeftChild().setRightChild(new BinaryTree(9));
		
		display(tree);
		System.out.println("Are you BST :" + isBST(tree, null));
	}

}
