package Trees;

public class TreeTraversalRecursivesly {

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
	
	/** Time complexity : O(n), Space Complexity: O(n)
	 * Rule :  VLR
	 * @param root
	 */
	private static void preOrder(BinaryTree root) {
			
		if(root != null) {
			System.out.print(root.getData() + " ");
			preOrder(root.getLeftChild());
			preOrder(root.getRightChild());
		}
	}
	
	/** Time complexity : O(n), Space Complexity: O(n)
	 * Rule : LRV
	 * @param root
	 */
	private static void postOrder(BinaryTree root) {
	
		if(root != null) {
			
			postOrder(root.getLeftChild());
			postOrder(root.getRightChild());
			System.out.print(root.getData() + " ");
		}
	}
	
	/** Time complexity : O(n), Space Complexity: O(n)
	 * Rule : LVR
	 * @param tree
	 */
	private static void inorder(BinaryTree root) {
		
		if(root != null) {
			
			inorder(root.getLeftChild());
			System.out.print(root.getData() + " ");
			inorder(root.getRightChild());
		}
	}
	
	public static void main(String[] args) {

		insertTree();

		System.out.println("\n\n<------ *** Pre-Order Tree Traversal *** --------->\n");
		preOrder(root);
		
		System.out.println("\n\n<------ *** Post-Order Tree Traversal *** --------->\n");
		postOrder(root);
		
		System.out.println("\n\n<------ *** In-Order Tree Traversal *** --------->\n");
		inorder(root);
	}

}
