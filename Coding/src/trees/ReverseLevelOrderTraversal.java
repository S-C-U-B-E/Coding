package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//    1
//  2   3
// 4 5 6 7

// O/P ->  4 5 6 7 2 3 1


public class ReverseLevelOrderTraversal {
	public static void main(String args[]) {
		Tree tree = new Tree();
		Node root = tree.getTree();
		List<Integer> ans = traverse(root);
		
		System.out.println(ans);
	}

	private static ArrayList<Integer> traverse(Node root) {
		
		ArrayList<Integer> ans = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			int n = q.size();
			for(int i=1; i<=n; i++) {
				Node temp = q.poll();
				ans.add(0, temp.val);  //Adding in 0th index everytime for creating the reverse
				
				if(temp.right != null)q.add(temp.right);
				if(temp.left != null)q.add(temp.left);
			}
		}
		
		return ans;
		
	}
}
