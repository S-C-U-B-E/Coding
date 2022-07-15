package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfBinaryTree {
	public static void main(String args[]) {
		Tree tree = new Tree();
		Node root = tree.getTree();

		// BFS
		ArrayList<Integer> rightView = new ArrayList<Integer>();
		leftViewBFS(root, rightView);
		System.out.println(rightView);
	}



	private static void leftViewBFS(Node root, ArrayList<Integer> rightView) {

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		while (!q.isEmpty()) {
			int n = q.size();
			for (int i = 1; i <= n; i++) {
				Node temp = q.poll();

				if(i == n)rightView.add(temp.val); 
	//ADDING ONLY THE LAST ELEMENT OF QUEUE WILL MAKE SURE THAT THE LEFTMOST NODE OF ANY LEVEL IS ADDED 
				
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);

			}
		}

	}
}
