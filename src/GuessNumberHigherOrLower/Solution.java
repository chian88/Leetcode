package GuessNumberHigherOrLower;
class GuessGame {

}
//public class Solution extends GuessGame {
//	public int guessNumber(int n) {
//		int left = 1;
//		int right = n;
//
//		while (left < right) {
//			int mid = left + (right - left) / 2;
//			int result = guess(mid);
//			if (result == 0) {
//				return mid;
//			} else if (result == -1) {
//				right = mid - 1;
//			}  else if (result == 1) {
//				left = mid + 1;
//			}
//		}
//
//		return left;
//	}
//}