package MaximumPopulationYear;
import java.util.*;

class Year {
	boolean alive;
	int year;

	Year(boolean alive, int year) {
		this.alive = alive;
		this.year = year;
	}
}
class Solution {
	public int maximumPopulation(int[][] logs) {

		ArrayList<Year> years = new ArrayList<>();
		for (int[] log : logs) {
			years.add(new Year(true, log[0]));
			years.add(new Year(false, log[1]));
		}



		Collections.sort(years, (a, b) -> {
			int yearCmp = Integer.compare(a.year, b.year);

			if (yearCmp != 0) {
				return yearCmp;
			}

			if (a.alive == false && b.alive == true) {
				return -1;
			} else if (a.alive == true && b.alive == false) {
				return 1;
			}

			return 0;
		});

		int maxPop = Integer.MIN_VALUE;
		int earliestYear = 0;
		int currPop = 0;

		for (Year year : years) {
			if (year.alive == true) {
				currPop += 1;
				if (currPop > maxPop){
					maxPop = currPop;
					earliestYear = year.year;
				}
			} else {
				currPop -= 1;
			}
		}

		return earliestYear;
	}
}