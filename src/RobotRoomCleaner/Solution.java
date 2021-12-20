package RobotRoomCleaner;
import java.util.*;

  // This is the robot's control interface.
  // You should not implement it, or speculate about its implementation
  interface Robot {
      // Returns true if the cell in front is open and robot moves into the cell.
      // Returns false if the cell in front is blocked and robot stays in the current cell.
      public boolean move();
 
      // Robot will stay in the same cell after calling turnLeft/turnRight.
      // Each turn will be 90 degrees.
      public void turnLeft();
      public void turnRight();
 
      // Clean the current cell.
      public void clean();
  }

  class Point {
	  int x;
	  int y;
	  Point(int x, int y) {
		  this.x = x;
		  this.y = y;
	  }

	  @Override
	  public boolean equals(Object o) {
		  if (this == o) return true;
		  if (o == null || getClass() != o.getClass()) return false;
		  Point point = (Point) o;
		  return x == point.x && y == point.y;
	  }

	  @Override
	  public int hashCode() {
		  return Objects.hash(x, y);
	  }
  }

class Solution {
	  private int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public void cleanRoom(Robot robot) {
		Set<Point> visited = new HashSet<>();
		recursion(robot, 0, 0, visited, 0);
	}

	void goBack(Robot robot) {
		robot.turnRight();
		robot.turnRight();
		robot.move();
		robot.turnRight();
		robot.turnRight();
	}

	void recursion(Robot robot, int row, int col, Set<Point> visited, int d) {
		robot.clean();
		visited.add(new Point(row, col));

		for (int i = 0; i < directions.length; i++) {
			int newD = (d + i) % 4;
			int[] direction = directions[ newD];
			int newRow = row + direction[0];
			int newCol = col + direction[1];

			if (!visited.contains(new Point(newRow, newCol)) && robot.move()) {
				recursion(robot, newRow, newCol, visited, newD);
				goBack(robot);
			}

			robot.turnRight();
		}


	}
}