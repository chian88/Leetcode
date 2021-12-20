package RottingOrange;

import java.util.*;



class Solution {

    class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }



    public int orangesRotting(int[][] grid) {
        Queue<Point> frontier = new ArrayDeque<>();
        int freshOrange = 0;
        int minutes = -1;

        for (int row = 0; row < grid.length; row ++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    frontier.offer(new Point(row, col));
                } else if (grid[row][col] == 1) {
                    freshOrange++;
                }
            }
        }

        frontier.offer(new Point(-1, -1));

        while (!frontier.isEmpty()) {
            Point current = frontier.poll();

            if (current.row == -1 || current.col == -1) {
                // new rounds.
                if (!frontier.isEmpty()) {
                    frontier.offer(new Point(-1, -1));
                }
                minutes++;
            } else {
                Point left = new Point(current.row, current.col - 1);
                Point right = new Point(current.row, current.col + 1);
                Point top = new Point(current.row - 1, current.col );
                Point down = new Point(current.row + 1, current.col);

                if (left.col >= 0 && grid[left.row][left.col] == 1) {
                    grid[left.row][left.col] = 2;
                    freshOrange--;
                    frontier.offer(left);

                }

                if (right.col < grid[0].length && grid[right.row][right.col] == 1) {
                    grid[right.row][right.col] = 2;
                    freshOrange--;
                    frontier.offer(right);
                }

                if (top.row >= 0 && grid[top.row][top.col] == 1) {
                    grid[top.row][top.col] = 2;
                    freshOrange--;
                    frontier.offer(top);
                }

                if (down.row < grid.length && grid[down.row][down.col] == 1) {
                    grid[down.row][down.col] = 2;
                    freshOrange--;
                    frontier.offer(down);
                }
            }
        }



        return freshOrange == 0 ? minutes : -1;

    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1}, {1,1,0}, {0,1,1}};

        Solution test = new Solution();
        System.out.println(test.orangesRotting(grid));
    }
}