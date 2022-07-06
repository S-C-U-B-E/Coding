package trees;

public class DiameterOfBinaryTree {
	public static void main(String args[]) {
		Tree tree = new Tree();
		Node root = tree.getTree();
		
		int[] diameter = {-1};
		//No. of nodes on the longest path + 1 = No. of nodes on the longest path
		int height = traverse(root, diameter);

		System.out.println("Diameter : " + diameter[0]); 
	}

	private static int traverse(Node root , int[] diameter) {
		
		
		int left = 0;
		if(root.left != null)
			left = traverse(root.left, diameter);

		int right = 0;
		if(root.right != null)
			right = traverse(root.right, diameter);
		
		diameter[0] = Math.max(diameter[0] , (left + right) + 1);
		//System.out.println(diameter[0]);
		
		return Math.max(left, right) + 1;
	}
}
