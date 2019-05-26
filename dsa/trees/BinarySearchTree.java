package adee.samples.dsa.trees;

public class BinarySearchTree {

	private BinarySearchTree left;
	private BinarySearchTree right;
	private int data;

	public BinarySearchTree(int data) {
		this.data = data;
		this.left = this.right = null;
	}

	public BinarySearchTree getLeft() {
		return left;
	}

	public void setLeft(BinarySearchTree left) {
		this.left = left;
	}

	public BinarySearchTree getRight() {
		return right;
	}

	public void setRight(BinarySearchTree right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public static void main(String[] args) {
		int arr1[] = { 1, 5, 9, 13, 15, 17, 21, 25 };
		int arr2[] = { 1, 5, 9, 13, 15, 17, 21, 25 };
		int arr3[] = { 1, 5, 9, 13, 15, 21, 25 };
		BinarySearchTree node = Questions.sortedArrayToBST(arr1, 0, arr1.length - 1);
		BinarySearchTree node2 = Questions.arrayToBinaryTree(arr2, 0);
		BinarySearchTree node3 = Questions.sortedArrayToBST(arr3, 0, arr3.length - 1);
		Questions.preOrderTraversal(node);
		System.out.println();
		Questions.postOrderTraversal(node);
		System.out.println();
		Questions.inOrderTraversal(node);
		System.out.println();
		System.out.println(Questions.calculateHeight(node));
		System.out.println(Questions.calculateLeafNodes(node));
		System.out.println(Questions.calculateNonLeafNodes(node));
		levelOrderTraversal(node);
		zigZagLevelOrderTraversal(node);
		System.out.println("Node == Node2 " + Questions.identicalTrees(node, node2));
		System.out.println("Node == Node3 " + Questions.identicalTrees(node, node3));
		System.out.println(
				Questions.isTreeABST(node) + " & " + Questions.isTreeABST(node2) + " & " + Questions.isTreeABST(node3));
		Questions.flattenTreeToList(node);
		Questions.preOrderTraversal(node);
		System.out.println('\n' + "INORDER ");
		node = Questions.sortedArrayToBST(arr1, 0, arr1.length - 1);
		Questions.inOrderTraversal(node2);
		System.out.println();
		Questions.printBSTBetweenK1_K2(node, 4, 15);
		System.out.println(Questions.searchNode(node3, 5).getData());
		System.out.println(Questions.LCA_BST(node, 1, 17).getData());
		System.out.println(Questions.LCA_BT(node2, 13, 25).getData());
		Questions.printAncestorsBinaryTree(node2, 25);
		Questions.BinaryTreetoSumTree(node2);
		Questions.inOrderTraversal(node2);
		node2 = Questions.arrayToBinaryTree(arr2, 0);
		System.out.println();
		System.out.println(Questions.findLevelOfANodeInBT(node2, 25, 1));
		Questions.nodeToLeafPathBinaryTree(node2, new int[1000], 0);
	}

	private static void zigZagLevelOrderTraversal(BinarySearchTree node) {
		int h = Questions.calculateHeight(node);
		boolean leftToRight = false;
		for (int i = 0; i < h; i++) {
			Questions.zigZagLevelOrderTraversal(node, i, leftToRight);
			leftToRight = !leftToRight;
			System.out.println();
		}

	}

	private static void levelOrderTraversal(BinarySearchTree node) {
		int h = Questions.calculateHeight(node);
		for (int i = 0; i < h; i++) {
			Questions.levelOrderTraversal(node, i);
			System.out.println();
		}
	}
}
