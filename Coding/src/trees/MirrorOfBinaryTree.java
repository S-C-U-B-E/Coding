package trees;

public class MirrorOfBinaryTree {
	public static void main(String args[]) {
		Tree tree = new Tree();
		Node root = tree.getTree();
		
		Node newNode =  createMirror(root);
		tree.treeTraversal(newNode);
	}

	private static Node createMirror(Node root) {
		
		if(root == null)return null;
		
		Node temp = new Node(root.val, null , null);
		
		temp.right = createMirror(root.left);
		temp.left = createMirror(root.right);
		
		return temp;
	}
	
}
