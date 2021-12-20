package NumberOfProvince;


import java.util.*;
import java.util.LinkedList;


public class Solution {

    int find(int[] cache, int i) {
        if (cache[i] == -1) {
            return i;
        }
        return find(cache, cache[i]);
    }

    void union(int[] cache, int row, int col) {
        int rowSet = find(cache, row);
        int colSet = find(cache, col);

        if (rowSet != colSet) {
            cache[rowSet] = colSet;
        }
    }


    public int findCircleNum(int[][] arr) {
        int[] cache = new int[arr.length];
        Arrays.fill(cache, -1);


        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == 1 && row != col) {
                    union(cache, row, col);
                }
            }
        }

        int count = 0;
        for (int i = 0 ; i < cache.length; i++) {
            if (cache[i] == -1) {
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        Solution test = new Solution();
        int[][] arr = {{1,1,0,0,0,0}, {1,1,0,0,0,0}, {0,0,1,1,1,0}, {0,0,1,1,0,0}, {0,0,1,0,1,0}, {0,0,0,0,0,1}};
//        int[][] arr = {{1,0,0,1}, {0,1,1,0}, {0,1,1,1}, {1,0,1,1}};
        test.findCircleNum(arr);

    }
}














// unionfind

//public class Solution {
//    int find(int parent[], int i) {
//        if (parent[i] == -1)
//            return i;
//        return find(parent, parent[i]);
//    }
//
//    void union(int parent[], int x, int y) {
//        int xset = find(parent, x);
//        int yset = find(parent, y);
//        if (xset != yset)
//            parent[xset] = yset;
//    }
//    public int findCircleNum(int[][] M) {
//        int[] parent = new int[M.length];
//        Arrays.fill(parent, -1);
//        for (int i = 0; i < M.length; i++) {
//            for (int j = 0; j < M.length; j++) {
//                if (M[i][j] == 1 && i != j) {
//                    union(parent, i, j);
//                }
//            }
//        }
//        int count = 0;
//        for (int i = 0; i < parent.length; i++) {
//            if (parent[i] == -1)
//                count++;
//        }
//        return count;
//    }
//
//    public static void main(String[] args) {
//        Solution test = new Solution();
//        int[][] arr = {{1,1,0,0,0,0}, {1,1,0,0,0,0}, {0,0,1,1,1,0}, {0,0,1,1,0,0}, {0,0,1,0,1,0}, {0,0,0,0,0,1}};
////        int[][] arr = {{1,0,0,1}, {0,1,1,0}, {0,1,1,1}, {1,0,1,1}};
//        test.findCircleNum(arr);
//
//    }
//}


// dfs
//class Solution {
//    public int findCircleNum(int[][] isConnected) {
//        LinkedList<Integer> frontier = new LinkedList<>();
//        ArrayList<Integer> visited = new ArrayList<>();
//        int province = 0;
//
//        for (int i = 0; i < isConnected.length; i++) {
//            if (visited.contains(i)) continue;
//            province++;
//            frontier.add(i);
//            performDFS(isConnected, visited, frontier);
//
//        }
//
//        return province;
//    }
//
//    void performDFS (int[][] isConnected, ArrayList<Integer> visited, LinkedList<Integer> frontier) {
//
//        while(!frontier.isEmpty()) {
//            int currentIdx = frontier.removeFirst();
//            visited.add(currentIdx);
//            for (int j = 0 ; j < isConnected[currentIdx].length; j++) {
//                if (visited.contains(j)) continue;
//                if (isConnected[currentIdx][j] == 1) {
//                    frontier.addFirst(j);
//                }
//
//            }
//
//        }
//
//    }
//
//    public static void main(String[] args) {
//        Solution test = new Solution();
//        //int[][] arr = {{1,1,0,0,0,0}, {1,1,0,0,0,0}, {0,0,1,1,1,0}, {0,0,1,1,0,0}, {0,0,1,0,1,0}, {0,0,0,0,0,1}};
//        int[][] arr = {{1,0,0,1}, {0,1,1,0}, {0,1,1,1}, {1,0,1,1}};
//        test.findCircleNum(arr);
//
//    }
//}