package DesignFileSystem;
import java.util.*;


class TrieNode {
	Integer val;
	String fileName;
	Map<String, TrieNode> children;

	TrieNode (Integer val, String fileName) {
		this.val = val;
		this.fileName = fileName;
		children = new HashMap<>();
	}
}

class FileSystem {
	TrieNode root;
	public FileSystem() {
		 root = new TrieNode(null, null);
	}

	public boolean createPath(String path, int value) {
		String[] paths = path.split("/");

		TrieNode node = root;
		for( int i = 1; i < paths.length; i++) {
			String p = paths[i];
			if (!node.children.containsKey(p) && i != paths.length - 1 ) {
				return false;
			} else  if (!node.children.containsKey(p)) {
				node.children.put(p, new TrieNode(null, p));
			}

			node = node.children.get(p);
		}
		if (node.val != null) {
			return false;
		}
		node.val = value;
		return true;
	}

	public int get(String path) {
		TrieNode node = root;

		String[] paths = path.split("/");

		for (int i = 1; i < paths.length; i++) {
			String p = paths[i];
			if (!node.children.containsKey(p)) {
				return -1;
			}
			node = node.children.get(p);
		}

		return node.val;
	}

	public static void main(String[] args) {
		FileSystem fileSystem = new FileSystem();

		fileSystem.createPath("/leet", 1); // return true
		fileSystem.createPath("/leet/code", 2); // return true
		fileSystem.get("/leet/code"); // return 2
		fileSystem.createPath("/c/d", 1); // return false because the parent path "/c" doesn't exist.
		fileSystem.get("/c"); // return -1 because this path doesn't exist.
	}
}
