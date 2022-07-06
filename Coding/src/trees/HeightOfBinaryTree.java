package trees;

public class HeightOfBinaryTree {
	public static void main(String args[]) {
		Tree tree = new Tree();
		Node root = tree.getTree();
		
		//No. of nodes on the longest path + 1 = No. of nodes on the longest path
		int height = traverse(root);
		
		System.out.println(height); 
	}

	//This will return the no. of edges on the longest path
	private static int traverse(Node root) { 
		
		if(root == null)return 0;
		
		int left = 0;
		if(root.left != null)
			left = traverse(root.left);
		
		int right = 0;
		if(root.right != null)
			right = traverse(root.right);
		
		
		return Math.max(left, right) + 1;
	}
}
