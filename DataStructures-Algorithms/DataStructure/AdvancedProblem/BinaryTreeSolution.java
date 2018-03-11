package AdvancedProblem;

import Trees.BinaryTree;

public class BinaryTreeSolution {

	private static BinaryTree root;

	private static void insert() {

		//fill root
		root = new BinaryTree(10);
		//fill left and right of root
		root.setLeftChild(new BinaryTree(20));
		root.setRightChild(new BinaryTree(30));
		//fill left and right of first root's left child
		root.getLeftChild().setLeftChild(new BinaryTree(40));
		root.getLeftChild().setRightChild(new BinaryTree(50));
		//fill left and right of first root's right child
		root.getRightChild().setLeftChild(new BinaryTree(60));
		root.getRightChild().setRightChild(new BinaryTree(70));

		root.getLeftChild().getLeftChild().setLeftChild(new BinaryTree(90));
		root.getLeftChild().getRightChild().setRightChild(new BinaryTree(200));

		root.getRightChild().getLeftChild().setRightChild(new BinaryTree(80));
	}


	private static int findMaxElement(BinaryTree root) {

		int element = Integer.MIN_VALUE;

		if(root != null) {
			int maxLeft = findMaxElement(root.getLeftChild());
			int maxRight = findMaxElement(root.getRightChild());

			element = (maxLeft > maxRight) ? maxLeft : maxRight;
			element = (element > root.getData()) ? element : root.getData();
		}

		return element;
	}

	public static void main(String[] args) {

		insert();
		/**
		 * we can use these logics respectively.
		 * 
		 * 1. find the element from left subtree and from right subtree and then compare each other then root
		 * 3. use level order traversal 
		 */
		int n = findMaxElement(root);
		System.out.println("The Maximum Element : " + n);

	}


}

