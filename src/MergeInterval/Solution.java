package MergeInterval;
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        boolean newArr = true;
        int[] temp = new int[2];
        Integer currentMaxTail = null;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (newArr) {
                temp = new int[2];
                temp[0] = interval[0];
                currentMaxTail = interval[1];
                newArr = false;
            } else {
                if (currentMaxTail >= interval[0]) {
                    // merge
                    if (interval[1] > currentMaxTail) {
                        currentMaxTail = interval[1];
                    }

                } else {
                    // end the merge

                    temp[1] = currentMaxTail;
                    currentMaxTail = null;
                    result.add(temp);
                    i -= 1;
                    newArr = true;
                }
            }
        }

        if (currentMaxTail != null) {
            temp[1] = currentMaxTail;
            result.add(temp);
        }

        int[][] ans = new int[result.size()][2];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }


        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3}, {2,6}, {8,10}, {15,18}};

        Solution test = new Solution();

        int[][] result = test.merge(arr);
        int x = 1;
    }
}