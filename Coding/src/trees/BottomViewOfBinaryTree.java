package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BottomViewOfBinaryTree {
	public static void main(String args[]) {
		Tree tree = new Tree();
		Node root = tree.getTree();

		HashMap<Integer, Integer> map = new HashMap<>();
		HashMap<Integer, List<Integer>> nodesUnderAHeight = new HashMap<>();
		int[] minMaxHeight = new int[2];
		topView(root, map, 0, minMaxHeight, nodesUnderAHeight);

		System.out.println("***********************************************");
		for (int i = minMaxHeight[0]; i <= minMaxHeight[1]; i++) {
			System.out.println(i + " -> " + map.get(i));
		}
		
		for(Map.Entry<Integer, List<Integer>> entry : nodesUnderAHeight.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}

	}

	private static void topView(Node root, HashMap<Integer, Integer> map, int height, int[] minMaxHeight,
			HashMap<Integer, List<Integer>> nodesUnderAHeight) {

		if (root == null)
			return;

		map.put(height, root.val);
		System.out.println(height+" "+root.val);
		if (!nodesUnderAHeight.containsKey(height))
			nodesUnderAHeight.put(height, new ArrayList<Integer>(root.val));
		
			List<Integer> temp = nodesUnderAHeight.get(height);
			temp.add(root.val);
			nodesUnderAHeight.put(height, temp);
		
			

		if (height < minMaxHeight[0])
			minMaxHeight[0] = height;
		if (height > minMaxHeight[1])
			minMaxHeight[1] = height;

		topView(root.left, map, height - 1, minMaxHeight , nodesUnderAHeight);
		topView(root.right, map, height + 1, minMaxHeight , nodesUnderAHeight);

	}
}
