package adee.samples.dsa.trees;

public class Questions {

	public static BinarySearchTree sortedArrayToBST(int arr[], int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		BinarySearchTree root = new BinarySearchTree(arr[mid]);
		root.setLeft(sortedArrayToBST(arr, start, mid - 1));
		root.setRight(sortedArrayToBST(arr, mid + 1, end));
		return root;
	}

	public static BinarySearchTree arrayToBinaryTree(int arr[], int i) {
		BinarySearchTree temp = null;
		if (i < arr.length) {
			temp = new BinarySearchTree(arr[i]);
			temp.setLeft(arrayToBinaryTree(arr, 2 * i + 1));
			temp.setRight(arrayToBinaryTree(arr, 2 * i + 2));
		}
		return temp;
	}

	public static void preOrderTraversal(BinarySearchTree node) {
		if (node == null) {
			return;
		}
		System.out.print(node.getData() + " - ");
		preOrderTraversal(node.getLeft());
		preOrderTraversal(node.getRight());
	}

	public static void postOrderTraversal(BinarySearchTree node) {
		if (node == null) {
			return;
		}
		postOrderTraversal(node.getLeft());
		postOrderTraversal(node.getRight());
		System.out.print(node.getData() + " - ");
	}

	public static void inOrderTraversal(BinarySearchTree node) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.getLeft());
		System.out.print(node.getData() + " - ");
		inOrderTraversal(node.getRight());
	}

	public static void levelOrderTraversal(BinarySearchTree node, int height) {
		if (node == null) {
			return;
		}
		if (height == 0) {
			System.out.print(node.getData() + " - ");
		} else if (height > 0) {
			levelOrderTraversal(node.getLeft(), height - 1);
			levelOrderTraversal(node.getRight(), height - 1);
		}
	}

	public static void zigZagLevelOrderTraversal(BinarySearchTree node, int height, boolean leftToRight) {
		if (node == null) {
			return;
		}
		if (height == 0) {
			System.out.print(node.getData() + " - ");
		} else if (height > 0) {
			if (leftToRight) {
				zigZagLevelOrderTraversal(node.getLeft(), height - 1, leftToRight);
				zigZagLevelOrderTraversal(node.getRight(), height - 1, leftToRight);
			} else {
				zigZagLevelOrderTraversal(node.getRight(), height - 1, leftToRight);
				zigZagLevelOrderTraversal(node.getLeft(), height - 1, leftToRight);
			}
		}
	}

	public static int calculateHeight(BinarySearchTree node) {
		if (node == null) {
			return 0;
		}
		return Integer.max(calculateHeight(node.getLeft()), calculateHeight(node.getRight())) + 1;
	}

	public static int calculateLeafNodes(BinarySearchTree node) {
		if (node == null) {
			return 0;
		}
		if (node.getLeft() == null && node.getRight() == null) {
			return 1;
		}
		return calculateLeafNodes(node.getLeft()) + calculateLeafNodes(node.getRight());
	}

	public static int calculateNonLeafNodes(BinarySearchTree node) {
		if (node == null || (node.getLeft() == null && node.getRight() == null)) {
			return 0;
		}
		return 1 + calculateNonLeafNodes(node.getLeft()) + calculateNonLeafNodes(node.getRight());
	}

	public static boolean identicalTrees(BinarySearchTree node1, BinarySearchTree node2) {
		if (node1 == null && node2 == null) {
			return true;
		} else if (node1 != null && node2 != null) {
			return (node1.getData() == node2.getData() && identicalTrees(node1.getLeft(), node2.getLeft())
					&& identicalTrees(node1.getRight(), node2.getRight()));
		} else {
			return false;
		}
	}

	public static boolean isTreeABST(BinarySearchTree node) {
		if (node == null) {
			return true;
		} else if (node.getLeft() != null && node.getData() < minValueOfBST(node.getLeft())) {
			return false;
		} else if (node.getRight() != null && node.getData() > maxValueOfBST(node.getRight())) {
			return false;
		} else {
			return isTreeABST(node.getLeft()) || isTreeABST(node.getRight());
		}
	}

	public static void flattenTreeToList(BinarySearchTree node) {
		if (node == null) {
			return;
		}
		BinarySearchTree left = node.getLeft();
		BinarySearchTree right = node.getRight();
		node.setLeft(null);
		flattenTreeToList(left);
		flattenTreeToList(right);
		node.setRight(left);
		BinarySearchTree current = node;
		while (current.getRight() != null) {
			current = current.getRight();
		}
		current.setRight(right);
	}

	public static void printBSTBetweenK1_K2(BinarySearchTree node, int k1, int k2) {
		if (node == null) {
			return;
		}
		if (k1 < node.getData()) {
			printBSTBetweenK1_K2(node.getLeft(), k1, k2);
		}
		if (node.getData() <= k2 && node.getData() >= k1) {
			System.out.println(k2 + " > " + node.getData() + " > " + k1);
		}
		if (k2 > node.getData()) {
			printBSTBetweenK1_K2(node.getRight(), k1, k2);
		}
	}

	public static BinarySearchTree searchNode(BinarySearchTree node, int key) {
		if (node == null || node.getData() == key) {
			return node;
		}
		if (key < node.getData()) {
			return searchNode(node.getLeft(), key);
		} else {
			return searchNode(node.getRight(), key);
		}
	}

	public static BinarySearchTree LCA_BST(BinarySearchTree node, int k1, int k2) {
		if (node == null) {
			return null;
		}
		if (node.getData() > k1 && node.getData() > k2) {
			return LCA_BST(node.getLeft(), k1, k2);
		}
		if (node.getData() < k1 && node.getData() < k2) {
			return LCA_BST(node.getRight(), k1, k2);
		}
		return node;
	}

	public static BinarySearchTree LCA_BT(BinarySearchTree node, int k1, int k2) {
		if (node == null) {
			return null;
		}
		if (node.getData() == k1 || node.getData() == k2) {
			return node;
		}
		BinarySearchTree leftLCA = LCA_BT(node.getLeft(), k1, k2);
		BinarySearchTree rightLCA = LCA_BT(node.getRight(), k1, k2);
		if (leftLCA != null && rightLCA != null) {
			return node;
		}
		return (leftLCA == null) ? rightLCA : leftLCA;
	}

	public static boolean printAncestorsBinaryTree(BinarySearchTree node, int child) {
		if (node == null) {
			return false;
		}
		if (node.getData() == child) {
			return true;
		}
		if (printAncestorsBinaryTree(node.getLeft(), child) || printAncestorsBinaryTree(node.getRight(), child)) {
			System.out.print("- " + node.getData());
			return true;
		}
		return false;
	}

	public static int BinaryTreetoSumTree(BinarySearchTree node) {
		if (node == null) {
			return 0;
		}
		int oldval = node.getData();
		int newVal = BinaryTreetoSumTree(node.getLeft()) + BinaryTreetoSumTree(node.getRight());
		node.setData(newVal);
		return oldval + newVal;
	}

	public static BinarySearchTree sortedLinkedListToBST() {
		// TODO
		return null;
	}

	public static int findLevelOfANodeInBT(BinarySearchTree node, int nodeVal, int level) {
		if (node == null) {
			return 0;
		}
		if (node.getData() == nodeVal) {
			return level;
		}
		return findLevelOfANodeInBT(node.getLeft(), nodeVal, level + 1)
				| findLevelOfANodeInBT(node.getRight(), nodeVal, level + 1);
	}

	public static void nodeToLeafPathBinaryTree(BinarySearchTree node, int path[], int pathLen) {
		if (node == null) {
			return;
		}
		path[pathLen++] = node.getData();
		if (node.getLeft() == null && node.getRight() == null) {
			for (int i = 0; i < pathLen; i++) {
				System.out.print(" - " + path[i]);
			}
			System.out.println();
		} else {
			nodeToLeafPathBinaryTree(node.getLeft(), path, pathLen);
			nodeToLeafPathBinaryTree(node.getRight(), path, pathLen);
		}
	}

	private static int minValueOfBST(BinarySearchTree node) {
		while (node.getLeft() != null) {
			node = node.getLeft();
		}
		return node.getData();
	}

	private static int maxValueOfBST(BinarySearchTree node) {
		while (node.getRight() != null) {
			node = node.getRight();
		}
		return node.getData();
	}
}
