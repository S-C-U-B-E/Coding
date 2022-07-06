package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {
	public static void main(String args[]) {
		Tree tree = new Tree();
		Node root = tree.getTree();

		//BFS
		Queue<Integer> leftViewqueue = new LinkedList<Integer>();
		leftViewBFS(root, leftViewqueue);
		while(!leftViewqueue.isEmpty())
			System.out.print(leftViewqueue.poll() + " ");
		System.out.println();

		
		//DFS
		ArrayList<Integer> leftView = new ArrayList<>();
		leftViewDFS(root, leftView);
		System.out.println(leftView);
	}

	private static void leftViewDFS(Node root, ArrayList<Integer> leftView) {

		if (root == null)
			return;

		if (root.left != null)
			leftViewDFS(root.left, leftView);

		leftView.add(0, root.val);

	}

	private static void leftViewBFS(Node root, Queue<Integer> leftViewqueue) {

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		while (!q.isEmpty()) {
			int n = q.size();
			for (int i = 1; i <= n; i++) {
				Node temp = q.poll();
				if (temp != null) {
					leftViewqueue.offer(temp.val);
					q.add(temp.left);
				}
			}
		}

	}
}
