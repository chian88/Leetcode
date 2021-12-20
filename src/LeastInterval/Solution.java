package LeastInterval;

import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];

        for (char task : tasks) {
            frequencies[task - 'A']++;
        }

        Arrays.sort(frequencies);

        int f_max = frequencies[25];

        int idle_time = (f_max - 1) * n;

        for (int i = frequencies.length - 2; i >= 0 && idle_time > 0; i--) {
            idle_time -= Math.min(f_max - 1, frequencies[i]);
        }

        idle_time = Math.max(0, idle_time);

        return idle_time + tasks.length;
    }
}