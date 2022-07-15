package trees;

import java.util.LinkedList;

public class ZigZagTraversal {
	public static void main(String args[]) {
		Tree tree = new Tree();
		Node root = tree.getTree();
		
		LinkedList<Node> deque = new LinkedList<>();
		zigzagTraverse(root , deque);
		
	}

	private static void zigzagTraverse(Node root , LinkedList<Node> deque) {
		
		if(root == null)return;
		
		deque.add(root);
		int level = 1;
		while(!deque.isEmpty()) {
			int n = deque.size();
			
			for(int i=1; i<=n; i++) {
				if(level%2 == 0) {
					Node temp = deque.pollLast();
					System.out.println(temp.val);
					if(temp.right != null)deque.offerFirst(temp.right);
					if(temp.left != null)deque.offerFirst(temp.left);
				}else {
					Node temp = deque.poll();
					System.out.println(temp.val);
					if(temp.left != null)deque.offer(temp.left);
					if(temp.right != null)deque.offer(temp.right);
				}
			}
			
			level++;
		}
		
	}
}
