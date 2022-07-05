package trees;

import java.util.LinkedList;
import java.util.Queue;

class Node {
	int val;
	Node left;
	Node right;

	Node() {
	}

	public Node(int val, Node left, Node right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public int getVal() {
		return val;
	}
}

public class Tree {

	public static Node root = null;
	public static int[] tree = { 0, 1, 2, 3, 4, 5, 6 };

	Tree() {
		root = new Node(0, null, null);
		root.left = new Node(1, null, null);
		root.right = new Node(2, null, null);
		root.left.left = new Node(3, null, null);
		root.left.right = new Node(4, null, null);
		root.right.left = new Node(5, null, null);
		root.right.right = new Node(6, null, null);
	}

	public Node getTree() {
		return root;
	}

	public static int[] getTreeArray() {
		return tree;
	}

	public static void printTree() {
		traverse(root);
	}

	private static void traverse(Node root) {

		if (root == null)
			return;

		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			int len = q.size();
			for (int i = 0; i < len; i++) {
				Node temp = q.poll();
				if (temp != null) {
					System.out.println(temp.getVal());

					q.add(temp.left);
					q.add(temp.right);
				}
			}
		}
	}
}
