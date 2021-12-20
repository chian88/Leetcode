package RotateTheBox;
import java.util.*;

class Solution {
	public char[][] rotateTheBox(char[][] box) {
		for (int i = 0; i < box.length; i ++) {
			for (int j = box[i].length - 1; j >= 0; j--) {
				if(box[i][j] == '#') {
					fallToRight(box, i, j);
				}
			}
		}

		int offset = box.length;
		char[][] res = new char[box[0].length][box.length];
		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[i].length; j++) {
				res[j][offset - i - 1] = box[i][j];
			}
		}

		return res;
	}

	void fallToRight(char[][] box, int i, int j) {
		while(j + 1 < box[i].length && box[i][j + 1] == '.') {
			char temp = box[i][j + 1];
			box[i][j + 1] = box[i][j];
			box[i][j] = temp;
			j+= 1;
		}
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.rotateTheBox(new char[][]{{'#','#','*','.','*','.'}, {'#','#','#','*','.','.'}, {'#','#','#','.','#','.'}});
	}
}