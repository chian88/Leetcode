package LowestCommonAncestors;

import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}

class Solution {
	public Node lowestCommonAncestor(Node p, Node q) {
		int depthP = findDepth(p);
		int depthQ = findDepth(q);
		if (depthP > depthQ) {
			int diff = depthP - depthQ;
			while (diff > 0) {
				p = p.parent;
				diff--;
			}

		} else if (depthP < depthQ) {
			int diff = depthQ - depthP;
			while (diff > 0) {
				q = q.parent;
				diff--;
			}
		}

		while (p != q) {
			p = p.parent;
			q = q.parent;
		}

		return p;
	}

	int findDepth(Node node) {
		int depth = 0;
		while(node.parent != null) {
			depth += 1;
			node = node.parent;
		}

		return depth;
	}
}