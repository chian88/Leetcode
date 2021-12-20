package SerializedAndDeserializeNaryTree;
import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Codec {
	// Encodes a tree to a single string.
	int i;
	public String serialize(Node root) {
		StringBuilder res = new StringBuilder();
		if (root == null) {
			return res.toString();
		}

		recursion(root, res);
		return res.toString();
	}

	void recursion(Node node, StringBuilder res) {

		res.append(node.val);
		res.append(",");
		for (int i = 0; i < node.children.size(); i++) {
			recursion(node.children.get(i), res);
		}

		res.append("#");
		res.append(",");
	}

	// Decodes your encoded data to tree.
	public Node deserialize(String data) {
		if (data.length() == 0) {
			return null;
		}
		String[] dataArr = data.split(",");
		i = 0;
		Node n = recursion2(dataArr);
		return n;
	}

	Node recursion2(String[] data) {
		Node node = new Node(Integer.parseInt(data[i]), new ArrayList<>());
		while (!data[i + 1].equals("#")) {
			i++;
			node.children.add(recursion2(data));
		}
		i++;
		return node;
	}

	public static void main(String[] args) {
		Codec test = new Codec();
		String serial = test.serialize(null);
		test.deserialize(serial);
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));