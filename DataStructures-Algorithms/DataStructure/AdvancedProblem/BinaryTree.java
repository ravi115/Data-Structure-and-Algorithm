package AdvancedProblem;

/**
 * Represents Structure  of Binary Tree.
 * 
 * @author raviranjan
 *
 */
public class BinaryTree {

	private int data;
	private BinaryTree leftChild;
	private BinaryTree rightChild;
	
	public BinaryTree() {}
	
	public BinaryTree(int data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinaryTree getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryTree leftChild) {
		this.leftChild = leftChild;
	}

	public BinaryTree getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryTree rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return "BinaryTree [data=" + data + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
	}
}
