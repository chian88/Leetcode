package CloneGraph;
import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


class Solution {
	public Node cloneGraph(Node node) {
		if (node == null) {
			return null;
		}
		Set<Node> visited = new HashSet<>();
		Node clone = new Node(node.val);

		dfs(node, clone, visited);

		return clone;
	}

	void dfs(Node node, Node clone, Set<Node> visited) {
		List<Node> neighbors = node.neighbors;
		if (neighbors == null) {
			return;
		}

		visited.add(node);
		for (Node neighbor : neighbors) {
			Node clonedNeighbor = new Node (neighbor.val);
			clone.neighbors.add(clonedNeighbor);
			if (!visited.contains(neighbor)) {
				dfs(neighbor, clonedNeighbor, visited);
			}

		}
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);

		one.neighbors.add(two);
		one.neighbors.add(three);
		two.neighbors.add(four);
		two.neighbors.add(one);
		three.neighbors.add(one);
		three.neighbors.add(four);
		four.neighbors.add(two);
		four.neighbors.add(three);

		test.cloneGraph(one);
	}
}











//class Solution {
//	public Node cloneGraph(Node node) {
//		if (node == null) return null;
//		Map<Node, Node> seen = new HashMap<>();
//		Node res = bfs(node, seen);
//
//		return res;
//	}
//
//	Node bfs(Node node, Map<Node, Node>  seen) {
//		if (node == null){
//			return null;
//		}
//
//		if (seen.containsKey(node)) {
//			return seen.get(node);
//		}
//		Node clone = new Node(node.val);
//		seen.put(node, clone);
//
//		List<Node> children = node.neighbors;
//		for (Node child : children) {
//			clone.neighbors.add(bfs(child, seen));
//
//		}
//
//		return clone;
//	}
//
//	public static void main(String[] args) {
//		Node one = new Node(1);
//		Node two = new Node(2);
//		Node three = new Node(3);
//		Node four = new Node(4);
//
//		one.neighbors.add(two);
//		one.neighbors.add(four);
//		two.neighbors.add(one);
//		two.neighbors.add(three);
//		three.neighbors.add(two);
//		three.neighbors.add(four);
//		four.neighbors.add(one);
//		four.neighbors.add(three);
//		Solution test = new Solution();
//		test.cloneGraph(one);
//	}
//}