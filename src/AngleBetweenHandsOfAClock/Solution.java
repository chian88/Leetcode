package AngleBetweenHandsOfAClock;
import java.util.*;

class Solution {
	public double angleClock(int hour, int minutes) {
		double hourDegree = convertHourToDegree(hour, minutes);
		double minuteDegree = convertMinuteToDegree(minutes);
		double diff = Math.abs(hourDegree - minuteDegree);

		diff = Math.min(360 - diff, diff);

		return diff;
	}

	private double convertHourToDegree(int hours, int minutes) {
		if (hours == 12) {
			hours = 0;
		}

		double degree = hours * 30 + minutes * 0.5;

		return degree;
	}

	private double convertMinuteToDegree(int minutes) {
		return minutes * 6.0;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.angleClock(1,57);
	}
}