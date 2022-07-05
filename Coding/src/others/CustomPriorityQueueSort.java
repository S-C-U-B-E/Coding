package others;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class CustomPriorityQueueSort {
	public static void main(String args[]) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new customSort());
		
		pq.add(1);
		pq.add(5);
		pq.add(2);
		pq.add(4);
		
		System.out.println(pq);
		int n = pq.size();
		for(int i=0; i<n; i++)System.out.println(pq.poll());
		
		//<ELEMENT , FREQUENCY>
		//SORT BASED ON VALUE, IF VALUES ARE SAME, SORT BASED ON KEYS
		HashMap<Integer , Integer> map = new HashMap<>();
		map.put(1, 1);
		map.put(2, 1);
		map.put(3, 5);
		map.put(4, 2);
		map.put(5, 6);
		map.put(6, 3);
		
		//SORT THE MAP BASED ON FREQUENCY
		PriorityQueue<Map.Entry<Integer, Integer>> mappq = new PriorityQueue<>(new customMapSort());
		for(Map.Entry<Integer, Integer> m : map.entrySet()) {
			mappq.add(m);
		}
		n = mappq.size();
		System.out.println(n);
		for(int i=1; i<=n; i++) {
			Map.Entry<Integer, Integer> m = mappq.poll();
			System.out.println(m.getKey() + " " + m.getValue());
		}
		
	}
}

class customSort implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		if((int)o1 > (int)o2)return -1;
		else if((int)o1 < (int)o2)return 1;
		else return 0;
	}
}


class customMapSort implements Comparator<Map.Entry<Integer, Integer>>{

	@Override
	public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
		if(o1.getValue() == o2.getValue()) {
			return Integer.compare(o1.getKey(), o2.getKey());
		}else {
			return Integer.compare(o1.getValue(), o2.getValue());
		}
	}
	
}


 