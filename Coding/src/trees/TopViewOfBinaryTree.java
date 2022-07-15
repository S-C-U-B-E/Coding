package trees;

import java.util.ArrayList;
import java.util.HashMap;

public class TopViewOfBinaryTree {
	public static void main(String args[]) {
		Tree tree = new Tree();
		Node root = tree.getTree();

		
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] minMaxHeight = new int[2];
		topView(root,  map,  0 , minMaxHeight);

		for(int i = minMaxHeight[0] ; i <= minMaxHeight[1] ; i++) {
			System.out.println(i + " -> " +map.get(i));
		}

	}

	private static void topView(Node root, HashMap<Integer, Integer> map , int height, int[] minMaxHeight) {
		
		if(root == null)return;
		
		if(!map.containsKey(height))map.put(height, root.val);
		if(height < minMaxHeight[0])minMaxHeight[0] = height;
		if(height > minMaxHeight[1])minMaxHeight[1] = height; 
		
		topView(root.left, map, height - 1 , minMaxHeight);
		topView(root.right, map, height + 1, minMaxHeight);
		
	}
}
