package trees;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	public static void main(String args[]) {
		
		Tree tree = new Tree();
		Node root = tree.getTree();
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
