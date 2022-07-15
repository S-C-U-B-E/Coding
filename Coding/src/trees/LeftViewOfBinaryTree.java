package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {
	public static void main(String args[]) {
		Tree tree = new Tree();
		Node root = tree.getTree();

		// BFS
		ArrayList<Integer> leftView = new ArrayList<Integer>();
		leftViewBFS(root, leftView);
		System.out.println(leftView);

		// DFS
//		ArrayList<Integer> leftView = new ArrayList<>();
//		leftViewDFS(root, leftView);
//		System.out.println(leftView);
	}

//BELOW CODE IS WRONG	

//	private static void leftViewDFS(Node root, ArrayList<Integer> leftView) {
//
//		if (root == null)
//			return;
//
//		if (root.left != null)
//			leftViewDFS(root.left, leftView);
//
//		leftView.add(0, root.val);
//
//	}

	private static void leftViewBFS(Node root, ArrayList<Integer> leftView) {

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		while (!q.isEmpty()) {
			int n = q.size();
			for (int i = 1; i <= n; i++) {
				Node temp = q.poll();

				if(i == 1)leftView.add(temp.val); 
	//ADDING ONLY THE 1ST ELEMENT OF QUEUE WILL MAKE SURE THAT THE LEFTMOST NODE OF ANY LEVEL IS ADDED 
				
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);

			}
		}

	}
}
