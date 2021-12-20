package StringCompression;
import java.util.*;


class Solution {
	public static int compress(char[] chars) {
		int ptr1 = 0;
		int ptr2 = 0;
		int newLength = 0;
		int size = chars.length;
		while ( ptr1 < size) {
			char curr = chars[ptr1];
			int count = 0;

			ptr2 = ptr1;
			while (ptr2 < size && chars[ptr2] == curr) {
				ptr2++;

				count++;
			}

			int space = 0;
			int dummyCount = count;
			while (dummyCount > 0) {
				dummyCount /= 10;
				space++;
			}
			int toShift = count - 1 - space;
			if (toShift > 0) size -= toShift;
			shift(chars, toShift, ptr2);
			if (count > 1) {
				newLength = newLength + (count - toShift);
			} else {
				newLength = newLength + 1;
			}


			while (toShift >= 0 && count > 0) {
				chars[ptr1 + space] = Character.forDigit(count % 10, 10);
				count /= 10;
				space--;
			}


			ptr1 = newLength;
		}

		return newLength;
	}

	private static void shift(char[] chars, int move, int currrentIdx) {
		if (move <= 0) return;

		while (currrentIdx < chars.length) {
			chars[currrentIdx - move] = chars[currrentIdx];
			currrentIdx++;
		}
	}


	public static void main(String[] args) {
		compress(new char[] {'a', 'b'});
	}
}