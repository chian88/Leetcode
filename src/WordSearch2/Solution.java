package WordSearch2;
import java.util.*;

class TrieNode {
	HashMap<Character, TrieNode> children = new HashMap<>();
	String word = null;
}

class Solution {
	char[][] board;
	ArrayList<String> res = new ArrayList<>();

	public List<String> findWords(char[][] board, String[] words) {
		TrieNode root = new TrieNode();

		for (String word : words) {
			TrieNode node = root;

			for (Character letter : word.toCharArray()) {
				if (node.children.containsKey(letter)) {
					node = node.children.get(letter);
				} else {
					TrieNode newNode = new TrieNode();
					node.children.put(letter, newNode);
					node = newNode;
				}
			}
			node.word = word;
		}

		this.board = board;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (root.children.containsKey(board[i][j])) {
					backtracking(i, j, root);
				}
			}
		}

		return res;
	}


	void backtracking(int i , int j , TrieNode parent) {
		Character letter = board[i][j];
		TrieNode currNode = parent.children.get(letter);
		if (currNode.word != null) {
			res.add(currNode.word);
			currNode.word = null;
		}

		board[i][j] = '#';

		int[] rowOffset = {-1, 0, 1, 0};
		int[] colOffset = {0, 1, 0, -1};

		for (int dir = 0; dir < 4; dir++) {
			int newRow = i + rowOffset[dir];
			int newCol = j + colOffset[dir];

			if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) {
				continue;
			}

			if (currNode.children.containsKey(board[newRow][newCol])) {
				backtracking(newRow, newCol, currNode);
			}

		}

		board[i][j] = letter;
	}
}