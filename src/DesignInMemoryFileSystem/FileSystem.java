package DesignInMemoryFileSystem;
import java.util.*;



class Directory {
	Map<String, Directory> childDirectories;

	String content;
	boolean file;
	String name;

	Directory(String name) {
		childDirectories = new HashMap<>();
		this.file = false;
		this.name = name;
	}

	Directory(String name, boolean notFile) {
		this.name = name;
		this.file = true;
		this.content = "";
	}

	List<String> ls() {
		ArrayList<String> res = new ArrayList<>();

		Set<String> dirNames = childDirectories.keySet();
		for (String dirName : dirNames) {
			res.add(dirName);
		}

		Collections.sort(res);
		return res;
	}
}



class FileSystem {
	Directory root;
	public FileSystem() {
		root = new Directory("root");
	}

	public List<String> ls(String path) {
		String[] paths = path.split("/");
		Directory node = root;
		for (int i = 1; i < paths.length; i++) {
			String p = paths[i];

			if (node.childDirectories.containsKey(p)) {
				node = node.childDirectories.get(p);
			}
		}

		if (node.file) {
			return new ArrayList<String>(Arrays.asList(node.name));
		} else {
			return node.ls();
		}
	}

	public void mkdir(String path) {
		String[] paths = path.split("/");
		Directory node = root;
		for (int i = 1; i < paths.length; i++) {
			String p = paths[i];
			if (!node.childDirectories.containsKey(p)) {
				node.childDirectories.put(p, new Directory(p));
			}

			node = node.childDirectories.get(p);
		}

	}

	public void addContentToFile(String filePath, String content) {
		String[] paths = filePath.split("/");
		Directory node = root;
		for (int i = 1; i < paths.length; i++) {
			String p = paths[i];
			if (!node.childDirectories.containsKey(p)) {
				node.childDirectories.put(p, new Directory(p, true));
			}

			node = node.childDirectories.get(p);
		}

		node.content += content;
	}

	public String readContentFromFile(String filePath) {
		String[] paths = filePath.split("/");
		Directory node = root;
		for (int i = 1; i < paths.length; i++) {
			String p = paths[i];
			node = node.childDirectories.get(p);
		}

		return node.content;
	}


	public static void main(String[] args) {
		FileSystem test = new FileSystem();

		test.mkdir("/goowmfn");
		test.ls("/goowmfn");
		test.ls("/");
		test.mkdir("/z");
		test.ls("/");
		test.ls("/");
		test.addContentToFile("/goowmfn/c", "shetopcy");
		test.ls("/z");
		test.ls("/goowmfn/c");
		test.ls("/goowmfn");


//		test.ls("/");
//		test.mkdir("/a/b/c");
//		test.addContentToFile("/a/b/c/d", "hello world");
//		test.ls("/");
//		test.readContentFromFile("/a/b/c/d");
//		test.addContentToFile("a/b/c/d", "hello hello world");
//		test.readContentFromFile("/a/b/c/d");
	}
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */