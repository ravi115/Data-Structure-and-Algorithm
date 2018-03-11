package Trees;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversalIteratively {

	private static BinaryTree root;

	private static void insertTree() {

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

	/**
	 * 
	 * @param root
	 * @return
	 */
	private static List<Integer> preOrder(BinaryTree root) {

		List<Integer> result = new ArrayList<>();

		if(root == null)
			return result;
		Stack<BinaryTree> stack  =new Stack<>();
		//add the tree into stack
		stack.push(root);

		while(!stack.isEmpty()) {

			BinaryTree temp = stack.pop();
			result.add(temp.getData());

			if(temp.getRightChild() != null) {
				stack.push(temp.getRightChild());
			}
			if(temp.getLeftChild() != null) {
				stack.push(temp.getLeftChild());
			}
		}
		return result;
	}

	/**
	 * 
	 * @param root
	 * @return
	 */
	private static List<Integer> inorder(BinaryTree root) {

		List<Integer> list = new ArrayList<>();

		Stack<BinaryTree> stack = new Stack<>();
		BinaryTree currentNode = root;

		boolean bIsDone = false;

		while(!bIsDone) {

			if(currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.getLeftChild();
			}else {
				if(stack.isEmpty()) {
					bIsDone = true;
				}else {
					currentNode = stack.pop();
					list.add(currentNode.getData());
					currentNode  = currentNode.getRightChild();
				}
			}
		}

		return list;
	}

	/**
	 * 
	 * @param root
	 * @return
	 */
	private static List<Integer> postOrder(BinaryTree root) {

		List<Integer> list = new ArrayList<>();
		Stack<BinaryTree> stack = new Stack<>();

		if(root == null) {
			return list;
		}
		stack.push(root);
		while(!stack.isEmpty()) {

			if(root != null) {
				stack.push(root.getLeftChild());
				stack.push(root.getRightChild());
				root = root.getLeftChild();
				list.add(root.getData());
			}

		}

		return list;
	}
	/**
	 * 
	 * @param root
	 */
	private static void diaplay(List<Integer> root) {

		for(int n : root) {
			System.out.print(n + " ");
		}
	}
	public static void main(String[] args) throws IOException {

		insertTree();

		List<Integer> list = preOrder(root);
		System.out.println("\n\n<-------*** pre order *** ------->\n");
		diaplay(list);

		List<Integer> list1 = inorder(root);
		System.out.println("\n\n<-------*** in order *** ------->\n");
		diaplay(list1);

		List<Integer> list2 = postOrder(root);
		System.out.println("\n\n<-------*** post order *** ------->\n");
		diaplay(list2);

	}

}
