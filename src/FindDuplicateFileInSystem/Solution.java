package FindDuplicateFileInSystem;
import java.util.*;

class Solution {
	public static List<List<String>> findDuplicate(String[] paths) {
		Map<String, List<String>> fileSystem = new HashMap<>();


		for (int i = 0; i < paths.length; i++) {
			String path = paths[i];

			String[] items = path.split(" ");



			for (int j = 1; j < items.length; j++) {
				String item = items[j];
				String fileName = item.substring(0, item.indexOf('('));
				StringBuilder filepath = new StringBuilder(items[0]);

				filepath.append("/");
				filepath.append(fileName);
				String content = item.substring(item.indexOf('('));

				if (fileSystem.containsKey(content)) {
					List<String> files = fileSystem.get(content);
					files.add(filepath.toString());
				} else {
					List<String> files = new ArrayList<>();
					files.add(filepath.toString());
					fileSystem.put(content, files);
				}


			}


		}


		List<List<String>> result = new ArrayList<>();

		for (Map.Entry<String, List<String>> entry : fileSystem.entrySet()) {
			if (entry.getValue().size() > 1) {
				result.add(entry.getValue());
			}
		}

		return result;
	}

	public static void main(String[] args) {
		findDuplicate(new String[] {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"});
	}
}