package NumberOfStudentsUnableToEatLunch;
import java.util.*;

class Solution {
	public int countStudents(int[] students, int[] sandwiches) {
		Deque<Integer> studentQ = new ArrayDeque<>();

		for (int student : students) {
			studentQ.addLast(student);
		}

		int i = 0;

		int oneRound = students.length;
		int currRound = 0;

		while (!studentQ.isEmpty()) {
			if (sandwiches[i] == studentQ.peekFirst()) {
				studentQ.pollFirst();
				i += 1;
				oneRound = studentQ.size();
				currRound = 0;
			} else {
				studentQ.addLast(studentQ.pollFirst());
				currRound += 1;
			}

			if (currRound >= oneRound) {
				break;
			}
 		}

		return studentQ.size();
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.countStudents(new int[]{1,1,0,0}, new int[]{0,1,0,1});
	}
}